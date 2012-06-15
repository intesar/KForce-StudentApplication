package com.mycompany.studentapplicationsorting;

import java.util.Collections;
import java.util.List;

/**
 * Main class
 *
 */
public class App {

    public static void main(String[] args) {
        // read csv
        CsvReader csvReader = new CsvReader();
        List<Users> list = csvReader.read("users.csv");
        
        // sort 
        Collections.sort(list);
        
        // print
        System.out.println(list);
    }
}
