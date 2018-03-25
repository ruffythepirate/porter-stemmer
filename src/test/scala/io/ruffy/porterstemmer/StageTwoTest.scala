package io.ruffy.porterstemmer

import org.scalatest.{FlatSpec, MustMatchers}

class StageTwoTest extends FlatSpec with MustMatchers {


  val stageTwoTestCases = Seq(

    ("relational", "relate"),
    ("conditional", "condition"),
    ("rational", "rational"),
    ("valenci", "valence"),
    ("hesitanci", "hesitance"),
    ("digitizer", "digitize"),
    ("conformabli", "conformable"),
    ("radicalli", "radical"),
    ("differentli", "different"),
    ("vileli", "vile"),
    ("analogousli", "analogous"),
    ("vietnamization", "vietnamize"),
    ("predication", "predicate"),
    ("operator", "operate"),
    ("feudalism", "feudal"),
    ("decisiveness", "decisive"),
    ("hopefulness", "hopeful"),
    ("callousness", "callous"),
    ("formaliti", "formal"),
    ("sensitiviti", "sensitive"),
    ("sensibiliti", "sensible")
  )

  stageTwoTestCases.foreach(test => {
    it should s"transform ${test._1} -> ${test._2}" in {
      StageTwo.transform(test._1) must equal(test._2)
    }
  })
}
