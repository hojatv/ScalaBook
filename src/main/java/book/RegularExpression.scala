package book

/**
  * Created by hovaheb on 12/2/2016.
  */
class RegularExpression {

}
object RegularExpression{
  def main(args: Array[String]): Unit = {
    val pattern = "(S|s)cala".r
    val str = "Scala is scalable and cool"
    println(pattern findFirstIn str)
    println((pattern findAllIn  str).mkString(", "))
    println("cool".r.replaceFirstIn(str,"awesome"))
  }
}
