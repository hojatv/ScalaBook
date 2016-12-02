package book

/**
  * Created by hovaheb on 12/2/2016.
  */
class MatchUsingRegex {

  def process(input:String): Unit ={
    val GoogStock = """^GOOG:(\d*\.\d+)""".r
    val MatchStock = """^(.+):(\d*\.\d+)""".r
    input match{
      case GoogStock(price) => println("Price of GOOG is " + price)
      case MatchStock("GOOG",price) => println("Price of GOOG is " + price)
      case MatchStock("IBM",price) => println("Price of IBM is " + price)
      case MatchStock(symbol,price) => printf("Price of %s is %s\n" , symbol,price)
      case _ => println(("not processing " + input))
    }
  }
  process("GOOG:310.84" )
  process("GOOG:310" )
  process("IBM:84.01" )

  process("GOOG:310.84" )
  process("IBM:84.01" )
  process("GE:15.96" )

}
object MatchUsingRegex{
  def main(args: Array[String]): Unit = {
    val m:MatchUsingRegex = new MatchUsingRegex
  }
}
