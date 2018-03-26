import org.scalatest.{FlatSpec, FunSuite, MustMatchers}

class EndingFunctionalityTest extends FlatSpec with MustMatchers {

  object Test extends EndingFunctionality {}

  val testCases = Seq(
    ("Hello", 1, "oeh", false),
    ("Hello", 1, "l", true),
    ("Hello", 7, "l", false)
  )

  testCases.foreach( testCase => {
    it should s"say ${testCase._4} that ${testCase._1} ends with something in '${testCase._3}'" in {
      Test.stemEndsWith(testCase._1, testCase._2, testCase._3) mustBe testCase._4
    }
  })
}
