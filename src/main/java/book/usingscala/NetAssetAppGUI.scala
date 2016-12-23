package book.usingscala

import java.awt.Color

import scala.actors._
import scala.actors.scheduler.SingleThreadedScheduler
import scala.swing._
import scala.swing.event.ButtonClicked

/**
  * Created by hovaheb on 12/23/2016.
  */
object NetAssetAppGUI extends SimpleSwingApplication {
  override def top = mainFrame

  val mainFrame = new MainFrame {
    title = "Net Asset"
    val dateLabel = new Label {
      text = "Last Updated : -----"
    }
    val valuesTable = new Table(NetAssetStockPriceHelper.getInitialTableValues, Array("Ticker", "Units", "Price", "Value")) {
      showGrid = true
      gridColor = Color.BLACK
    }
    val updateButton = new Button {
      text = "update"
    }
    val netAssetLabel = new Label {
      text = "Net Asset: ????"
    }
    contents = new BoxPanel(Orientation.Vertical) {
      contents += dateLabel
      contents += valuesTable
      contents += new ScrollPane(valuesTable)
      contents += new FlowPanel {
        contents += updateButton
        contents += netAssetLabel
      }
    }
    listenTo(updateButton)
    reactions += {
      case ButtonClicked(button) =>
        button.enabled = false
        NetAssetStockPriceHelper fetchPrice uiUpdater
    }

    val uiUpdater = new Actor {
      override def act(): Unit = {
        loop {
          react {
            case (symbol: String, units: Int, price: Double, value: Double) =>
              updateTable(symbol, units, price, value)
            case netAsset =>
              netAssetLabel.text = "NetAsset: " + netAsset
              dateLabel.text = "Last Updated: " + new java.util.Date()
              updateButton.enabled = true
          }
        }
      }

      override  def scheduler() = new SingleThreadedScheduler
    }
    uiUpdater.start()

    def updateTable(symbol: String, units: Int, price: Double, value: Double): Unit = {
      for (i <- 0 until valuesTable.rowCount) {
        if (valuesTable(i, 0) == symbol) {
          valuesTable(i, 2) = price
          valuesTable(i, 3) = value
        }
      }
    }
  }
}


