package book.intermixingwithjava.equipmentsample

/**
  * Created by hovaheb on 12/5/2016.
  */
class Equipment {
  // Not usable from Java
  def simulate(input: Int)(calculator: Int => Int) : Int = {
    //...
    calculator(input)
  }

  def run(duration: Int) {
    println("running")
    //...
  }
}