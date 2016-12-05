package book

import java.util.NoSuchElementException

/**
  * Created by hovaheb on 11/29/2016.
  */
class MapsApplications {
  val feeds = Map("Andy Hunt" -> "blog.toolshed.com", "Dave Thomas" -> "pragdave.pragprog.com", "Dan Steinberg" -> "dimsumthinking.com/blog")
  val filterNameStartWithD = feeds filterKeys (_ startsWith "D")

  val filterNameStartWithDAndBlogInFeed = feeds filter { element =>
    val (key, value) = element
    (key startsWith "D") && (value contains "blog")
  }
  //val newFeeds1 = feeds.update("Venkat Subramaniam" , "agiledeveloper.com/blog" )


  val mutableFeeds = scala.collection.mutable.Map("Scala Book Forum" -> "forums.pragprog.com/forums/87" )
  mutableFeeds("Groovy Book Forum" ) = "forums.pragprog.com/forums/55"


}

object MapsApplications {
  def main(args: Array[String]): Unit = {
    val m: MapsApplications = new MapsApplications
    println(m.feeds)
    println(m.filterNameStartWithD mkString (","))
    println("# of feeds with auth name D* and blog in URL: " +
      m.filterNameStartWithDAndBlogInFeed.size)

    println(m.feeds.get("Andy Hunt"))
    println(m.feeds("Andy Hunt")) // Using Apply method


    println(m.feeds.get("Bill who")) // get() returns Option[T]
    try {
      println(m.feeds("Bill Who")) // Using Apply method
    }catch {
      case ex: NoSuchElementException => println("Not Found!")
    }
    println("Number of forums: " + m.mutableFeeds.size)
  }
}
