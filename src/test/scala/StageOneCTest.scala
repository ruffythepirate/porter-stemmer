package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}


class StageOneCTest extends FlatSpec with MustMatchers {

  val stageOneCTestCases = Seq(
    ("sky", "sky"),
    ("happy", "happi")
  )

  stageOneCTestCases.foreach(test => {
    it should s"transform ${test._1} -> ${test._2}" in {
      StageOneC.transform(test._1) must equal(test._2)
    }
  })


}
