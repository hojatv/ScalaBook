package book.patternmatching

/**
  * Created by hovaheb on 1/25/2017.
  */
object CaseClasses {
  def main(args: Array[String]): Unit = {
    val traeProcessor = new TradeProcessor
    /*traeProcessor.processTransaction(Buy("GOOG", 500))*/

    val tradeProcessor = new TradeProcessor
    tradeProcessor.processTransaction( Sell("GOOG" , 3000))

  }

}

sealed abstract  class Trade()

case class Sell(symbol: String,quantity:Int) extends Trade {

  def unapply(symbol: String, quantity: Int): Option[String] = if (quantity > 2000) Some("Selling large amount(" + quantity + ") of symbol(" + symbol + ")") else None

  def apply(symbol: String, quantity: Int): Sell = new Sell(symbol,quantity)
}

/*
case class Buy (stockSymbol:String,quantity:Int) extends Trade{
  def unapply(arg: Buy): Buy = arg
}
case class Hedge(stockSymbol:String,quantity:Int) extends Trade{
  def unapply(arg: Hedge): Hedge = arg
}
*/


class TradeProcessor {
  def processTransaction(trade: Trade): Unit = {
    trade match {
      case Sell(x, y) => println("Sell for " + x + " " + y)
      /*case Sell(symbol,quantity) => printf("Selling %d of symbol %s\n" , quantity,symbol)
      case Buy(symbol,quantity) if(quantity > 2000) => printf("Buying large (%d) of symbol %s\n" , quantity, symbol)
      case Buy(symbol,quantity) =>printf("Buying %d of symbol %s\n" , quantity, symbol)*/

    }
  }
}