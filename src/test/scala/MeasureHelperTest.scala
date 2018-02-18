package io.ruffy.porterstemmer
import org.scalatest.{FlatSpec, MustMatchers}

class MeasureHelperTest extends FlatSpec with MustMatchers{

  val testCases = Seq(
    ("Tree", 0),
    ("y", 0),
    ("Tr", 0),
    ("Feed", 1),
    ("Ivy", 1),
    ("Trouble", 1),
    ("Darts", 1),
    ("Trees", 1),
    ("Troubles", 2),
    ("Private", 2)
  )

  testCases.foreach(test => {
    it should s"Identify measure as ${test._2} for ${test._1}" in {
      MeasureHelper.determineMeasure(test._1) must equal(test._2)
    }
  })

  val containsVowelTests = Seq(
    ("Hey", true),
    ("I", true),
    ("y", true),
    ("Gr", false),
    ("Bl", false)
  )

    containsVowelTests.foreach(test => {
    it should s"Say ContainsVowel ${test._2} for ${test._1}" in {
      MeasureHelper.wordContainsVowel(test._1) must equal(test._2)
    }
  })

}
