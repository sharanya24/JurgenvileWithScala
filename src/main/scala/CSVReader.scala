

import java.io.FileNotFoundException

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by sharanyak on 17/8/16.
  */


case class RestaurantData(restId: Int, price: Float, items: List[String]) {
}


class CSVReader {

  def parseCSV(filePath: String): ListBuffer[RestaurantData]= {

    var listOfRestaurantData = ListBuffer[RestaurantData]()
    try {
      val lines = Source.fromFile(filePath).getLines()
      for (line <- lines) {
        val wordsInLine = line.split(",").map(_.trim)
        wordsInLine.length match {
          case 3 => val restaurantData = RestaurantData(wordsInLine(0).toInt, wordsInLine(1).toFloat, List(wordsInLine(2)))
            listOfRestaurantData += restaurantData
          case len if wordsInLine.length > 3 =>
            val valueMeal: List[String] = List()
            for (value <- 0 until wordsInLine.length) {
              wordsInLine(value) :: valueMeal
            }
            val restaurantData = RestaurantData(wordsInLine(0).toInt, wordsInLine(1).toFloat, valueMeal)
            listOfRestaurantData += restaurantData
          case _ =>
        }
      }

    }
    catch {
      case fe:FileNotFoundException => println("Please check whether file exists : "+ fe.getMessage)
                                        System.exit(1)
      case ex:Exception => println("Exception caught"+ ex.getMessage)
                            System.exit(1)
    }
    listOfRestaurantData
  }
}
