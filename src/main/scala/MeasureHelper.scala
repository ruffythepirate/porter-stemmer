package io.ruffy.porterstemmer

object MeasureHelper {

  def determineMeasure(word: String): Int = {
    case class DetermineState(changeFromVowelCount: Int, lastLetter: Option[Char], lastLetterWasVowel: Boolean)

    val result = word.toLowerCase.foldRight(DetermineState(0, None, false)) {
      (letter, state) =>
        val currentLetterIsVowel = isVowel(letter, state.lastLetter.getOrElse('c'))
        val isChange = if (currentLetterIsVowel && !state.lastLetterWasVowel) 1 else 0

        state.copy(
          state.changeFromVowelCount + isChange,
          Some(letter),
          currentLetterIsVowel)
    }

    val secondToLastCharacter = if(word.length > 1)
      word(word.length - 2)
    else
      'c'

    val lastLetterIsVowelAdjustment = if (isVowel(word.last, secondToLastCharacter))
      1
    else
      0

    result.changeFromVowelCount - lastLetterIsVowelAdjustment
  }

  val PURE_VOWELS = Seq('a', 'e', 'i', 'o', 'u')
  val POTENTIAL_VOWELS = PURE_VOWELS ++ Seq('y')



  def wordContainsVowel(word: String): Boolean = {
    word.toLowerCase.find(letter => POTENTIAL_VOWELS.contains(letter)) != None
  }

  def isAStarOWord(word: String): Boolean = {
    if(word.length > 2)
      isConsonant(word, word.length - 1) && isVowel(word, word.length - 2) && isConsonant(word, word.length - 3) && !Seq('w', 'x', 'y').contains(word.last)
    else
      false
  }

  def endsWithDoubleConsonant(word: String): Boolean = {
    if(word.length < 2)
      false
    else
      word.last == word.charAt(word.length - 2) && !isPureVowel(word.last)
  }

  def isConsonant(word: String, index: Int): Boolean = {
    !isVowel(word, index)
  }

  def isVowel(word: String, index: Int): Boolean = {
    if(index == 0)
      isVowel(word(index), 'l')
    else
      isVowel(word(index), word(index - 1))
  }

  private def isVowel(letter: Char, previousLetter: Char) = {
    if (letter == 'y')
      !isPureVowel(previousLetter)
    else
      isPureVowel(letter)
  }

  private def isPureVowel(letter: Char) = {
    PURE_VOWELS.contains(letter)
  }

}
