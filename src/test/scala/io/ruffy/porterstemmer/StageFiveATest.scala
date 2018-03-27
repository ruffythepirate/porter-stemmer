package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class StageFiveATest  extends FlatSpec with MustMatchers{

  val testCases = Seq(
    ("probate","probat"),
    ("rate","rate"),
    ("cease","ceas")
  )

  testCases.foreach( testCase => {
    it should s"transform ${testCase._1} to ${testCase._2}" in {
      StageFiveA.transform(testCase._1) mustBe testCase._2
    }
  })
}
