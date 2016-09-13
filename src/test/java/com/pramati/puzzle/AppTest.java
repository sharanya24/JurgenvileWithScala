package com.pramati.puzzle;

import java.io.FileNotFoundException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{

  String[] testArgs={"sample_data.csv","burger","tofu_log"};// test case 1
  String[] testArgs1={"sample_data.csv", "chef_salad","wine_spritzer"};
  String[] testArgs2={"sample_data.csv","fancy_european_water","extreme_fajita"};
        
    @org.junit.Test(expected=FileNotFoundException.class)
    public void readFileTest(){
     ParseCsv testParseCsv=new ParseCsv();
     testParseCsv.readCsv("");
  }
    
    @org.junit.Test
    public void testOne(){
     App.main(testArgs); 
     
    }
    
    @org.junit.Test
    public void testTwo(){
      App.main(testArgs1); 
    }
    
    @org.junit.Test
    public void testThree(){
      App.main(testArgs2); 
    }
    
    
    
    
}
