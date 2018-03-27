package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class PorterStemmerTest extends FlatSpec with MustMatchers {

  val testCases = Seq(
    ("really", "realli"),
    ("think", "think"),
    ("weakness", "weak"),
    ("yields", "yield"),
    ("temptation", "temptat")
  )

  testCases.foreach( testCase => {
    it should s"transform ${testCase._1} to ${testCase._2}" in {
      PorterStemmer.stem(testCase._1) mustBe testCase._2
    }
  })
}
