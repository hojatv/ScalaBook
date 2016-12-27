package book

/**
  * Created by hovaheb on 12/27/2016.
  */
object TestingFoldLeft {
  def main(args: Array[String]): Unit = {
    def sumOfFactors(number: Int) = {
      (0 /: (1 to number)) {
        (sum, i) => if (number % i == 0) {
          //sum + i; println("number % i == 0  sum: " + sum + " and i: " + i) false since the output of function should be int
          println("number % i == 0  sum: " + sum + " and i: " + i) ;sum + i
        } else {
          println("sum: " + sum + " and i: " + i); sum
        }
      }
    }

    def isPerfect(candidate: Int) = 2 * candidate == sumOfFactors(candidate)

    println(isPerfect(10))
  }

}
