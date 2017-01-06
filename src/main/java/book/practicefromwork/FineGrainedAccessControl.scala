package book.practicefromwork

import scala.beans.BeanProperty

/**
  * Created by hovaheb on 1/5/2017.
  */
package society {
  package professional {

    class Executive {
      private[professional] var workDetails = null
      private[society] var friends = null
      private[this] var secrets = null

      def help(another: Executive): Unit = {
        println(another.workDetails)
        //println(another.secrets) ERROR
      }

      def anotherMethod(): Unit = {
        secrets
      }
    }

  }

  package social {

    class Acquintance {
      def socialize(person: professional.Executive): Unit = {
        println(person.friends)
        //println(person.workDetails) ERROR
      }
    }

  }

}

class Car(val year: Int) {
  var milesDriven: Int = 0
  var name: String = _
  // Scala provides the convenience for initializing var to its default using the underscore
  @BeanProperty var age: Double = _

  // Scala provides the convenience for initializing var to its default using the underscore
  def miles() = milesDriven

  def drive(distance: Int): Unit = {
    milesDriven += distance
  }
}

class CreditCard(val number: Int, var credit: Int)

class Vehicle(val id: Int, val year: Int) {
  override def toString: String = "ID " + id
}

class Truck(override val id: Int, override val year: Int, val fuelLevel: Int) extends Vehicle(id, year) {
  override def toString: String = super.toString + " fuel " + fuelLevel
}

class A(val x: Int) {

}

object A {
  def test: Unit = {
    val a: A = new A(2)

  }
}

class Marker(val color: String) {
  println("creating " + this)

  override def toString: String = "Marker " + color
}

object MarkerFactory {
  private val markers = Map(
    "red" -> new Marker("red"),
    "yellow" -> new Marker("yellow"),
    "blue" -> new Marker("blue")
  )

  def getMarker(color: String) = {
    if (markers.contains(color)) {
      markers(color)
    }
    else
      null
  }
}

object FineGrainedAccessControl {
  def main(args: Array[String]): Unit = {
    val car = new Car(2009)
    println(car.year)
    println(car.miles)
    car.drive(10)
    println(car.miles)
    println(car.name)
    println(car.age)
    println(car.getAge())
    car.setAge(10)
    println(car.getAge())

    println(MarkerFactory.getMarker("red"))
    for (input <- Set("test", "hack")) {
      val comment = commentOnPractice(input)
      println("input " + input + " comment " +
        comment.getOrElse("Found no comments"))
    }
    println(max(1,5,3))
    println(max(3,9,8,44,5))
    val numbers = Array(2, 5, 3, 7, 1, 6)
    var arr1 = new Array[Int](3)
    arr1(0) = 1
    arr1(2) = 1
    arr1(1) = 12
    println(numbers.getClass.getSimpleName)
    println(arr1.getClass.getSimpleName)

    println(max(numbers:_*))
    println(max(arr1:_*))
    val pets = new Array[Pet](2)
    pets(0) = new Pet("p1")
    pets(1) = new Pet("p2")
    /*val pets = Array(new Pet("Rover" ), new Pet("Comet" ))*/
    /*val dogs = new Array[Dog](2) = ("d1" , "d2")*/
    val dogs = Array(new Dog("Rover" ), new Dog("Comet" ))
    playWithPets(pets)
    /*playWithPets(dogs)*/ //ERROR! no covariance
    workWithPets(dogs)
    workWithPets(pets)
    copyPets(dogs , pets)
    copyPets(pets , pets)
    /*copyPets(pets , dogs)*/ // ERROR
    var list1 = new MyList1[Int]
    var list2 = new MyList1[Any]
    /*list1 = list2*/ //ERROR NO CONTRAVARIANCE
    list2 = list1 // WE ALLOWED COVARIANCE BY USING +T

    var list12 = new MyList2[Int]
    var list22 = new MyList2[Any]
    list12 = list22 // CONTRAVARIANCE ALLOWED
    /*list22 = list12*/ // COVARIANCE NOT POSSIBLE


  }
  class MyList1[+T]
  class MyList2[-T]
  class Pet(val name:String){
    override def toString: String = "Pet Name: " + name
  }
  class Dog(override val name:String) extends Pet(name){
    override def toString: String = "Dog Name: " + name
  }

  def playWithPets(pets:Array[Pet]) {
    for(i <-pets){
      println(i)
    }
  }
  def workWithPets[T <: Pet](pets:Array[T]): Unit ={
    for(i <-pets){
      println(i)
    }
  }
  def copyPets[S, D >: S](fromPets:Array[S],toPets:Array[D]): Unit ={

  }

  def check1() = true

  //def check2() = return true ERROR using return forces us to declare the return type

  def commentOnPractice(input: String) = {
    //rather than returning null
    if (input == "test") Some("good") else None

  }

  def max(input: Int*) =input.foldLeft(input(0)) {println("max is: " )
    Math.max}
}