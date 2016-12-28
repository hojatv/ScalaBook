package book.cuncurrentprogramming

import scala.actors.Actor
import scala.actors.Actor._
/**
  * Created by hovaheb on 12/27/2016.
  */
class PrimeTeller {
  def isPrime(number: Int): Boolean = {
    println("Going to find if " + number + " is prime")
    var result = true
    if (number == 2 || number == 3) result = true
    for (i <- 2 to Math.sqrt(number.toDouble).floor.toInt; if result) {
      if (number % 2 == 0) result = false
    }
    println("done finding if " + number + " is prime")
    result
  }

}

object PrimeTeller {
  def main(args: Array[String]): Unit = {
    val p: PrimeTeller = new PrimeTeller
    /*val number = 873
    println(Math.sqrt(number.toDouble).floor.toInt)
    println(p.isPrime(number))*/

    val primeTeller = actor{ /*primeTeller is a reference to an anonymous actor created using the actor( ) method.*/
      var continue = true
      while (continue){
        receive{
          //case (caller : Actor , number:Int) => caller ! (number,p.isPrime(number))
          case (caller : Actor, number: Int) => actor { caller ! (number, p.isPrime(number)) }
          case "quit" => continue = false
        }
      }

    }

    primeTeller ! (self, 2)
    primeTeller ! (self, 131)
    primeTeller ! (self, 132)
    for (i <- 1 to 3) {
      receive {
        case (number, result) => println(number + " is prime? " + result)
      }
    }
    primeTeller ! "quit"
  }

}
