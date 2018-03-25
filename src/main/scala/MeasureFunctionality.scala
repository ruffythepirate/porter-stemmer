package io.ruffy.porterstemmer

trait MeasureFunctionality {
  def endsWithAndHasMeasureBiggerThanZero(word:String, ending: String) = {
    word.endsWith(ending) && MeasureHelper.determineMeasure(word.dropRight(ending.length)) > 0
  }
}
