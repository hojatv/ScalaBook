package book.intermixingwithjava

import java.lang.reflect.Method
import java.util.Date

/**
  * Created by hovaheb on 12/5/2016.
  */
class UseJDKClasses {

  println("Today is " + new Date())

  val methods = getClass.getMethods();
  methods.foreach { method : Method => println(method.getName())}


}
object UseJDKClasses{
  def main(args: Array[String]): Unit = {
    val u:UseJDKClasses = new UseJDKClasses
  }
}
