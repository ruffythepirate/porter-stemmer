package io.ruffy.porterstemmer

object PorterStemmer {

  def stageOneA(word: String) = {
    word match {
      case s : String if s.endsWith("sses") => s.dropRight(4) + "ss"
      case s : String if s.endsWith("ies") => s.dropRight(3) + "i"
      case s : String if s.endsWith("ss") => s
      case s : String if s.endsWith("s") => s.dropRight(1)
      case _ => word
    }
  }

  def stageOneB(word: String) = {
    word match {
      case s if s.endsWith("eed") && MeasureHelper.determineMeasure(word.dropRight(3)) > 0  => s.dropRight(1)
      case s => s
    }
  }
}
