package book

/**
  * Created by hovaheb on 12/2/2016.
  */
class Extractor {
  object StockService{
    def process(input:String): Unit ={
      input match {
        case Symbol() => println("Look up for a valid symbol " + input)
        case ReceiveStockPrice(symbol @ Symbol(),price) => printf("Received price %f for symbol %s \n" , price,symbol)
        case _ => println("Invlid input " + input)
      }
    }
  }
  object Symbol{
    def unapply(symbol:String): Boolean = symbol == "GOOG" || symbol == "IBM"
  }

  object ReceiveStockPrice {
    def unapply(input: String) : Option[(String,Double)] = {
      try {
        if(input contains(":")){
          val splitQuote = input split ":"
          Some(splitQuote(0), splitQuote(1).toDouble)
        }
        else{None}
      }
      catch {
        case _ : NumberFormatException => None
      }
    }
  }

  StockService process "GOOG"
  StockService process "IBM"
  StockService process "ERR"


  StockService process "GOOG:310.84"
  StockService process "GOOG:BUY"
  StockService process "ERR:12.21"


}
object Extractor{
  def main(args: Array[String]): Unit = {
    val e:Extractor = new Extractor
    e.StockService process "KOOK"
  }
}
