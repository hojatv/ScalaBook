package book

import java.util.{Calendar, Date}

/**
  * Created by hovaheb on 11/28/2016.
  */
class DateHelper(number: Int) {

  def days(when1: String): Date = {
    var date = Calendar.getInstance()
    when1 match {
      case DateHelper.ago => date.add(Calendar.DAY_OF_MONTH, -number)
      case DateHelper.from_now => date.add(Calendar.DAY_OF_MONTH, +number)
      case "_" => date
    }
    date.getTime
  }

}

object DateHelper {
  val ago = "ago"
  val from_now = "from_now"

  /*3 :: new DateHelper(3)*/
  implicit def convertInt2DateHelper(number: Int) = new DateHelper(number)

  def main(args: Array[String]): Unit = {
    val dateHelper: DateHelper = new DateHelper(2)
    println(dateHelper days ("ago"))


    /*Now, all  we have to do is convert an Int to a DateHelper.*/

    val past = 3 days ago
    val appointment = 5 days from_now

    println(past)
    println(appointment)

  }
}
