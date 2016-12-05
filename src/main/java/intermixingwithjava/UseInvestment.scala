package intermixingwithjava

import intermixingwithjava.investments.{Investment, InvestmentType}

/**
  * Created by hovaheb on 12/5/2016.
  */
object UseInvestment {
  def main(args: Array[String]) {
    val investment = new Investment("XYZ Corporation", InvestmentType.STOCK)
    println(investment.getClass())
    /*val theYield1 = investment.yield //ERROR
    val theYield2 = investment.yield() //ERROR*/

    val theYield1 = investment.`yield`
    val theYield2 = investment.`yield`()
    val theYield3 = investment. `yield`()
  }
}
