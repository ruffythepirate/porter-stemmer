
trait EndingFunctionality {

  def stemEndsWith(word: String, endingSize: Int, letters: String) = {
    if( endingSize >= word.size)
      false
    else
      letters.contains(word(word.size - endingSize - 1))
  }
}
