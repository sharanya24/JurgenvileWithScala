package com.pramati.puzzle;

import java.util.Comparator;

public class PriceComparator implements Comparator<RestaurantData> {

  public int compare(RestaurantData o1, RestaurantData o2) {
    // TODO Auto-generated method stub
    return o1.getPrice().compareTo(o2.getPrice());
  }


}
