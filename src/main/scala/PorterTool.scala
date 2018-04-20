import java.io.{BufferedReader, InputStreamReader, OutputStreamWriter}

import io.ruffy.porterstemmer.PorterStemmer

import scala.concurrent.Future


object PorterTool extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  System.out.println("Hello?")

  val inputStreamReader = new InputStreamReader(System.in)
  val bufferedReader = new BufferedReader(inputStreamReader)

  val lineIterator = Iterator
    .continually(bufferedReader.readLine)

  var processingStarted = false

  Future{
    Thread.sleep(10000)

    if(!processingStarted) {
      println("Exiting application because of inactivity!")
      Runtime.getRuntime.halt(1)
    }
  }

  lineIterator
    .takeWhile(_ != null)
    .map(str => {
      processingStarted = true
      str
    })
    .flatMap(str => str.split("\\s"))
    .foreach(str => {
      print(PorterStemmer.stem(str) + " ")
    })

  def print(string: String) = {
    System.out.print(string)
    System.out.flush()
  }

  def println(string: String) = {
    System.out.println(string)
    System.out.flush()
  }
}
