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
    val colors1 = Set("Red", "Green", "Blue")
    var colors = colors1
    println("colors1 (colors)=" + colors)

    colors += "Black"
    println("colors:" + colors)
    println("colors1:" + colors1)

    val feeds1 = Set("Alef.com.ir", "Be.com", "Pe.com.ir", "Te.org")
    val feeds2 = Set("Alef.com.ir", "Jim.com", "Mim.org")

    /** ****************************************************************************/
    val comDotIRFeeds = feeds1 filter (x => if (x contains ".com.ir") true else false)
    val comDotIRFeeds2 = feeds1 filter (x => x contains ".com.ir")
    /*OR*/
    val comDotIrFeeds1 = feeds1 filter (_ contains ".com.ir")

    println(".com.ir feeds :   " + comDotIRFeeds.mkString(", "))
    println(".com.ir feeds :   " + comDotIrFeeds1.mkString(", "))
    println(".com.ir feeds :   " + comDotIRFeeds2.mkString(", "))
    /** ****************************************************************************/
    /*MERGING SETS*/
    val mergedFeeds = feeds1 ++ feeds2
    println("Merged Feeds: " + mergedFeeds.mkString(","))

    /*INTERSECT OPERATION*/
    val commonFeeds = feeds1.intersect(feeds2)
    println("Common Feeds: " + commonFeeds.mkString(","))

    /*Using MAP OPERATION: THIS METHOD APPLIES THE FUNCTION VALUE TO EACH ELEMENT*/
    val urls = feeds1 map ("http://" + _)
    println("urls: " + urls.mkString(","))

    /*ITERATE OVER SETS*/
    println("Refresh feeds")
    feeds1 foreach (feed => println("Refreshing " + feed))
    val X = feeds1 foreach (_ + "XXX")
    feeds1 foreach (_ contains ("s"))
    println(X.getClass.getSimpleName)
    println("Refresh feeds in other words")
    feeds1 foreach (println(_))


    val feeds = Map("Tavakoli" -> "Alef.com.ir", "Abbas" -> "Be.com", "Reza" -> "Pe.com.ir", "Taghi" -> "Te.org")
    val filterNameStartWithT = feeds filterKeys(_ startsWith("T"))
    val filterNameStartWithT1 = feeds filterKeys(x => x startsWith("T"))
    println("filtered keys: " + filterNameStartWithT.mkString(","))
    println("filtered keys: " + filterNameStartWithT1.mkString(","))

    val filterNamesStartWithTAndValuesContainComDotIT = feeds filter{element =>
      val(key,value) = element
      (key startsWith("T")) && (value contains(".com.ir"))
    }
    println("feeds starting with T and containing .com.ir: " + filterNamesStartWithTAndValuesContainComDotIT.mkString(", "))

    println("feeds for Tavakoli: " + feeds.get("Tavakoli"))
    println("feeds for Gholi: " + feeds.get("Gholi"))
    val x = feeds.get("Gholi")
    val y = feeds.get("Tavakoli")
    println("feeds for Gholi: " + x.getOrElse("not found"))
    println("feeds for Tavakoli: " + y.getOrElse("not found"))

    /*Using Apply Method*/
    try {
      val x1 = feeds("Gholi")
      println("feeds for Gholi: " + x1)
      val y1 = feeds("Tavakoli")
      println("feeds for Tavakoli: " + y1)
    }catch {
      case ex: NoSuchElementException => println("not found")

    }

    val newFeeds = feeds.updated("A","B")
    println("original feeds " + feeds.mkString(", "))
    println("new feeds " + newFeeds.mkString(", "))




  }

}
