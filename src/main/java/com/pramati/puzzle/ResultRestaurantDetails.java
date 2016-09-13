package com.pramati.puzzle;

public class ResultRestaurantDetails {
  
  private Integer restaurant;
  private Float price;
  public Integer getRestaurant() {
    return restaurant;
  }
  public void setRestaurant(Integer restaurant) {
    this.restaurant = restaurant;
  }
  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }
  @Override
  public String toString() {
    return "ResultRestaurantDetails [restaurant=" + restaurant + ", price=" + price + "]";
  }
  
  

}
