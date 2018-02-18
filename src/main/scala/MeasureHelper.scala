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
