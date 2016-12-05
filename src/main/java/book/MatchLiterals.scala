package book

/**
  * Created by hovaheb on 11/30/2016.
  */
class MatchLiterals {
  def activity(day: String): Unit = {
    day match {
      case "Sunday" => println("Eat, Sleep. Repeat...")
      case "Saturday" => println("Hangout with friends...")
      case "Monday" => println("...code for fun...")
      case "Friday" => println("...Read a goof book...")
      case _ => println("... no plan...")
    }
  }

  List("Monday", "Sunday", "Friday", "Tuesday").foreach {
    activity
  }


  def activity(day: DayOfWeek.Value) {
    day match {
      case DayOfWeek.SUNDAY => println("Eat, sleep, repeat...")
      case DayOfWeek.SATURDAY => println("Hangout with friends")
      case _ => println("...code for fun...")
    }
  }

  activity(DayOfWeek.SATURDAY)
  activity(DayOfWeek.MONDAY)

}

object MatchLiterals {
  def main(args: Array[String]): Unit = {
    val m: MatchLiterals = new MatchLiterals
    println(DayOfWeek(0))

  }
}

object DayOfWeek extends Enumeration {
  val SUNDAY = Value("Sunday")
  val MONDAY = Value("Monday")
  val TUESDAY = Value("Tuesday")
  val WEDNESDAY = Value("Wednesday")
  val THURSDAY = Value("Thursday")
  val FRIDAY = Value("Friday")
  val SATURDAY = Value("Saturday")
}

