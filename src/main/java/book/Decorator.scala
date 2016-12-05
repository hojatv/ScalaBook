package book

/**
  * Created by hovaheb on 11/28/2016.
  */
class Decorator {
   abstract class Check {
    def check():String = "Checked applicant's details..."
  }

  trait CreditCheck extends Check{
    override def check(): String = "Checked Credit ..." +  super.check()
  }
  trait EmploymentCheck extends Check{
    override def check(): String = "Checked Employment ..."  + super.check()
  }
  trait Criminalcheck extends Check{
    override def check : String = "Criminal Checked .." + super.check()
  }

  /*The rightmost trait picked up the call to check( )*/
  val appartmentApplication = new Check  with CreditCheck with Criminalcheck
  println(appartmentApplication check)


}
object Decorator{
  def main(args: Array[String]): Unit = {
    val dec: Decorator = new Decorator

  }
}