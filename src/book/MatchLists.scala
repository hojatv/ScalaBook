package book

/**
  * Created by hovaheb on 11/30/2016.
  */
class MatchLists {
  def processItems(items: List[String]): Unit = {
    items match {
      case List("apple", "ibm") => println("Apples and IBMs")
      case List("red", "blue", "white") => println("stars and Stripes")
      case List("red", "blue", _*) => println("colors red,blue, ...")
      /*If we need to reference the remaining matching elements, we can place a variable name (like otherFruits) before a special @ symbol as in the previous code.*/
      case List("apple", "orange", otherFruits@_*) => println("apples, oranges and " + otherFruits)
    }
  }
  processItems(List("apple", "ibm"))
  processItems(List("red", "blue", "green"))
  processItems(List("red", "blue", "white"))
  processItems(List("apple", "orange", "grapes" , "dates"))

}
object MatchLists{
  def main(args: Array[String]): Unit = {
    val m:MatchLists = new MatchLists

  }
}
