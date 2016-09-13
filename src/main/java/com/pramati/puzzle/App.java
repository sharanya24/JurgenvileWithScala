package com.pramati.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author sharanyak
 *
 */
public class App {

  int index = 0;
  double price = 0;


  /**
   * @param args
   */
  public static void main(String[] args) {

    if (args.length >= 2) {
      ParseCsv parseCsv = new ParseCsv();
      ArrayList<RestaurantData> list = parseCsv.readCsv(args[0]);

      Collections.sort(list, new PriceComparator()); // sort data based on price

      List<Item> itemtoSearch = new ArrayList<Item>();
      for (int i = 1; i < args.length; i++) {
        itemtoSearch.add(new Item(args[i]));
      }

      App app = new App();
      ResultRestaurantDetails resultRestaurantDetails = app.findRestaurants(itemtoSearch, list);
      if (resultRestaurantDetails.getRestaurant() != null) {
        System.out.println("Restaurant :" + resultRestaurantDetails.getRestaurant()
            + " Total price :" + resultRestaurantDetails.getPrice());
      } else {
        System.out.println("Sorry no matching restaurant found for your selection.");
      }
    } else {
      System.out.println("Please enter file name with minimum 1 item to search..");
    }
  }

  /**
   * @param itemtoSearch
   * @param list
   * @return ResultRestaurantDetails with minimum price and best restaurant
   */
  public ResultRestaurantDetails findRestaurants(List<com.pramati.puzzle.Item> itemtoSearch,
      List<RestaurantData> list) {

    HashMap<Integer, Float> map = new HashMap<Integer, Float>();
    HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
    ResultRestaurantDetails resultRestaurantDetails = new ResultRestaurantDetails();
    int count = 0;
    // Get list of restaurants with matching items
    for (Item items : itemtoSearch) {
      for (RestaurantData data : list) {
        if (data.getItems().contains(items.getItemName())) {
          if (map.containsKey(data.getRestId())) {
            Float price = map.get(data.getRestId());
            price += data.getPrice();
            map.put(data.getRestId(), price);
            int countVal = counter.get(data.getRestId());
            countVal += 1;
            counter.put(data.getRestId(), countVal);

          } else {
            map.put(data.getRestId(), data.getPrice());
            counter.put(data.getRestId(), count + 1);
          }
        }
      }
    }



    Float minPrice = Float.MAX_VALUE;
    // find the Minprice restaurant
    for (Map.Entry<Integer, Float> entry : map.entrySet()) {
      for (Map.Entry<Integer, Integer> entry1 : counter.entrySet())
        if (entry.getKey().equals(entry1.getKey())) {
          if (entry1.getValue().equals(itemtoSearch.size()) && minPrice > entry.getValue()) {
            minPrice=entry.getValue();
            resultRestaurantDetails.setPrice(entry.getValue());
            resultRestaurantDetails.setRestaurant(entry.getKey());
          }
        }
    }

    return resultRestaurantDetails;
  }
}


