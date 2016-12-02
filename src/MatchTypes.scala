/**
  * Created by hovaheb on 11/30/2016.
  */
class MatchTypes {
  def process(input:Any): Unit ={
    input match {
      case (a:Int , b:Int) => println("processing (Int , Int)")
      case (a:Double , b:Double) => println("processing (double , double)")
      case (a:Double , b:Double, other@ _) => println("processing (double , double,)" + other)
      case msg:Int if(msg > 1000000) => println("Processing Int > 1000000")
      case msg:Int => println("Processing Int")
      case msg:String => println("Processing String")
      case _ => printf("Can not Handle %s...", input)

    }

  }
  process((34.0, -159.3))
  process((34.0, -159.3, "Hi"))
  process(0)
  process(1000001)
  process(2.2)

}
object MatchTypes{
  def main(args: Array[String]) {
    val m:MatchTypes = new MatchTypes
  }
}
