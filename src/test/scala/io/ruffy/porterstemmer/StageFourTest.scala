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
    ("audible","audible"),
    ("irritant","irrit"),
    ("blatant","blatant"),
    ("replacement","replac"),
    ("cement","cement"),
    ("adjustment","adjust"),
    ("lament","lament"),
    ("dependent","depend"),
    ("parent","parent"),
    ("adoption","adopt"),
    ("concession","concess"),
    ("option","option"),
    ("rebellion","rebellion"),
    ("homologou","homolog"),
    ("milou","milou"),
    ("communism","commun"),
    ("purism","purism"),
    ("activate","activ"),
    ("relate","relate"),
    ("angulariti","angular"),
    ("tahiti","tahiti"),
    ("homologous","homolog"),
    ("porous","porous"),
    ("effective","effect"),
    ("alive","alive"),
    ("bowdlerize","bowdler"),
    ("theorize","theorize")
  )

  testCases.foreach( testCase => {
    it should s"transform ${testCase._1} to ${testCase._2}" in {
      StageFour.transform(testCase._1) mustBe testCase._2
    }
  })
}
