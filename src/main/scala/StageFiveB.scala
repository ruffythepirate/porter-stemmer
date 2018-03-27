package io.ruffy.porterstemmer

object StageFiveB extends MeasureFunctionality{

  def transform(word: String): String = {
    word match {
      case s if endsWithAndHasMeasureBiggerThanOne(word, "l")
        && MeasureHelper.endsWithDoubleConsonant(word) => s.dropRight(1)
      case s => s
    }
  }

}
