package book.usingscala

/**
  * Created by hovaheb on 12/22/2016.
  */

import scala.actors._
import Actor._

object NetAssetStockPriceHelper {
  val symbolsAndUnits = StockPriceFinder.getTickersAndUnits()

  def getInitialTableValues: Array[Array[Any]] = {
    val emptyArrayOfArrayOfAny = new Array[Array[Any]](0)
    (emptyArrayOfArrayOfAny /: symbolsAndUnits) { (data, element) =>
      val (symbol, units) = element
      data ++ Array(List(symbol, units, "?", "?").toArray)
    }

  }

  def fetchPrice(updater: Actor) = actor {
    val caller = self
    symbolsAndUnits.keys.foreach { symbol =>
      actor {
        caller ! (symbol, StockPriceFinder.getLatestClosingPrice(symbol))
      }
    }

    val netWorth = (0.0 /: (1 to symbolsAndUnits.size)) { (worth, index) =>
      receive {
        case (symbol: String, latestClosingPrice: Double) =>
          val units = symbolsAndUnits(symbol)
          val value = units * latestClosingPrice
          updater ! (symbol, units, latestClosingPrice, value)
          worth + value
      }
    }
    updater ! netWorth
  }

  def main(args: Array[String]): Unit = {
    val result = getInitialTableValues
    for (i <- result) {
      println(i.mkString)
    }
  }
}
