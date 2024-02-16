import java.io.*;
import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {
        printMap();
    }

    private static Map<String, Integer> map;

    public Exercise2() throws IOException {
        map = new HashMap<>();
        readMap();
    }

    private void readMap() throws IOException {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("corona.csv"));
            String line = input.readLine();
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String country = items[3];
                int infections = Integer.parseInt(items[5]);
                map.put(country, infections);
                minimumInteger();
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private void minimumInteger(Map.Entry<String, Integer> entry ,int min) {
            System.out.print(entry.getValue() + " ");
        }

    }

    private static void printMap() {
        System.out.println(map);
    }


}