name := "porter-stemmer"

version := "1.0"

scalaVersion := "2.12.4"


val testDependencies = Seq("org.scalatest" %% "scalatest" % "3.0.1")
          .map(lib => lib % "test")

libraryDependencies ++= testDependencies