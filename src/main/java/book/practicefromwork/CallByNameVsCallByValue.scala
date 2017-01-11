package book.practicefromwork

/**
  * Created by hovaheb on 1/10/2017.
  */
object CallByNameVsCallByValue {
  def something(): Double = {
    println("Do Something")
    Math.random()
  }

  def callByValue(x: Double): Unit = {
    println("x1 = " + x)
    println("x2 = " + x)

  }

  def callByName(x: => Double): Unit = {
    println("x1 = " + x)
    println("x2 = " + x)

  }

  def main(args: Array[String]): Unit = {
    /*This is because call-by-value functions compute the passed-in expression's value before calling the function, thus the same value is
    accessed every time. However, call-by-name functions recompute the passed-in expression's value every time it is accessed.*/
    callByValue(something())
    callByName(something())
    import scala.math.BigInt
    lazy val fibs: Stream[BigInt] = BigInt(0) #::
      BigInt(1) #::
      fibs.zip(fibs.tail).map { n => n._1 + n._2 }

  }


}
