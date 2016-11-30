package book

/**
  * Created by hovaheb on 11/28/2016.
  */
class WhatIsApply(param: String) {
  println("param is :" + param)

  override def toString: String = " WhatIsApply with param: " + param


}

object WhatIsApply {

  /* This is the method Scala calls when we use parentheses on a class or an instance. */
  def apply(param: String): WhatIsApply = new WhatIsApply(param)

  def main(args: Array[String]): Unit = {

    val whatIsApply: WhatIsApply = new WhatIsApply("Hi")
    println(whatIsApply)

    val whatIsApply1: WhatIsApply = WhatIsApply("Hoo")

    val adder = new MyAdder(2)
    val result = adder(4)
    println(result)

  }

  class MyAdder(x: Int) {
    def apply(y: Int) = x + y
  }

}
