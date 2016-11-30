package book

/**
  * Created by hovaheb on 11/29/2016.
  */
class ListApplications {
  val feeds = List("blog.toolshed.com", "pragdave.pragprog.com",
    "dimsumthinking.com/blog")
  val prefixedList = "forums.pragprog.com/forums/87" :: feeds
  val feedsWithForums =
    feeds ::: List("forums.pragprog.com/forums/87", "forums.pragprog.com/forums/55")


}

object ListApplications {
  def main(args: Array[String]): Unit = {
    val l: ListApplications = new ListApplications

    println("First feed: " + l.feeds.head)
    println("Second feed: " + l.feeds(1))
    /*println("Third feed: " + l.feeds tail)*/
    println("First Feed In Prefixed: " + l.prefixedList.head)
    println("First feed in feeds with forum: " + l.feedsWithForums.head)
    println("Last feed in feeds with forum: " + l.feedsWithForums.last)

    println("Feeds with blog: " + l.feeds.filter(_ contains "blog").mkString(", "))
    println("All feeds have com: " + l.feeds.forall(_ contains "com"))
    println("All feeds have dave:" + l.feeds.forall(_ contains ("dave")))
    println("Any feed has dave:" + l.feeds.exists(_ contains ("dave")))
    println("Any feed has :" + l.feeds.exists(_ contains ("bill")))

    println("Feed url lengths: " + l.feeds.map(_.length).mkString(", "))

    println("Total # of characters:" + l.feeds.foldLeft(0) { (a, b) => a + b.length })
    println("total # of characters :" + (0 /: l.feeds) { (total , feed) => total + feed.length} )
    println("Total # of characters:" + l.feeds.foldRight(0) { (a,b) => a.length + b})
  }
}
