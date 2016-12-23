package book.cuncurrentprogramming

/**
  * Created by hovaheb on 12/2/2016.
  */

import scala.actors.Actor._

class FasterPerfectNumberFinder {

  def sumOfFactorsInRange(lower: Int, upper: Int, number: Int) = {
    (0 /: (lower to upper)) { (sum, i) => if (number % i == 0) sum + i else sum }
  }

  def isPerfectConcurrent(candidate: Int) = {
    val RANGE = 1000000
    val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toInt
    val caller = self /*self( ) method represents the main thread.*/

    for (i <- 0 until numberOfPartitions) {
      val lower = i * RANGE + 1;
      val upper = candidate min (i + 1) * RANGE

      actor { //<label id="code.fasterperfectnumberfinder.actor" />
        /*When an actor completes its allocated task, it messages the partial sum to the caller on line number*/
        caller ! sumOfFactorsInRange(lower, upper, candidate) //<label id="code.fasterperfectnumberfinder.send"/>
      }
    }

    val sum = (0 /: (0 until numberOfPartitions)) { (partialSum, i) =>
      receive { //<label id="code.fasterperfectnumberfinder.receive" />
        case sumInRange : Int => partialSum + sumInRange
      }
    }

    2 * candidate == sum
  }

  println("6 is perfect? " + isPerfectConcurrent(6))
  println("335503360 is perfect? " + isPerfectConcurrent(335503360))
  println("335503370 is perfect? " + isPerfectConcurrent(335503370))
}
object FasterPerfectNumberFinder{
  def main(args: Array[String]): Unit = {
    val f:FasterPerfectNumberFinder = new FasterPerfectNumberFinder
  }
}