package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}



class MeasureFunctionalityTest extends FlatSpec with MustMatchers{

  object Test extends MeasureFunctionality {}

  val testCases = Seq(
    ("conditional", "tional",true),
    ("rational",    "tional",false)
  )

  testCases.foreach(testCase => {
    it should s"say ${testCase._3} to the word root having measure > 0 for ${testCase._1}" in {
      Test.endsWithAndHasMeasureBiggerThanZero(testCase._1, testCase._2) mustBe testCase._3
    }
  })
}
