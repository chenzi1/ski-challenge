package orange.service;

import orange.object.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Utilities {

    public static List<Integer> splitLine(String line) {
        List<String> listOfString = asList(line.split(" "));
        List<Integer> listOfInteger = new ArrayList<>();
        listOfString.forEach( num -> {
            listOfInteger.add(Integer.parseInt(num));
        });
        return listOfInteger;
    }

    public static String getStringLocation(int row, int column) {
        String location = row + "," + column;
        return  location;
    }


}
