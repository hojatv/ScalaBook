package book

/**
  * Created by hovaheb on 11/28/2016.
  */
class UsingSet {
  val colors1 = Set("Blue", "Red" , "Green")
  var colors = colors1
  println("colors1 (colors): "  + colors)

  colors += "Black"

  println("Colors1 colors: " + colors1)
  println("Colors colors: " + colors)

  println(colors1.getClass().getName)
  println(colors.getClass().getName)

}
object UsingSet{
  def main(args: Array[String]): Unit = {
    val usingSet: UsingSet = new UsingSet

  }
}
