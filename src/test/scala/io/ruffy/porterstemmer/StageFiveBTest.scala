package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class StageFiveBTest extends FlatSpec with MustMatchers {


  val testCases = Seq(
    ("controll","control"),
    ("roll","roll")
  )

  testCases.foreach( testCase => {
    it should s"transform ${testCase._1} to ${testCase._2}" in {
      StageFiveB.transform(testCase._1) mustBe testCase._2
    }
  })

}
