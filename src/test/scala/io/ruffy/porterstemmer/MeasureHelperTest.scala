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

  val endsWithTwoConsonants = Seq(
    ("Blall", true),
    ("Wall", true),
    ("Grr", true),
    ("Gram", false),
    ("Blues", false)
  )

  endsWithTwoConsonants.foreach(test => {
    it should s"Say EndsWithTwoConsonants ${test._2} for ${test._1}" in {
      MeasureHelper.endsWithDoubleConsonant(test._1) must equal(test._2)
    }
  })

  val isConsonantTests = Seq(
    ("Hello", 0, true),
    ("Hello", 1, false),
    ("Yellow", 0, true),
    ("Belly", 4, false)
  )

  isConsonantTests.foreach(test => {
    it should s"Say is Consonant ${test._3} for ${test._1} index ${test._2}" in {
      MeasureHelper.isConsonant(test._1, test._2) must equal(test._3)
    }
    it should s"Say is Vowel ${!test._3} for ${test._1} index ${test._2}" in {
      MeasureHelper.isVowel(test._1, test._2) must equal(!test._3)
    }
  })

  val isStarOTests = Seq(
    ("Fail", false),
    ("Fil", true),
    ("Fax", false)
  )

  isStarOTests.foreach(test => {
    it should s"Say starO = ${test._2} for ${test._1}" in {
      MeasureHelper.isAStarOWord(test._1) must equal(test._2)
    }
  })
}
