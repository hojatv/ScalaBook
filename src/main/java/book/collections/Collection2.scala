package book.collections

/**
  * Created by hovaheb on 1/24/2017.
  */
object Collection2 {
  def main(args: Array[String]): Unit = {
    val feeds = List("blog.toolshed.com", "pragdave.pragprog.com",
      "dimsumthinking.com/blog");

    println(feeds(1))
    println(feeds.head)
    println(feeds.tail)

    /*prefix a to the list*/
    val prefixedList ="alef.ir" :: feeds
    println(prefixedList.head)

    /*prefix feeds list to newList*/
    val newList = List("q","w")
    val mergedList = feeds:::newList
    println(mergedList.mkString(", "))
    println(mergedList.last)

    /*If we want to check whether all feeds meet a certain condition*/
    println("Feeds with blog: " + feeds.filter(_ contains("blog")).mkString(", "))

    /*check if all feeds meet a condition*/
    println("All feeds have com: " + feeds.forall( _ contains "com" ))
    println("All feeds have dave: " + feeds.forall( _ contains "dave" ))

    /*any feed meets a certain condition, exists( ) will help us*/
    println("Any feeds have dave : " + feeds.exists(_ contains("dave")))
    println("Any feeds have com : " + feeds.exists(_ contains("com")))

    /*calling map for applying a function on each element*/
    println("Feed url lengths: " + feeds.map(_.length).mkString(", "))
    val total = feeds.foldLeft(0){(total,feed) => total + feed.length }
    val total1 = (0 /: feeds){(total,feed) => total + feed.length }
    val total2 = (0 /: feeds){_ + _.length}
    println("totla lenght : " + total)
    println("totla lenght : " + total1)
    println("totla lenght : " + total2)

    /*if yield keyword is present means tells the expression to return a list of values instead of unit */
    val result = for(x <- feeds)
      yield x + "XXX"

    println(result.mkString(", "))

    val result1 = feeds.map(_ + "XXX")
    println(result1.mkString(", "))

    val result2 = for(x <- feeds; if(x.length>30))
      yield x+"YYYY"
    println(result2.mkString(", "))
  }
}
