import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable.ListBuffer

/**
  * Created by sharanyak on 19/8/16.
  */

class JurgenvileTest extends FunSuite with BeforeAndAfter {


  val args: Array[String] = Array("burger","tofu_log")
  val args1 : Array[String]=Array("chef_salad","wine_spritzer")
  val args2:Array[String]=Array("fancy_european_water","extreme_fajita")

  val reader = new CSVReader
  val obj = new Jurgenvile
  var listOfData = new ListBuffer[RestaurantData]()
  var itemsToSearch = new ListBuffer[String]()

  test("Reading CSV file ...") {
    listOfData = reader.parseCSV("sample_data.csv")
    assert(listOfData.nonEmpty)
  }
  test("Reading user search items...") {
    itemsToSearch = obj.readUserItemList(args)
    assert(itemsToSearch.nonEmpty)
  }
  test("Finding best restaurant for user search items with case 1") {
    itemsToSearch=obj.readUserItemList(args)
    assert(obj.findRestaurants(listOfData, itemsToSearch) != null)
  }
  test("Finding best restaurant for user search items with case 2") {
    itemsToSearch=obj.readUserItemList(args1)
    assert(obj.findRestaurants(listOfData, itemsToSearch) == null)
  }
  test("Finding best restaurant for user search items with case 3") {
    itemsToSearch=obj.readUserItemList(args2)
    assert(obj.findRestaurants(listOfData, itemsToSearch) != null)
  }


}
