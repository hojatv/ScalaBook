package book

/**
  * Created by hovaheb on 11/28/2016.
  */
class Traits {

  trait Friend {
    val name: String

    def listen() = println("Your friend " + name + " is listening")
  }

  class Human(val name: String) extends Friend {

  }

  class Man(override val name: String) extends Human(name) {

  }

  class Animal() {

  }

  class Dog(val name: String) extends Animal with Friend {
    override def listen(): Unit = {
      println(name + "'s listening")
    }

  }

  class Cat (val name: String) extends Animal{

  }
  def useFriend(friend:Friend): Unit ={
    friend.listen()

  }


}

object Traits {
  def main(args: Array[String]): Unit = {
    val t: Traits = new Traits()
    val john = new t.Man("")
    val speed = new t.Dog("speed")

    /*john.listen()
    speed.listen()*/

    t.useFriend(john)
    t.useFriend(speed)

    val c = new t.Cat("catty")
    //t.useFriend(c)
    val c1 = new t.Cat("cooty") with t.Friend {

    }
    t.useFriend(c1)



  }
}
