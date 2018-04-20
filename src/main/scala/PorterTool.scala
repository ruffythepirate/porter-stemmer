import java.io._

import io.ruffy.porterstemmer.PorterStemmer

import scala.concurrent.Future
import scala.util.Try


object PorterTool extends App {

  if (args.length > 0)
    PorterToolFromFile.run(args)
  else
    PorterToolFromSystemIn.run()
}

object PorterToolFromFile {
  def run(args: Array[String]) = {

    Try{
      new FileInputStream(args(0))
    }.map( stream =>
      PorterToolFromStream.run(stream)
    ).recover{
      case e => println("bummer")
    }
  }
}

object PorterToolFromStream {
  def run(inputStream: InputStream) = {
    import scala.concurrent.ExecutionContext.Implicits.global
    val inputStreamReader = new InputStreamReader(inputStream)
    val bufferedReader = new BufferedReader(inputStreamReader)

    val lineIterator = Iterator
      .continually(bufferedReader.readLine)

    var processingStarted = false

    Future {
      Thread.sleep(10000)
      if (!processingStarted) {
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

  }

  def print(string: String) = {
    System.out.print(string)
    System.out.flush()
  }

  def println(string: String) = {
    System.out.println(string)
    System.out.flush()
  }

}

object PorterToolFromSystemIn {
  def run() = {
    PorterToolFromStream.run(System.in)
  }

}