package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}


class StageOneBTest extends FlatSpec with MustMatchers {

  val stageOneBTestCases = Seq(
    ("feed", "feed"),
    ("agreed", "agree"),
    ("plastered", "plaster"),
    ("bled", "bled"),
    ("motoring", "motor"),
    ("sing", "sing"),
    ("conflated", "conflate"),
    ("troubled", "trouble"),
    ("sized", "size"),
    ("hopping", "hop"),
    ("tanned", "tan"),
    ("falling", "fall"),
    ("hissing", "hiss"),
    ("fizzing", "fizz"),
    ("failing", "fail"),
    ("filing", "file")

  )

  stageOneBTestCases.foreach(test => {
    it should s"transform ${test._1} -> ${test._2}" in {
      StageOneB.transform(test._1) must equal(test._2)
    }
  })


}
