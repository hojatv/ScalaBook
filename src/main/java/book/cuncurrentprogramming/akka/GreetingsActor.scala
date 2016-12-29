package book.cuncurrentprogramming.akka

import akka.actor.{Actor, ActorPath, ActorRef, ActorSystem, Props}

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
    /*The actor system will create the infrastructure required for the actor to run.*/
    val system = ActorSystem("greetings")
    val a = system.actorOf(Props[GreetingsActor], name = "greetings-actor")
    a ! Name("Reza")

    /*The system / method returns the actor path*/
    val path: ActorPath = system / "greetings-actor"
    println(path)
    val actorRef: ActorRef = system.actorFor(path)
    println(actorRef)
    actorRef ! Name("some message")

    val deadLetterActorRef: ActorRef = system.actorFor(path + "alaki")
    println(deadLetterActorRef)
    /*If the actorFor fails to find an actor
    pointed to by the path, it returns a reference to the dead-letter mailbox of the actor    system.*/
    deadLetterActorRef ! Name("some message")


    system.shutdown()

  }
}