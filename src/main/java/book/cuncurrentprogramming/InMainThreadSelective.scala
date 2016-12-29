package book.cuncurrentprogramming

import scala.actors.Actor
import Actor._
import scala.actors.scheduler.SingleThreadedScheduler

/**
  * Created by hovaheb on 12/29/2016.
  */
object InMainThreadSelective {
  trait SingleThreadActor extends Actor{
    override  def scheduler = new SingleThreadedScheduler
  }
  class MyActor1 extends Actor{
    override def act(): Unit = println("Actor1 running in " + Thread.currentThread())
  }
  class MyActor2 extends SingleThreadActor{
    override def act() = println("Actor2 running in " + Thread.currentThread())
  }

  def main(args: Array[String]): Unit = {
    println("Main running in " + Thread.currentThread())
    new MyActor1().start()
    new MyActor2().start()
    actor{println("Actor3 running in " + Thread.currentThread()) }

    receiveWithin(3000){case _ => }

  }

}
