package book

import java.util.Date

/**
  * Created by hovaheb on 11/25/2016.
  */
class PartiallyAppliedFunctions {
  def log (date: Date , message:String ): Unit ={
    println("date: " + date + " and massage: " + message)
  }

}
object PartiallyAppliedFunctions{
  def main(args: Array[String]) {
    val p:PartiallyAppliedFunctions = new PartiallyAppliedFunctions
    p.log(new Date(), "message1")
    p.log(new Date(), "message2")
    p.log(new Date(), "message3")

    /*When you create a partially applied function, Scala internally creates a
    new class with a special apply( ) method*/
    val logWithDateBound = p.log(new Date(),_:String)
    logWithDateBound("message1")
    logWithDateBound("message2")
    logWithDateBound("message3")

  }
}
