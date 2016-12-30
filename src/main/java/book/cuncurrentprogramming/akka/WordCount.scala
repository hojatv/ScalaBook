package book.cuncurrentprogramming.akka

import java.io.File

import akka.actor.Actor

import scala.io.Source

/**
  * Created by hovaheb on 12/30/2016.
  */
class WordCount {

  case class FileToCount(fileName: String)

  case class WordCount(fileName: String, count: Int)

  case class StartCounting(docRoot: String, numActors: Int)

  class WordCountWorker extends Actor {

    def countWords(fileName: String): Int = {
      val dataFile = new File(fileName)
      Source.fromFile(dataFile).getLines.foldRight(0)(_.split(" ").size + _)
    }

    override def receive = {
      case FileToCount(fileName: String) =>
        val count = countWords(fileName)
        sender ! WordCount(fileName, count)
    }
  }

  class WordCountMaster extends Actor{
    var fileNames: Seq[String] = Nil
    var sortedCount : Seq[(String,Int)] = Nil

    override def receive = {
      case StartCounting(docRoot,numActors) =>
        val workers = createWorkers(numActors)
        fileNames = scanFiles(docRoot)
        beginSorting(fileNames,workers)
      case WordCount(fileName, count) =>
        sortedCount = sortedCount :+ (fileName,count)
        sortedCount = sortedCount.sortWith(_._2 < _._2)
        if(sortedCount.size == fileName.size) {
          println("final result " + sortedCount)
          finishSorting()
        }
    }

    override def postStop(): Unit = {
      println(s"Master Actor is stopped: ${self}")
    }

    private def createWorkers(numActors:Int): Unit ={
      for(i <- 0 until numActors) yield context.actorOf()
    }
  }


}
