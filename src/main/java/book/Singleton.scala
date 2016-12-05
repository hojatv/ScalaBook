package book

/**
  * Created by hovaheb on 11/24/2016.
  */
class Marker private(val color: String) {
  println("Creating " + this)

  override def toString(): String = "marker color " + color
}

object Marker {
  private val markers = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  def getMarker(color: String) =
    if (markers.contains(color)) markers(color) else null

  def primaryColors() = "red, green, blue"


  def apply(color: String) = if (markers.contains(color)) markers(color) else null


}
