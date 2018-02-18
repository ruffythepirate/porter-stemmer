package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}


class StageOneBTest extends FlatSpec with MustMatchers{

  val stageOneBTestCases = Seq(
    ("feed", "feed"),
    ("agreed", "agree")
  )

  stageOneBTestCases.foreach(test => {
    it should s"transform ${test._1} -> ${test._2}" in {
      PorterStemmer.stageOneB(test._1) must equal(test._2)
    }
  })


}
