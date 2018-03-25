package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class StageOneATest extends FlatSpec with MustMatchers{


  val stageOneATestCases = Seq(
    ("caresses", "caress"),
    ("ponies", "poni"),
    ("caress", "caress"),
    ("cats", "cat")
  )

  stageOneATestCases.foreach(test => {
    it should s"transform ${test._1} -> ${test._2}" in {
      StageOneA.transform(test._1) must equal(test._2)
    }
  })
}
