package com.pramati.puzzle;

/**
 * @author sharanyak
 *
 */
public class RestaurantData {

  private Integer restId;
  private Float price;
  private String items;


  public Integer getRestId() {
    return restId;
  }

  public void setRestId(Integer restId) {
    this.restId = restId;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getItems() {
    return items;
  }

  @Override
  public String toString() {
    return "RestaurantData [restId=" + restId + ", price=" + price + ", items=" + items + "]";
  }

  public void setItems(String items) {
    this.items = items;
  }



}
