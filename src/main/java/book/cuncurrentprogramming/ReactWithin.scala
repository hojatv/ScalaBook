package book.cuncurrentprogramming

import scala.actors._
import Actor._

/**
  * Created by Dell on 12/28/2016.
  */
object ReactWithin {
   val caller = self

  def accumulate(): Unit = {
    var sum = 0
    reactWithin(500) {
      case number: Int => sum += number
        accumulate()
      case TIMEOUT => println("Timed Out")
        caller ! sum
    }
    println("This will not be called...")
  }

  def accumulateWithParam(sum: Int): Unit ={

    reactWithin(500){
      case number:Int => accumulateWithParam(sum + number)
      case TIMEOUT =>
        println("Timed Out")
        caller ! sum
    }
    println("This will not be called..." )
  }

  def main(args: Array[String]): Unit = {


    val accumulator = actor {
      accumulate()
    }
    accumulator ! 1
    accumulator ! 3
    accumulator ! 8

    receiveWithin(10000) { case result => println("Total is " + result) }

    val accumulaterWithParamActor = actor{
      accumulateWithParam(0)
    }
    accumulaterWithParamActor ! 1
    accumulaterWithParamActor ! 3
    accumulaterWithParamActor ! 8
    receiveWithin(10000) {case r => println("Total is " + r)}



  }
  /*def main(args: Array[String]): Unit = {
    val caller = self
    def accumulate(sum : Int) {
      reactWithin(500) {
        case number: Int => accumulate(sum + number)
        case TIMEOUT =>
          println("Timed out! Will send result now")
          caller ! sum
      }
      println("This will not be called...")
    }

    val accumulator = actor { accumulate(0) }
    accumulator ! 1
    accumulator ! 7
    accumulator ! 8

    receiveWithin(10000) { case result => println("Total is " + result) }
  }*/
}
