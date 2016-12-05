package book

import java.util
import java.util._

/**
  * Created by hovaheb on 11/24/2016.
  */
class Generics {
  var list1 : List[Int] = new ArrayList[Int]
  var list2 = new util.ArrayList[Int]
  def test(): Unit = {

    list2 add 1
    list2 add 2
    var total = 0
    for (index1 <- 0 until list2.size()) {
      total += list2.get(index1)
    }
    println("Total is " + total)
  }
  def madMethod()={
    throw new IllegalArgumentException()
  }



}
