package book.cuncurrentprogramming

/**
  * Created by hovaheb on 12/23/2016.
  */
class PerfectNumberFinder {
  //START:ISPERFECT
  def sumOfFactors(number: Int) = {
    (0 /: (1 to number)) { (sum, i) => if (number % i == 0) sum + i else sum }
  }

  def isPerfect(candidate: Int) = 2 * candidate == sumOfFactors(candidate)
  //END:ISPERFECT

  //START:EXERCISE
  println("6 is perfect? " + isPerfect(6))
  println("335503360 is perfect? " + isPerfect(335503360))
  println("335503370 is perfect? " + isPerfect(335503370))
  //END:EXERCISE

}
object PerfectNumberFinder{
  def main(args: Array[String]): Unit = {
    val p:PerfectNumberFinder = new PerfectNumberFinder
  }
}
