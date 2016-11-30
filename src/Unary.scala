/**
  * Created by hovaheb on 11/29/2016.
  */
class Unary {
  class Sample {
    def unary_+ = println("Called unary +" )
    def unary_- = println("called unary -" )
    def unary_! = println("called unary !" )
    def unary_~ = println("called unary ~" )
  }

}
object Unary{
  def main(args: Array[String]): Unit = {
    val u:Unary = new Unary
    val sample = new u.Sample
    +sample
    -sample
    !sample
    ~sample
  }
}