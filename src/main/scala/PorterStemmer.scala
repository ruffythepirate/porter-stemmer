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
      case s if s.endsWith("ed") && MeasureHelper.wordContainsVowel(word.dropRight(2)) =>
        stageOneBOnSecondOrThirdTrigger(s.dropRight(2))
      case s if s.endsWith("ing") && MeasureHelper.wordContainsVowel(word.dropRight(3))  =>
        stageOneBOnSecondOrThirdTrigger(s.dropRight(3))
      case s => s
    }
  }

  def stageOneC(word: String) = {
    word match {
      case s if s.last == 'y' && MeasureHelper.wordContainsVowel(s.dropRight(1))
        => s.dropRight(1) + 'i'
      case s => s
    }
  }

  val NON_APPLIED_DOUBLE_CONSONANTS = Seq('l', 's', 'z')

  private def stageOneBOnSecondOrThirdTrigger(word: String) = {
     word match {
      case s if (s.endsWith("at") || s.endsWith("bl") || s.endsWith("iz"))
        => s + "e"
      case s if (!NON_APPLIED_DOUBLE_CONSONANTS.contains(s.last)
        && MeasureHelper.endsWithDoubleConsonant(word)) && !Seq('s', 'z','l').contains(word.last)
      =>
        s.dropRight(1)
      case s if (MeasureHelper.isAStarOWord(word) && MeasureHelper.determineMeasure(s) == 1)
        =>
        s + "e"
      case s => s
    }
  }


}
