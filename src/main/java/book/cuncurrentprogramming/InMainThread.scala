package book.cuncurrentprogramming

import scala.actors._
import Actor._
import scala.actors.scheduler.SingleThreadedScheduler

/**
  * Created by hovaheb on 12/29/2016.
  */
object InMainThread {
  def main(args: Array[String]): Unit = {
    if(args.length > 0 && args(0)=="Single"){
      println("CommandLine Argument Single Found")
      /*By setting the Scheduler’s impl, you can control the actors’ scheduling strategy for your entire application.*/
      Scheduler.impl = new SingleThreadedScheduler
    }
    println("Main running in " + Thread.currentThread())
    actor{
      println("Actor1 running in " + Thread.currentThread())
    }
    actor{
      println("Actor2 running in " + Thread.currentThread())
    }
    receiveWithin(3000) {
      case _ =>
    }
  }

}
