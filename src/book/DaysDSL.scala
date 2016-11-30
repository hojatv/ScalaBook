package book

/**
  * Created by hovaheb on 11/28/2016.
  */
import  DateHelper._
class DaysDSL {
  val past = 2 days ago
  val appointment = 5 days from_now
  println(past)
  println(appointment)
}
object DaysDSL{
  def main(args: Array[String]): Unit = {
    val d:DaysDSL = new DaysDSL

  }
}
