package book

/**
  * Created by hovaheb on 11/29/2016.
  */
class Friends {
  class Person(val firstName:String,val lastName:String)
  object Person{
    def apply(firstName: String,lastName: String): Person =
      new Person(firstName,lastName )
  }
  val friends = List(Person("Ali","Rezaie"), Person("Hojat", "Vaheb"))
  val lasNames = for(friend <- friends; lastName = friend.lastName) yield  lastName.toUpperCase
  println(lasNames.mkString(", "))

  for(i <- 1 to 3; j <- 4 to 6)
    println("["+i + ","+ j + "]")


}
object Friends{
  def main(args: Array[String]): Unit = {
    val f: Friends = new Friends

  }
}
