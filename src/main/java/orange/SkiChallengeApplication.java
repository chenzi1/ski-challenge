package orange;

import orange.service.utilities;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

        int count = 0;

        try {
            LineIterator it = FileUtils.lineIterator(new File("src/main/resources/map.txt"), "UTF-8");
            try {
                dimensions = utilities.splitLine(it.nextLine());
                while (it.hasNext()) {
                    lineSplit = utilities.splitLine(it.nextLine());
                    System.out.println(lineSplit.get(0));
                    count++;
                }
            } finally {
                System.out.println("total rows : " + count);
                it.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
