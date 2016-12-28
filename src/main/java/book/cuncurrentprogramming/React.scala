package book.cuncurrentprogramming
import scala.actors._
import Actor._
/**
  * Created by Dell on 12/28/2016.  vcx
  */
object React {

  val caller = self

  def info(msg: String) = println(msg + " received by " + Thread.currentThread())

  def receiveMessage(id: Int) {
    for (i <- 1 to 2) {
      receiveWithin(20000) {
        case msg: String => info("receive: " + id + msg)
        case TIMEOUT => info("receive:" + "Timed Out")
      }
      //caller ! "done"
    }
  }
  def reactMessage(id: Int) {
    react {
      case msg: String => info("react: " + id + msg)
        reactMessage(id)
      //case msg: Int => info("Exiting React")
    }
  }

  def main(args: Array[String]): Unit = {

    val actors = Array(
      actor {
        info("react: 1 actor created"); reactMessage(1)
      },
      actor {
        info("react: 2 actor created"); reactMessage(2)
      },
      actor {
        info("receive: 3 actor created"); receiveMessage(3)
      },
      actor {
        info("receive: 4 actor created"); receiveMessage(4)
      }
    )
    println("***********************************")
    Thread.sleep(1000)
    for (i <- 0 to 3) {
      actors(i) ! " hello"; Thread.sleep(2000)
    }
    println("***********************************")
    Thread.sleep(2000)
    for (i <- 0 to 3) {
      actors(i) ! " hello"; Thread.sleep(2000)
    }
  }
}