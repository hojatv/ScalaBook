package book.usingscala


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
  }
}
