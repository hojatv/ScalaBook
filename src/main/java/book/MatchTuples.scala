package book

/**
  * Created by hovaheb on 11/30/2016.
  */
class MatchTuples {
  def processCoordinates(input:Any): Unit ={
    input match {
      case (a,b) => printf("Processing (%d, %d)... " , a, b)
      case "done" => println("done")
      case _ => null
    }
  }

}
object MatchTuples{
  def main(args: Array[String]): Unit = {
    val m:MatchTuples = new MatchTuples
    m.processCoordinates((3,-5))
    m.processCoordinates(("done"))
  }
}
