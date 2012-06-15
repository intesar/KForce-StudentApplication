package com.mycompany.studentapplicationsorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author intesar mohammed
 */
public class CsvReader {

    /**
     * read data from a given csv file path
     * @param filename
     * @return 
     */
    public List<Users> read(String filename) {
        List<Users> list = new ArrayList<Users>();
        BufferedReader bufRdr = null;
        try {
            bufRdr = new BufferedReader(new FileReader(filename));
            String line = null;
            while ((line = bufRdr.readLine()) != null) {
                String[] tokens = line.split(",");
                Users user = new Users(tokens[0], tokens[1], tokens[2], tokens[3]);
                list.add(user);
            }

        } catch (IOException ex) {
            Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufRdr.close();
            } catch (IOException ex) {
                Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
