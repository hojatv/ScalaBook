package book.practicefromwork

/**
  * Created by hovaheb on 1/6/2017.
  */
object FunctionValuesAndClosures {
  def main(args: Array[String]): Unit = {
    println(totalResultOverRange(4, i => if (i % 2 != 0) i else 0)) // The => separates the param list from implementation on the right

    val array = Array(2, 3, 4, 5, 6)
    val sum = inject(array, 0)((carryOber, element) => carryOber + element)
    var max = inject(array, Integer.MIN_VALUE)((carryOver, element) => Math.max(carryOver, element))
    var testNullOperation = inject(array, Integer.MIN_VALUE)(_)
    println(("Sum of arrray's element") + array.toString + " is " + sum)
    println(("Max of arrray's element") + array.toString + " is " + max)
    println(("test Null Operation") + array.toString + " is " + testNullOperation)

    val sum2 = (0 /: array) { (sum1, element1) => sum1 + element1 }
    println(sum2)

    val max2 = (Integer.MIN_VALUE /: array) { (e, c) => Math.max(e, c) }
    println(max2)

    val addOneOperation = { x: Int => x + 1 }
    val e: Equipment = new Equipment(addOneOperation)
    println(e.simulation(4))
    println(e.simulation(3))
    val divideByTwoOperation = { x: Int => x / 2 }
    val e2: Equipment = new Equipment(divideByTwoOperation)
    println(e2.simulation(4))

    val arr = Array(1, 2, 3, 4, 5)
    println("Sum of Elements")
    println(println((0 /: arr) { (sum1, ele) => sum + ele }))
    /*Since we’re using sum and elem only once each,we can eliminate those names and write the code as follows*/
    println((0 /: arr) {
      _ + _
    })

    var result = 0; // result is a closure; it is defined out of the addit scope, but its accessible inside it and after the addit operation is finished it will be updated
    val addIt ={ value:Int => result += value}
    var product =  1;
    loopThrough(10)(product *= _)

    loopThrough(10)(addIt)
    println(result)
    println(product)

  }

  def totalResultOverRange(number: Int, codeBlock: Int => Int) = {
    var result = 0
    for (i <- 1 to number) {
      result += codeBlock(i)
    }
    result
  }

  def loopThrough(number:Int)(closure:Int => Unit)={
    for(i <- 1 to number){
      closure(i)
    }

  }

  def inject(arr: Array[Int], inial: Int)(operation: (Int, Int) => Int): Int = {
    var carryOver = inial
    arr.foreach(element => carryOver = operation(carryOver, element))
    carryOver
  }

}

class Equipment(val routine: Int => Int) {
  def simulation(input: Int): Int = {
    routine(input)
  }
}