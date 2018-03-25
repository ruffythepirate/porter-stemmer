package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class StageThreeTest extends FlatSpec with MustMatchers {

  val testCases = Seq(
    ("triplicate", "triplic"),
    ("formative", "form"),
    ("formalize", "formal"),
    ("electriciti", "electric"),
    ("electrical", "electric"),
    ("hopeful", "hope"),
    ("goodness", "good")
  )

  testCases.foreach(testCase => {
    it should s"transforms ${testCase._1} to ${testCase._2}" in {
      StageThree.transform(testCase._1) mustBe testCase._2
    }

  })

}
