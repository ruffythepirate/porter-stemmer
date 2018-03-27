package io.ruffy.porterstemmer

object StageFiveA extends MeasureFunctionality{

  def transform(word: String): String = {
    word match {
      case s if endsWithAndHasMeasureBiggerThanOne(word, "e") => s.dropRight(1)
      case s if endsWithAndHasMeasureBiggerIsOne(word, "e") &&
      !MeasureHelper.isAStarOWord(word.dropRight(1))=> s.dropRight(1)
      case s => s
    }
  }

}
