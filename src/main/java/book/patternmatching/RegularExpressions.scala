package book.patternmatching

/**
  * Created by hovaheb on 1/26/2017.
  */
object RegularExpressions {
  def main(args: Array[String]): Unit = {
    val pattern = "(S|s)cala".r
    val str = "Scala is scalable and fun"
    println(pattern findFirstIn str mkString(",")) /*Scala implicitly converts the String to a RichString and invokes that method to get an instance of Regex.*/
    println(pattern findAllIn str mkString(","))
    println("fun".r replaceFirstIn(str,"awesome"))

  }

}
