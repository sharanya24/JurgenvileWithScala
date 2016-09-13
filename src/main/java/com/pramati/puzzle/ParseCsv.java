package com.pramati.puzzle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author sharanyak
 *
 */
public class ParseCsv {


  String line;
  private final String splitDelim = ",";

  /**
   * @param filePath
   * @return
   */
  public ArrayList<RestaurantData> readCsv(String filePath) {

    ArrayList<RestaurantData> restaurantDataset = new ArrayList<RestaurantData>();
    try {
      BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
      while ((line = bufReader.readLine()) != null) {

        StringTokenizer token = new StringTokenizer(line, splitDelim);
        if (token.countTokens() >= 3)// check if line contains restId, price, items
        {
          int index = 0;
          RestaurantData restaurantData = new RestaurantData();
          while (token.hasMoreTokens()) {
            switch (index) {
              case 0:
                restaurantData.setRestId(Integer.parseInt(token.nextToken()));

                index++;
                break;

              case 1:
                restaurantData.setPrice(Float.parseFloat(token.nextToken()));
                index++;
                break;

              default:
                StringBuffer sb = new StringBuffer();
                if (token.countTokens() > 1) { // check for more than one item i.e., Value Meal
                  while (token.hasMoreTokens())

                    sb.append(token.nextToken().trim() + ",");

                } else
                  sb.append(token.nextToken().trim());
                restaurantData.setItems(sb.toString());
                break;
            }
          }
          restaurantDataset.add(restaurantData);
        }

      }
      bufReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found" + e.getMessage());
    } catch (IOException e) {
      System.out.println("Error while reading file" + e.getMessage());
    }
    return restaurantDataset;
  }
}
