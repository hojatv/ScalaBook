package book

/**
  * Created by hovaheb on 11/24/2016.
  */
class MyMarker private(color: String) {
  println("Making color: " + color)

  override def toString():String= {
    "MyMarker " + color;
  }

}

object MyMarker {
  private val markers = Map(
    "red" -> new MyMarker("red"),
    "blue" -> new MyMarker("blue"),
    "green" -> new MyMarker("green")
  )

  def getMarker(color: String) = {
    if (markers.contains(color)) markers.get(color) else null;
  }

  def apply(color:String) = {
    if (markers.contains(color)) markers.get(color) else null;
  }


}
