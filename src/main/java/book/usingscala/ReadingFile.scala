package book.usingscala

import java.net.URL

import scala.io.Source

/**
  * Created by hovaheb on 12/14/2016.
  */
object ReadingFile {
  def main(args: Array[String]): Unit = {
    Source.fromFile("test.txt").foreach {
      print
    }

    val webSource = Source.fromURL(new URL("http://www.scala-lang.org/docu/files/api/index.html"))
    var counter: Int = 0
    for (i <- webSource.getLines()) {
      if (counter == 4) {
        println("\n"+i)
        val content = i.mkString
        val VersionRegEx = """[\D\S]+scaladoc\s+\(version\s+(.+)\)[\D\S]+""".r
        content match {
          case VersionRegEx(version) => println("Scala doc for version: " + version)
          case _ => println("nabood")
        }
      }
      counter += 1
    }
  }
}
