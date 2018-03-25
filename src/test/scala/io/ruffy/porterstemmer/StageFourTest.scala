package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class StageFourTest extends FlatSpec with MustMatchers{
  
  val testCases = Seq(
    ("revival","reviv"),
    ("mamal","mamal"),
    ("allowance","allow"),
    ("penance","penance"),
    ("inference","infer"),
    ("defence","defence"),
    ("airliner","airlin"),
    ("liner","liner"),
    ("gyroscopic","gyroscop"),
    ("epic","epic"),
    ("adjustable","adjust"),
    ("capable","capable"),
    ("defensible","defens"),
    ("irritant","irrit"),
    ("replacement","replac"),
    ("adjustment","adjust"),
    ("dependent","depend"),
    ("adoption","adopt"),
    ("homologou","homolog"),
    ("communism","commun"),
    ("activate","activ"),
    ("angulariti","angular"),
    ("homologous","homolog"),
    ("effective","effect"),
    ("bowdlerize","bowdler")  
  )

  testCases.foreach( testCase => {
    it should s"transform ${testCase._1} to ${testCase._2}" in {
      StageFour.transform(testCase._1) mustBe testCase._2
    }
  })
}
