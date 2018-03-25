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

  def stageTwo(word: String) = {
    val measure = MeasureHelper.determineMeasure(word)
    word match {
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ational") => s.dropRight(7) + "ate"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "tional") => s.dropRight(6) + "tion"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "enci") => s.dropRight(4) + "ence"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "anci") => s.dropRight(4) + "ance"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "izer") => s.dropRight(4) + "ize"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "abli") => s.dropRight(4) + "able"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "alli") => s.dropRight(4) + "al"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "entli") => s.dropRight(5) + "ent"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "eli") => s.dropRight(3) + "e"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ousli") => s.dropRight(5) + "ous"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ization") => s.dropRight(7) + "ize"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ation") => s.dropRight(5) + "ate"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ator") => s.dropRight(4) + "ate"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "alism") => s.dropRight(5) + "al"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "iveness") => s.dropRight(7) + "ive"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "fulness") => s.dropRight(7) + "ful"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ousness") => s.dropRight(7) + "ous"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "aliti") => s.dropRight(5) + "al"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "iviti") => s.dropRight(5) + "ive"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "biliti") => s.dropRight(6) + "ble"
      case s => s
    }
  }

  private def endsWithAndHasMeasureBiggerThanZero(word:String, ending: String) = {
    word.endsWith(ending) && MeasureHelper.determineMeasure(word.dropRight(ending.length)) > 0
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
