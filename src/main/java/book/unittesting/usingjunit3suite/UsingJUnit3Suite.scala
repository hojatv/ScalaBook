package book.unittesting.usingjunit3suite


/**
  * Created by hovaheb on 12/13/2016.
  */
class UsingJUnit3Suite /*extends org.scalatest.junit.JUnit3Suite */{
  def withList(testFunction: (java.util.ArrayList[Integer]) => Unit) {
    val list = new java.util.ArrayList[Integer]
    try {
      testFunction(list)
    }
    finally {
      // perform any necessary cleanup here after return
    }
  }

  /*def testListEmptyOnCreate() {
    withList {
      list => expect(0, "Expected size to be 0") {
        list.size()
      }
    }
  }*/

  /*def testGetOnEmptyList() {
    withList {
      list => intercept[IndexOutOfBoundsException] {
        list.get(0)
      }
    }
  }*/

}

object RunJUnitTest {
  def main(args: Array[String]) ={}
    /*junit.textui.TestRunner.run(classOf[UsingJUnit3Suite])*/
}