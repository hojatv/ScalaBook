package book.cuncurrentprogramming.akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by hovaheb on 12/29/2016.
  */
case class Name(name:String)
class GreetingsActor extends Actor{
  override def receive: Receive = {
    case Name(n)=> println("Hello " + n)
  }
}
object GreetingsActor{
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("greetings")
    val a = system.actorOf(Props[GreetingsActor], name = "greetings-actor")
    a ! Name("Reza")
    system.shutdown()

  }
}