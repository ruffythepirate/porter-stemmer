package io.ruffy.porterstemmer

object StageOneA {

  def transform(word: String) = {
    word match {
      case s : String if s.endsWith("sses") => s.dropRight(4) + "ss"
      case s : String if s.endsWith("ies") => s.dropRight(3) + "i"
      case s : String if s.endsWith("ss") => s
      case s : String if s.endsWith("s") => s.dropRight(1)
      case _ => word
    }
  }

}
