package com.pramati.puzzle;

import java.util.Comparator;

/**
 * @author sharanyak
 *
 */
public class Item implements Comparator<Item> {
  private String itemName;
  private Float price;


  public Item(String itemName) {

    this.itemName = itemName;

  }

  public Item(String itemName, Float price) {
    super();
    this.itemName = itemName;
    this.price = price;
  }


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item [itemName=" + itemName + ", price=" + price + "]";
  }

  @Override
  public int compare(Item o1, Item o2) {
    // TODO Auto-generated method stub
    return o1.getItemName().compareTo(o2.getItemName());
  }



}
