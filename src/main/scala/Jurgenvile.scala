import scala.collection.mutable.ListBuffer

/**
  * Created by sharanyak on 18/8/16.
  */


case class BestRestaurant(var restId: Int = 0, var price: Float = 0, var flag: Boolean = false) {
  override def toString = "Restaurant ==> " + restId + "\t price ==> " + price
}

object Main {

  def main(args: Array[String]) {

    if (args.length >= 1) {
      val itemArray=new Array[String](args.length-1)
      Array.copy(args,1,itemArray,0,itemArray.length)
      val reader = new CSVReader
      val listOfData = reader.parseCSV(args(0))
      val jurgenvile = new Jurgenvile
      val itemsToSearch = jurgenvile.readUserItemList(itemArray)
      jurgenvile.findRestaurants(listOfData, itemsToSearch)
    }
    else {
      println("Please enter file name with minimum 1 item")
    }

  }


}

class Jurgenvile {

  def readUserItemList(listOfItems: Array[String]): ListBuffer[String] = {
    val itemsToSearch = ListBuffer[String]()
    for (index <- 0 until listOfItems.length) {
      itemsToSearch += listOfItems(index)
    }
    itemsToSearch
  }


  def findRestaurants(listOfData: ListBuffer[RestaurantData], itemsToSearch: ListBuffer[String]): BestRestaurant = {

    var map = Map[Int, Float]()
    var counter = Map[Int, Int]()
    val initialCount = 1
    for (item <- itemsToSearch) {
      for (restaurantList <- listOfData) {
        if (restaurantList.items.contains(item)) {
          if (map.contains(restaurantList.restId)) {
            var price = map.get(restaurantList.restId).get
            price += restaurantList.price
            map += restaurantList.restId -> price
            var countVal = counter.get(restaurantList.restId).get
            countVal += 1
            counter += restaurantList.restId -> countVal
          }
          else {
            map += restaurantList.restId -> restaurantList.price
            counter += restaurantList.restId -> initialCount
          }
        }
      }

    }

    var maxPrice = Float.MaxValue
    val restaurantDetails = new BestRestaurant
    for ((k, v) <- map) {
      for ((k1, v1) <- counter) {
        if (k == k1) {
          if (v1 == itemsToSearch.length && maxPrice > v) {
            maxPrice = v
            restaurantDetails.restId = k
            restaurantDetails.price = v
            restaurantDetails.flag = true

          }
        }
      }
    }
    if (restaurantDetails.flag) {
      restaurantDetails
    }
    else {
      println("Nil. No matching Restaurant found for your selection")
      null
    }
  }

}