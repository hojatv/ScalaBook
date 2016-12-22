package book.usingscala
import scala.swing._
import scala.swing.event.ButtonClicked
/**
  * Created by hovaheb on 12/21/2016.
  */
object SampleGUI  extends SimpleSwingApplication{
  override def top: Frame = new MainFrame{
    title = "A Sample GUI Application"
    val label = new Label {text = "------"}
    val button = new Button { text = "Click Me"}

    contents = new FlowPanel {
      contents += label
      contents +=button
    }
    listenTo(button)
    reactions +={
      case ButtonClicked(button) => label.text =  " You Clicked!"
    }
  }
}
