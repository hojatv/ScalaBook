package book.exceptionhandling

/**
  * Created by hovaheb on 12/14/2016.
  */
class CheckedExceptions {
  def taxFor(amount: Double): String = {
    if (amount < 0) throw new IllegalArgumentException("Amount must be greater than zero")
    if (amount < 0.1) throw new RuntimeException("Amount is too small")
    if (amount > 1000000) throw new Exception("Amount is too big")
    "Tax is : " + amount * 0.08
  }

  for (i <- List(100.0, 0.09, -2.0, 1000001.0)) {
    try {
      println(taxFor(i))
    }
    catch {
      case ex: IllegalAccessException => println(ex.getMessage)
      case ex: RuntimeException => println(ex.getMessage)
      /*case ex: Exception => println(ex.getMessage)*/
      case _ => println("Something went wrong")
    }
  }



  try {
    val str = "hello"
    println(str(31))
  }
  catch {
    case ex : Exception => println("Exception caught" )
    case ex : StringIndexOutOfBoundsException => println("Invalid Index" )
  }

}
object CheckedExceptions{
  def main(args: Array[String]): Unit = {
    val c: CheckedExceptions = new CheckedExceptions
  }
}
