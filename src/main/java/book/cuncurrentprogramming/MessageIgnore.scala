package book.cuncurrentprogramming

/**
  * Created by hovaheb on 12/28/2016.
  */
object MessageIgnore {
  def main(args: Array[String]): Unit = {
    import scala.actors._
    import Actor._
    val expectStringOrInteger = actor {
      for(i <- 1 to 4){
        receiveWithin(1000){
          case str:String => println("You said: " + str)
          case num:Int => println("You gave " + num)
          case TIMEOUT => println("Timed Out!")
        }
      }
    }
    expectStringOrInteger ! "only constant is change"
    expectStringOrInteger ! 1024
    expectStringOrInteger ! 22.22
    expectStringOrInteger ! (self, 1024)
    receiveWithin(3000) { case _ => }
  }
  def test: Unit = {
    /*val x = actor{

    }*/
  }

}
