package book.intermixingwithjava.singletonobjects

/**
  * Created by hovaheb on 12/5/2016.
  */
class Buddy {
  def greet() { println("Hello from Buddy class" ) }
}
object Buddy {
  def greet() { println("Hello from Buddy object" ) }
}
