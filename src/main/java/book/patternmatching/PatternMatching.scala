package book.patternmatching

/**
  * Created by hovaheb on 1/25/2017.
  */
object PatternMatching {
  val MAX = 100
  val MIN = 0

  def main(args: Array[String]): Unit = {
    activity(DayOfWeek.SUNDAY)
    activity(DayOfWeek.MONDAY)
    activity(DayOfWeek(3))

    activityJava(DaysOfWeek.SATURDAY)
    activityJava(DaysOfWeek.FRIDAY)

    processingCoordinates((2,5))
    //processingCoordinates((2,"a"))
    processingCoordinates(21)
    processingCoordinates("done")

    processItems(List("A","B"))
    processItems(List("A","B" , "C"))
    processItems(List("A","B" , "CD"))
    processItems(List("A1","B1" , "CD", "F"))

    process(100)
    process(0)


  }

  def activity(dayOfWeek: DayOfWeek.Value): Unit = {
    dayOfWeek match {
      case DayOfWeek.SATURDAY => println("Saturday Activity")
      case DayOfWeek.SUNDAY => println("Sunday Activity")
      /*case DayOfWeek.MONDAY => println("Monday Activity")
      case DayOfWeek.TUESDAY => println("Tuesday Activity")
      case DayOfWeek.WEDNESDAY => println("Wednesday Activity")
      case DayOfWeek.THURSDAY => println("Thursday Activity")
      case DayOfWeek.FRIDAY => println("Friday Activity")*/
      case _ => println("Working")
    }
  }

  def activityJava(dayOfWeek: DaysOfWeek): Unit = {
    dayOfWeek match {
      case DaysOfWeek.SATURDAY => println("Saturday Activity")
      case DaysOfWeek.SUNDAY => println("Sunday Activity")
      case _ => println("Working")

    }
  }
  def processingCoordinates(input:Any): Unit ={
    input match {
      case (a,b) => printf("Processing %d,%d \n" , a,b)
      case ("done") => println("Done")
      case _ => println("not defined")
    }
  }
  def processItems(items:List[String]): Unit ={
    items match {
      case List ("A" , "B") => println("A , B")
      case List ("A" , "B" , "C") => println("3 ta")
      case List ("A" , "B" , _*) => println("A , B and others")
      case List("A1" , "B1" , others @_*) => println("A , B and " + others.mkString(", "))
    }
  }
  def process(item:Int): Unit ={
    item match {
      case max => println("max")
      case MIN => println("min")
    }
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
