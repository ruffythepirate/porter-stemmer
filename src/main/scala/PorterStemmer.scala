package io.ruffy.porterstemmer

object PorterStemmer {

  def stem(word: String): String = {
    var transformedWord = StageOneA.transform(word)
    transformedWord = StageOneB.transform(transformedWord)
    transformedWord = StageOneC.transform(transformedWord)
    transformedWord = StageTwo.transform(transformedWord)
    transformedWord = StageThree.transform(transformedWord)
    transformedWord = StageFour.transform(transformedWord)
    transformedWord = StageFiveA.transform(transformedWord)
    transformedWord = StageFiveB.transform(transformedWord)
    transformedWord
  }
}
