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
      case s if s.endsWith("eed") =>
        if(MeasureHelper.determineMeasure(word.dropRight(3)) > 0)
          s.dropRight(1)
        else
          s
      case s if s.endsWith("ed") && MeasureHelper.wordContainsVowel(word.dropRight(2)) => s.dropRight(2)
      case s if s.endsWith("ing") && MeasureHelper.wordContainsVowel(word.dropRight(3))  => s.dropRight(3)
      case s => s
    }
  }
}
