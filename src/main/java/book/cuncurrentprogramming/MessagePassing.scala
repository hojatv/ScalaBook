package book.cuncurrentprogramming

import scala.actors.Actor._

/**
  * Created by hovaheb on 12/23/2016.
  */
object MessagePassing {
  def main(args: Array[String]): Unit = {


    var startTime: Long = 0
    val caller = self

    caller ! "Salam"

    /*val engrossedActor = actor {
      println("Number of messages received so far? " + mailboxSize)
      caller ! "send"
      Thread.sleep(3000)
      println("Number of messages received while I was busy? " + mailboxSize)
      receive {
        case msg =>
          val receivedTime = System.currentTimeMillis() - startTime
          println("line 23 Received message " + msg + " after " + receivedTime + " ms")
      }
      caller ! "received"
    }*/

    receive { case msg => println("line 28 msg: " + msg) }

    println("********************")
    println("Sending Message ")
    startTime = System.currentTimeMillis()
    /*engrossedActor ! "hello buddy"*/
    val endTime = System.currentTimeMillis() - startTime

    printf("Took less than %dms to send message\n", endTime)
    println("********************")
    caller ! "Bye"
    receive {
      case msg => println("line 40 msg: " + msg)
    }


  }
}




