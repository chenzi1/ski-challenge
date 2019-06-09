package orange;

import orange.object.Location;
import orange.service.Utilities;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class SkiChallengeApplication implements Runnable{

    public static void main(String[] args) {
        new SkiChallengeApplication().run();
//        SpringApplication.run(SkiChallengeApplication.class, args);
    }

    @Override
    public void run() {
        boolean firstRow = true;
        List<Integer> dimensions;
        List<Integer> lineSplit;

        int row = 1;
        int column =1;
        int largest = 0;
        int smallest = Integer.MAX_VALUE;
        int smallestLoc = 0;

        try {
            LineIterator it = FileUtils.lineIterator(new File("src/main/resources/map.txt"), "UTF-8");
            try {
                Map<String, Integer> mountainMap = new HashMap<>();
                dimensions = Utilities.splitLine(it.nextLine());
                while (it.hasNext()) {
                    System.out.println("Row : " + row);
                    lineSplit = Utilities.splitLine(it.nextLine());
                    for ( int number : lineSplit ) {
                        if(number > largest) {
                            largest = number;
                        } else if (number < smallest) {
                            smallest = number;
                            smallestLoc = row;
                        }
//                        System.out.print(number + " ");
                        mountainMap.put(Utilities.getStringLocation(row,column) , number);
                        System.out.print(mountainMap.get(Utilities.getStringLocation(row,column)) + " ");
                        column++;
                    }
                    row++;
                    System.out.println("");
                }
            } finally {
                System.out.println("total rows : " + row);
                System.out.println("Largest value : " + largest);
                System.out.println("Smallest value : " + smallest + " Row : " + smallestLoc);
                it.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
