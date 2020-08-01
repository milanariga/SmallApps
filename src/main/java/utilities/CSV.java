package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ana on 8/1/2020
 */
public class CSV {

    public static List<String[]> read(String fileName){
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;

        try {
                BufferedReader bf = new BufferedReader(new FileReader(fileName));
                while((dataRow = bf.readLine()) != null) {
                    String[] dataRecords = dataRow.split(",");
                    data.add(dataRecords);
                }
        } catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("FILE COULD NOT BE READ");
            e.printStackTrace();
        }
        return data;

    }
}
