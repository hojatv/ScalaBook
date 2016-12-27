package book.cuncurrentprogramming

import scala.actors.Actor._

/**
  * Created by hovaheb on 12/23/2016.
  */
class MessagePassing {

  var startTime: Long = 0
  val caller = self

  val engrossedActor = actor {
    println("Number of messages received so far? " + mailboxSize)
    caller ! "send"
    Thread.sleep(3000)
    println("Number of messages received while I was busy? " + mailboxSize)
    receive {
      case msg =>
        val receivedTime = System.currentTimeMillis() - startTime
        println("Received message " + msg + " after " + receivedTime + " ms")
    }
    caller ! "received"
  }
  println("""Number of messages received after calling "caller ! "send" " ? """ + mailboxSize)
  println("We riched first receive in main thread!")
  receive { case _ => }

  println("Sending Message ")
  startTime = System.currentTimeMillis()
  engrossedActor ! "hello buddy1"
  engrossedActor ! "hello buddy2" //missed
  engrossedActor ! "hello buddy3"  // missed
  val endTime = System.currentTimeMillis() - startTime

  printf("Took less than %dms to send message\n", endTime)

  receive {
    case _ =>
  }

}

object MessagePassing {
  def main(args: Array[String]): Unit = {
    val m: MessagePassing = new MessagePassing
  }
}




