package book.cuncurrentprogramming

import scala.actors._
import Actor._

/**
  * Created by hovaheb on 12/27/2016.
  */
class AskFortune {
  val fortuneTeller = actor {
    for (i <- 1 to 4) {
      Thread.sleep(1000)
      receive {
        case _ => sender ! "your day will rock " + i //we used sender to reference the actor that sent us the last message.
        //case _ => reply ! "your day will rock " + i // same as above
      }
    }
  }
  /*The !?( ) method wirn tll retuhe result if the actor sends it a message
  before the timeout. otherwise it returns None*/
  println(fortuneTeller !? (2000, "what's ahead"))
  println(fortuneTeller !? (500, "what's ahead"))

  val aPrinter = actor {
    receive {
      case msg => println("Ah, fortune message for you- " + msg)
    }
  }
  /*forwarding the result to some other actor. In  this case, the reply is sent to the delegate we assign instead of the real  caller.*/
  fortuneTeller send("What's up ", aPrinter)
  fortuneTeller ! "How is my future?"

  Thread.sleep(3000)

  receive { case msg: String => println("Received " + msg) }
  println("Lets get lost message")
  /*This case class represents messages sent by an actor to itself. So, while we continue to process other messages, if we are interested in processing
  missed messages, we can use this case class to fetch it*/
  receive { case !(channel, msg) => println("Received belated message " + msg) }
}

object AskFortune {
  def main(args: Array[String]): Unit = {
    val a: AskFortune = new AskFortune
  }
}