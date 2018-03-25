package io.ruffy.porterstemmer

object StageOneC {
  def transform(word: String) = {
    word match {
      case s if s.last == 'y' && MeasureHelper.wordContainsVowel(s.dropRight(1))
        => s.dropRight(1) + 'i'
      case s => s
    }
  }
}
