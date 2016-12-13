package book.unittesting.exceptiontests
import org.junit.Assert._
import org.junit.Test
/**
  * Created by hovaheb on 12/13/2016.
  */
class TestExceptionThrowing {
  @Test def testGetOnEmptyList() {
    try {
      val list = new java.util.ArrayList[Integer]
      list.get(0)
      fail("Expected exception for getting element from empty list" )
    }
    catch {
      case ex: IndexOutOfBoundsException => // :) Success
    }
  }

  /*def testGetOnEmptyList_Concise() {
    val list = new java.util.ArrayList[Integer]
    intercept(classOf[IndexOutOfBoundsException],
      "Expected exception for getting element from empty list" ) {
      list.get(0)
    }
    //You'll get a deprecation warning from the statement above.
    //ScalaTest is evolving to use a newer style for intercept.
    //Currently the new style does not take an error message argument.
    //When it does, you should use
    //intercept[IndexOutOfBoundsException] ("Expected ...") {...}
  }*/
}
/*
object TestExceptionThrowing{
  def main(args: Array[String]): Unit = {
    val t: TestExceptionThrowing = new TestExceptionThrowing
    t.testGetOnEmptyList()
  }
}
*/
