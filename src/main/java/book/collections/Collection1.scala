package book.collections

/**
  * Created by hovaheb on 1/24/2017.
  */
object Collection1 {
  def main(args: Array[String]): Unit = {
    /*1 By default we used the immutable set. This is because the default
    included object Predef provides aliases for Set and Map to point to the
    immutable implementations*/
    /*2 Not Need to write this:
      val colors1 = new scala.collection.immutable.Set3[String]("Blue" , "Green" , "Red" )
      This magic is possible because of a special apply( ) method, also called a factory method.
      */
    val colors1 = Set("Red","Green","Blue")
    var colors = colors1
    println("colors1 (colors)=" + colors)

    colors += "Black"
    println("colors:" + colors)
    println("colors1:" + colors1)

    val feeds1 = Set("Alef.com.ir","Be.com","Pe.com.ir","Te.org")
    val feeds2 = Set("Alef.com.ir","Jim.com","Mim.org")

    /******************************************************************************/
    val comDotIRFeeds = feeds1 filter(x => if(x contains ".com.ir") true else false)
    val comDotIRFeeds2 = feeds1 filter(x => x contains ".com.ir")
    /*OR*/
    val comDotIrFeeds1 = feeds1 filter(_ contains ".com.ir")

    println(".com.ir feeds :   " + comDotIRFeeds.mkString(", "))
    println(".com.ir feeds :   " + comDotIrFeeds1.mkString(", "))
    println(".com.ir feeds :   " + comDotIRFeeds2.mkString(", "))
    /******************************************************************************/



  }

}
