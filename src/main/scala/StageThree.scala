package io.ruffy.porterstemmer

object StageThree extends MeasureFunctionality{

  def transform(word: String) : String = {
    word match {
      case s if endsWithAndHasMeasureBiggerThanZero(word, "icate") => s.dropRight(5) + "ic"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ative") => s.dropRight(5)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "alize") => s.dropRight(5) + "al"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "iciti") => s.dropRight(5) + "ic"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ical") => s.dropRight(4) + "ic"
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ful") => s.dropRight(3)
      case s if endsWithAndHasMeasureBiggerThanZero(word, "ness") => s.dropRight(4)
      case s => s
    }
  }
}
