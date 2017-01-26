package book

/**
  * Created by hovaheb on 11/24/2016.
  */
class OptionType {
  def commentOnPractice(input: String): Option[String] = {
    if (input == "test")
      Some("good")
    else
      None
  }

  def maxValues(values: Int*) = {
    values.foldLeft(values(0)) {
      Math.max
    }
  }

}

object OptionType {
  def main(args: Array[String]) {
    val o: OptionType = new OptionType()
    for (input <- Set("test", "hack")) {
      val comment = o.commentOnPractice(input)
      println("input: " + input + " and comment: " + comment + comment.getOrElse("Found no comments"))
    }
    println(o.maxValues(1,2,3))
    val numbers = Array(2, 5, 3, 7, 1, 6)

    /*exploding the array into discrete values—use the series of symbols : _**/
    println(o.maxValues(numbers:_*))
  }
}
class Sample {
  val max = 100
  val MIN = 0
  def process(input: Int) {
    input match {
      case max => println("Don't try this at home" ) // Compiler error
      case MIN => println("You matched min" )
      case _ => println("Unreachable!!" )
    }
  }
}
