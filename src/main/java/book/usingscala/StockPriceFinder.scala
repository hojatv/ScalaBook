package book.usingscala

import scala.collection.mutable

/**
  * Created by hovaheb on 12/20/2016.
  */
object StockPriceFinder {

  def getLatestClosingPrice(symbol: String): Double = {
    try {
      val url = "http://ichart.finance.yahoo.com/table.csv?s=" +
        symbol + "&a=00&b=01&c=" + new java.util.Date().getYear;
      val data = scala.io.Source.fromURL(url).mkString
      val mostRecentData = data.split("\n")(1)
      val closingPrice = mostRecentData.split(",")(4).toDouble
      closingPrice
    }catch {
      case ex: java.io.FileNotFoundException => 0
    }
  }

  def getTickersAndUnits(): mutable.Map[String, Int] = {
    val stocksAndUnitsXML = scala.xml.XML.load("stocks.xml")

    val stocksAndUnitsMap =
      (scala.collection.mutable.Map[String, Int]() /: (stocksAndUnitsXML \ "symbol")) { (map, symbolNode) =>
        val ticker = (symbolNode \ "@ticker").toString
        val units = (symbolNode \ "units").text.toInt
        map(ticker) = units
        map
      }
    stocksAndUnitsMap
  }


}
