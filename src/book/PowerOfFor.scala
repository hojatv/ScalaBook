package book

/**
  * Created by hovaheb on 11/29/2016.
  */
class PowerOfFor {


}
object PowerOfFor{
  def main(args: Array[String]): Unit = {
    val p: PowerOfFor = new PowerOfFor
    val result = for(i <- 1 to 3)
      yield i*2
    println(result)

    val result2 = (1 to 10) map(_ * 2)
    println(result2)

    val doubleEven = for(i <- 1 to 10
                         if i%2==0) yield i*2
    println(doubleEven)
  }
}
