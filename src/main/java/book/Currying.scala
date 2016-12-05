package book

/**
  * Created by hovaheb on 11/25/2016.
  */
class Currying {
  def foo(a: Int)(b: Int)(c: Int) {}

}

object Currying {
  def main(args: Array[String]) {
    val c: Currying = new Currying()
    //called foo _ to create a partially applied function
    //Scala provides the notation _, the underscore, to represent parameters of a function value.
    //Each time you use the underscore within a function, it represents a subsequent parameter.
    println(c.foo _)
    println(c.foo(1) _)
    println(c.foo(1)(2) _)
    println(c.foo(1)(2)(3))

    val arr = Array(1, 2, 33, 4, 5)

    println("Sum of all values in array is " +
      (0 /: arr) {(sum,elem)=>sum + elem}
    )

    println("Sum of all values in array is " +
      (0 /: arr) {
        _ + _
      }
    )

    val negativeNumberExists = arr.exists(_ < 0)
    val negativeNumberExists1 = arr.exists((z:Int) => {z < 0})
    println("Array has any negative number?" + negativeNumberExists)
    println("Array has any negative number?" + negativeNumberExists1)

    val maxOfTwoNumbers = {(x:Int,y:Int)=> {if(x > y) x else y}}
    val max = (Integer.MIN_VALUE /: arr)  {((large,elem) => maxOfTwoNumbers(large,elem))}
    val max2 = (Integer.MIN_VALUE /: arr)  {maxOfTwoNumbers(_,_)}

    def max2Funtion(a: Int, b: Int) : Int = if (a > b) a else b
    val max3 = (Integer.MIN_VALUE /: arr) { max2Funtion _ }
    //val max4 = (Integer.MIN_VALUE /: arr) { maxOfTwoNumbers _ }
    val max5 = (Integer.MIN_VALUE /: arr) { max2Funtion }

    println(maxOfTwoNumbers(2,5))
    println(max)
    println(max2)
    println(max3)
    //println(max4)
    println(max5)

  }
}

