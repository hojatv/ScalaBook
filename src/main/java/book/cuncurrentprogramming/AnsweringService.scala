package book.cuncurrentprogramming

import scala.actors.Actor
import scala.actors.Actor._

/**
  * Created by hovaheb on 12/27/2016.
  */
class AnsweringService(val folks: String*) extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case (caller: Actor, name: String, msg: String) => caller ! (
          if (folks.contains(name))
            String.format("Hey it's %s got message %s here", name, msg)
          else
            String.format("Hey there is no one with the name %s ", msg)
          )
        case "ping" => println("ping!")
        case "quit" => println("exiting actor")
          exit()
      }
    }
  }
}

object AnsweringService {
  def main(args: Array[String]): Unit = {
    val answeringService = new AnsweringService("Sara", "Kara", "John")
    answeringService ! (self, "Sara", "In town")
    answeringService ! (self, "Kara", "Go shopping?")
    /*As soon as we called the start( ) method, the act( ) method of the actor was called in a separate thread.*/
    answeringService.start()
    answeringService ! (self, "John", "Bug fixed?")
    answeringService ! (self, "Bill", "What's up")
    for (i <- 1 to 4) {
      receive { case msg => println(msg) }
    }
    answeringService ! "ping"
    answeringService ! "quit"
    answeringService ! "ping"
    Thread.sleep(2000)
    println("The last ping was not processed but queued")
    answeringService.restart()
    answeringService ! "quit"
  }
}
