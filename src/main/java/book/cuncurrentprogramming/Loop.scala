package book.cuncurrentprogramming

import scala.actors._
import Actor._

/**
  * Created by Dell on 12/28/2016.
  */
object Loop {
  val caller = self

  def accumulate() {
    var continue = true
    var sum = 0

    loopWhile(continue) {
      reactWithin(500) {
        case num: Int => sum += num
          println(Thread.currentThread())
        case TIMEOUT => println("Timed Out")
          continue = false
          caller ! sum
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val accumulatorActor = actor {
      accumulate()
    }
    accumulatorActor ! 1
    accumulatorActor ! 2
    accumulatorActor ! 4
    receiveWithin(1000) {
      case result => println(result)
    }
  }


}
