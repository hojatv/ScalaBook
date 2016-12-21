package book.usingscala

import scala.xml.XML


/**
  * Created by hovaheb on 12/14/2016.
  */
object UseXML {
  def main(args: Array[String]): Unit = {
    val xmlFragment =
      <symbols>
        <symbol ticker="AAPL">
          <units>200</units>
        </symbol>
        <symbol ticker="IBM">
          <units>215</units>
        </symbol>
      </symbols>

    println(xmlFragment)
    println(xmlFragment.getClass())

    println("*******************")
    var symbolNodes = xmlFragment \ "symbol"
    println(symbolNodes.mkString("\n"))
    println(symbolNodes.getClass)

    println("*******************")
    var unitNodes = xmlFragment \\ "units"
    println(unitNodes.mkString("\n") )
    println(unitNodes.getClass)
    println(unitNodes(0).text)
    unitNodes(0) match {
      case <units>{numberOfUnits}</units> => println("Units: " + numberOfUnits)
    }
    println("*******************")
    println("Ticker\tUnits" )
    xmlFragment match {
      /*By using the symbol _*, we asked to read everything between the <symbols> and </symbols> into the placeholder variable symbolNodes1 using @ .*/
      case <symbols>{symbolNodes1 @ _* }</symbols> =>
        for(symbolNodeVar @ <symbol>{_*}</symbol> <- symbolNodes1) {
          println("%-7s %s".format(
            symbolNodeVar \ "@ticker" , (symbolNodeVar \ "units" ).text))
        }
        /*we perform an XPath query to get to the attribute ticker (recollect from XPath that you use an @ prefix to
        indicate the attribute query) and the text value in the units elements*/
    }

    println("*******************")
    /*Reading and Writing XML*/
    val stocksAndUnits = XML.load("stocks.xml")
    println(stocksAndUnits.getClass)
    println("Loaded file has " + (stocksAndUnits \\ "symbol").size + " symbol elements")

    val stocksAndUnitsMap =
      (scala.collection.mutable.Map[String, Int]() /: (stocksAndUnits \ "symbol")) { (map, symbolNode) =>
        val ticker = (symbolNode \ "@ticker").toString
        val units = (symbolNode \ "units").text.toInt
        map(ticker) = units
        map
        //map(ticker) = units //Creates and returns a new Map
        //Map(ticker -> units)
      }
    println("Number of symbol elements found is " + stocksAndUnitsMap.size)


    println("*******************")
    val updatedStocksAndUnitsXML =
      <symbols>
        { stocksAndUnitsMap.map { updateUnitsAndCreateXML } }
      </symbols>
    XML save ("stocks2.xml" , updatedStocksAndUnitsXML)
    println("The saved file contains " +
    (XML.load("stocks2.xml" ) \\ "symbol" ).size + " symbol elements" )



  }
  def updateUnitsAndCreateXML(element : (String, Int)) = {
    val (ticker, units) = element
    <symbol ticker={ticker}>
      <units>{units + 1}</units>
    </symbol>
  }

}
