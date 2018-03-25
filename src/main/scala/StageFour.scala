package io.ruffy.porterstemmer

object StageFour extends MeasureFunctionality {

  def transform(word: String): String = {
    word match {
      case s if endsWithAndHasMeasureBiggerThanOne(word, "al") => s.dropRight(2)
      case s if endsWithAndHasMeasureBiggerThanOne(word, "ance") => s.dropRight(4)
      case s if endsWithAndHasMeasureBiggerThanOne(word, "ence") => s.dropRight(4)
      case s if endsWithAndHasMeasureBiggerThanOne(word, "er") => s.dropRight(2)
      case s if endsWithAndHasMeasureBiggerThanOne(word, "ic") => s.dropRight(2)
      case s if endsWithAndHasMeasureBiggerThanOne(word, "able") => s.dropRight(4)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ible") => s.dropRight(4)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ant") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ement") => s.dropRight(5)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ment") => s.dropRight(4)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ent") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ion") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ou") => s.dropRight(2)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ism") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ate") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "iti") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ous") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ive") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ize") => s.dropRight(3)
      case s => s
    }
  }
}
