

name := "porter-stemmer"

version := "0.13.6"

scalaVersion := "2.12.4"

val testDependencies = Seq("org.scalatest" %% "scalatest" % "3.0.1")
          .map(lib => lib % "test")

lazy val measurePerformance = taskKey[Unit]("Execute the shell script to compare execution time against base implementation.")

measurePerformance := {
  "./time-execution.sh" !
}

libraryDependencies ++= testDependencies
