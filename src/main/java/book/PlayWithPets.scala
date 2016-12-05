package book


/**
  * Created by hovaheb on 11/24/2016.
  */
class PlayWithPets {

  class Pet(val name: String) {
    override def toString() = {
      name
    }
  }

  class Dog(override val name: String) extends Pet(name)

  def workWithPets(pets: Array[Pet]) {}

  def playWithPets[T <: Pet](pets: Array[T]) = println("Playing with pets " + pets.mkString(" ,"))

  val dogs = Array(new Dog("Rover"), new Dog("Commet"))

  def copyPets[S,D >: S](fromPets:Array[S], toPets:Array[D])={}

  //workWithPets(dogs)
  playWithPets(dogs)

  val pets:Array[Pet] = new Array[Pet](10)
  copyPets(dogs,pets)

  class MyList[+T]
  var list1 = new MyList[Int]
  var list2 : MyList[Any] = null
  list2 = list1 // OK




}

object PlayWithPets {
  def main(args: Array[String]) {
    val p: PlayWithPets = new PlayWithPets()
    for (input <- p.dogs) {
      println(input.name)
    }


  }
}


