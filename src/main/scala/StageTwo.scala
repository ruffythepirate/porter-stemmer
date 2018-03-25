package io.ruffy.porterstemmer

object StageTwo extends MeasureFunctionality {
 def transform(word: String) = {
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


}
