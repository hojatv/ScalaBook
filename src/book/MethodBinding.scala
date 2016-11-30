package book

import java.io.StringWriter

/**
  * Created by hovaheb on 11/28/2016.
  */
class MethodBinding {

  abstract class Writer {
    def writeMessage(message: String)
  }

  /*Scala does two things on the call to super.writeMessage in this code. First,
  it performs late binding of that call. Second, it will insist that the class
  that mixes these traits provide an implementation of the method.*/

  trait UpperCaseWriter extends Writer {
    abstract override def writeMessage(message: String) = super.writeMessage(message.toUpperCase())
  }

  trait profanityFilteredWriter extends Writer {
    abstract override def writeMessage(message: String) = super.writeMessage(message.replace("stupid", "s----"))
  }

  class StringWriterDelegate extends Writer {
    val writer = new StringWriter

    def writeMessage(message: String) = writer.write(message)

    override def toString: String = writer.toString

  }


}

object MethodBinding {
  def main(args: Array[String]): Unit = {
    val methodBinding: MethodBinding = new MethodBinding
    val myWriterProfanityFirst = new methodBinding.StringWriterDelegate with methodBinding.UpperCaseWriter with methodBinding.profanityFilteredWriter
    val myWriterProfanityLast = new methodBinding.StringWriterDelegate with methodBinding.profanityFilteredWriter with methodBinding.UpperCaseWriter

    myWriterProfanityFirst writeMessage "There is no sin except stupidity"
    myWriterProfanityLast writeMessage "There is no sin except stupidity"

    println(myWriterProfanityFirst)
    println(myWriterProfanityLast)
  }
}