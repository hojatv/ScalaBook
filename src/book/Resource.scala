package book

/**
  * Created by hovaheb on 11/25/2016.
  */
/*Execute Around Method pattern*/
class Resource private() {
  println("Starting Transaction")

  private def cleanUp() {
    println("Ending Transaction")
  }

  def op1 = println("Operation1")

  def op2 = println("Operation2")

  def op3 = println("Operation3")

}

object Resource {
  val resource = new Resource

  def use(codeBlock: Resource => Unit) {
    try {
      codeBlock(resource)
    } finally {
      resource.cleanUp();
    }
  }

  def main(args: Array[String]) {
    /*Resource.use(resource => resource.op1)
    Resource.use(resource => resource.op2)*/

    Resource.use ( resource => (resource.op1,resource.op2,resource.op3) )
  }
}
