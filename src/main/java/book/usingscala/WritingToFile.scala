package book.usingscala

import java.io.{File, PrintWriter}

/**
  * Created by hovaheb on 12/14/2016.
  */
object WritingToFile {
  def main(args: Array[String]): Unit = {
    val writer = new PrintWriter(new File("test.txt"))
    writer write "ABC"
    writer close
  }

}
