package book

/**
  * Created by hovaheb on 11/28/2016.
  */
class SetApplications {
  val feed1 =Set("blog.toolshed.com" , "pragdave.pragprog.com" ,
    "pragmactic-osxer.blogspot.com" , "vita-contemplativa.blogspot.com")
  val feed2 = Set("blog.toolshed.com" , "martinfowler.com/bliki")

  val blogSpotFeed = feed1 filter( _ contains "blogspot")
  val commonFeeds = feed1.intersect(feed2)




}
object SetApplications{
  def main(args: Array[String]): Unit = {
    val setApplications:SetApplications = new SetApplications

    println(setApplications.blogSpotFeed)
    println(setApplications.blogSpotFeed.mkString(", "))
    println(setApplications.feed1)
    val mergeFeeds = setApplications.feed1 ++ setApplications.feed2
    println(mergeFeeds.size)

     val commonFeeds = setApplications.feed1 intersect  setApplications.feed2
    println(commonFeeds.mkString(""))


    val urls = setApplications.feed1 map ( "http://" +  _ )
    //println("One url: " + urls.toArray(0))
    println("One Url " + urls.toList(0))

    println("Refresh Feeds")
    setApplications.feed1 foreach { feed => println ("Refreshing " + feed)}


  }
}
