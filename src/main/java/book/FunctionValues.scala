package book

/**
  * Created by hovaheb on 11/25/2016.
  */
class
FunctionValues {

  /***************************************************************/
  println("Summer " + summer(11, i=> if(i%2 != 0) i else 0))
  def summer(number:Int,codeBlock:Int => Int):Int = {
    var result = 0
    for(i <- 1 to number){
      result += codeBlock(i)
    }
    result
  }
  /***************************************************************/
  println("summer inject:" + inject(0,Array(2, 3, 5, 1, 6, 4)) {(i, j)=> i+j})
  println("max inject: " + inject(Integer.MIN_VALUE,Array(54,2,-1,3)) {(h,g) => Math.max(h,g)})

  def inject(initial:Int , arr:Array[Int]) (operation: (Int,Int)=>Int):Int = {
    var result = initial
    arr.foreach(element => result = operation(result,element))
    result
  }
  val array = Array(1,2,3,4,5)
  val sun = (0 /: array){(sum , elem) => sum + elem }
  print(sun)

}
object FunctionValues{
  def main(args: Array[String]) {
    val fv : FunctionValues = new FunctionValues()

    println()
    val eq1 = new Equipment({input => println("calc with"  + input) ; input})
    val eq2 = new Equipment({input => println("calc with"  + input) ; input})
    eq1.simulate(4)
    eq2.simulate(41)
    //Reusing Function Values
    val calculator = {input:Int => println("calc with" + input);input}
    val e:Equipment = new Equipment(calculator);
    e.simulate(3)
    e.simulate(4)
  }
}

class Equipment (val routine : Int => Int){
  def simulate(input:Int) ={
    println("Running Simulation..")
    routine(input)
  }
}
