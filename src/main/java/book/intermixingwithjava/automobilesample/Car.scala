package book.intermixingwithjava.automobilesample

/**
  * Created by hovaheb on 12/5/2016.
  */
class Car(val year: Int) {
  private[this] var miles: Int = 0

  def drive(distance: Int): Unit = {
    miles += distance
  }

  override def toString: String = "year:" + year + " miles:" + miles

}
