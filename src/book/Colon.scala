package book

/**
  * Created by hovaheb on 11/29/2016.
  */
class Colon {

  class Cow {
    def ^ (moon:Moon): Unit ={
      println("Cow jumped over the moon")
    }
  }
  class Moon{
    def ^:(cow:Cow) = println("This cow jumped over moon too")
  }
}
object Colon{
  def main(args: Array[String]): Unit = {
    val c:Colon = new Colon
    val cow = new c.Cow
    val moon = new c.Moon
    cow ^ moon
    cow ^: moon
    moon.^:(cow)


  }
}
