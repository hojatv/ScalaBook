package book.practicefromwork

/**
  * Created by hovaheb on 1/6/2017.
  */
object FunctionValuesAndClosures {
  def main(args: Array[String]): Unit = {
    println(totalResultOverRange(4, i => if (i % 2 != 0) i else 0)) // The => separates the param list from implementation on the right

    val array = Array(2,3,4,5,6)
    val sum = inject(array,0,(carryOber,element) => carryOber + element)
    var max = inject(array,Integer.MIN_VALUE,(carryOver,element)=> Math.max(carryOver,element))
    println(("Sum of arrray's element") + array.toString + " is " + sum)
    println(("Max of arrray's element") + array.toString + " is " + max)

    val sum2 = (0 /: array){(sum1,element1) => sum1+ element1}
    println(sum2)

    val max2 = (Integer.MIN_VALUE /: array){(e,c)=> Math.max(e,c)}
    println(max2)

  }

  def totalResultOverRange(number: Int, codeBlock: Int => Int) = {
    var result = 0
    for (i <- 1 to number) {
      result += codeBlock(i)
    }
    result
  }

  def inject(arr: Array[Int], inial: Int, operation: (Int, Int) => Int): Int = {
    var carryOver = inial
    arr.foreach(element => carryOver = operation(carryOver, element))
    carryOver
  }

}
