package orange.service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class utilities {

    public static List<Integer> splitLine(String line) {
        List<String> listOfString = asList(line.split(" "));
        List<Integer> listOfInteger = new ArrayList<>();
        listOfString.forEach( num -> {
            listOfInteger.add(Integer.parseInt(num));
        });
        return listOfInteger;
    }


}
