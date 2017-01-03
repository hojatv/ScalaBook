
/**
  * Created by hovaheb on 12/30/2016.
  */

import java.io._

import akka.actor.SupervisorStrategy.Restart
import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props}

import scala.concurrent.duration._
import scala.io._

object WordCounter {

  case class FileToCount(fileName: String)

  case class WordCount(fileName: String, count: Int)

  case class StartCounting(docRoot: String, numActors: Int)

  class WordCountWorker extends Actor {
    def countWords(fileName: String) = {
      /*val x = 5 / 0*/
      val dataFile = new File(fileName)
      Source.fromFile(dataFile).getLines.foldRight(0)(_.split(" ").size + _)
    }

    def receive = {
      case FileToCount(fileName: String) =>
        val count = countWords(fileName)
        sender ! WordCount(fileName, count)
    }

    override def postStop(): Unit = {
      println(s"Worker actor is stopped: ${self}")
    }

    override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 3, withinTimeRange = 5 seconds) {
      case ex: Exception => Restart
      case _ => Restart
    }
  }

  class WordCountMaster extends Actor {
    var fileNames: Seq[String] = Nil
    var sortedCount: Seq[(String, Int)] = Nil

    def receive = {
      case StartCounting(docRoot, numActors) =>
        val workers = createWorkers(numActors)
        fileNames = scanFiles(docRoot)
        beginSorting(fileNames, workers)
      case WordCount(fileName, count) =>
        sortedCount = sortedCount :+ (fileName, count)
        sortedCount = sortedCount.sortWith(_._2 < _._2)
        if (sortedCount.size == fileNames.size) {
          println("final result " + sortedCount)
          finishSorting()
        }
    }

    override def postStop(): Unit = {
      println(s"Master actor is stopped: ${self}")
    }

    private def createWorkers(numActors: Int) = {
      for (i <- 0 until numActors) yield context.actorOf(Props[WordCountWorker], name = s"worker-${i}")
    }

    private def scanFiles(docRoot: String) =
      new File(docRoot).list.map(docRoot + _)

    private[this] def beginSorting(fileNames: Seq[String], workers: Seq[ActorRef]) {
      fileNames.zipWithIndex.foreach(e => {
        workers(e._2 % workers.size) ! FileToCount(e._1)
      })
    }

    private[this] def finishSorting() {
      context.system.shutdown()
    }
    /*override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 3, withinTimeRange = 5 seconds) {
      //case _: Exception => Restart
      case _ => println("Restarting...")
        Restart
    }*/
    /*override val supervisorStrategy = AllForOneStrategy(){
      //case _: Exception => Restart
      case _ => println("Restarting...")
        Restart
    }*/
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("word-count-system")
    val m = system.actorOf(Props[WordCountMaster], name = "master")
    m ! StartCounting("src/main/java/book/cuncurrentprogramming/akka/", 2)
  }
}