package book.practicefromwork

/**
  * Created by hovaheb on 1/9/2017.
  */
object TraitChapter {

  trait Friend {
    val name: String

    def listen() = println("your friend " + name + " is listening")
  }

  class Human(val name: String) extends Friend

  class Man(override val name: String) extends Human(name)

  class WoMan(override val name: String) extends Human(name)

  class Animal

  class Dog(val name: String) extends Animal with Friend {
    override def listen() = println(name + " listening quietly")
  }

  def main(args: Array[String]): Unit = {
    val john = new Man("John")
    val johnet = new WoMan("Johnet")
    val j = new Dog("J")
    val mansBestFriend: Friend = j
    j.listen()

    val c = new Check with SecurityCheck with MilitaryCheck
    println(c.check())

    val writerA: StringWriterDelegate = new StringWriterDelegate with WriterA with WriterB
    writerA write "hi"

    val writerB: StringWriterDelegate = new StringWriterDelegate with WriterB with WriterA
    writerB write "BYE"

    println(writerA)
    println(writerB)
  }


  abstract class Check {
    def check(): String = " Checking "
  }

  trait SecurityCheck extends Check {
    override def check(): String = " Security Check " + super.check()
  }

  trait MilitaryCheck extends Check {
    override def check(): String = " MilitaryCheck " + super.check()
  }


  abstract class Writer {
    def write(message: String)
  }

  trait WriterA extends Writer {
    abstract override def write(message: String) = super.write(message.toUpperCase())
  }

  trait WriterB extends Writer {
    abstract override def write(message: String) = super.write(message.toLowerCase())
  }

  class StringWriterDelegate extends Writer {
    val writerObj = new java.io.StringWriter

    override def write(message: String): Unit = {
      writerObj.write(message)
    }

    override def toString: String = writerObj.toString
  }


}
