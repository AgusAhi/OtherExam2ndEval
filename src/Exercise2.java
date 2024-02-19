import java.io.*;
import java.util.*;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = readMap(args[0]);
        printMinimumInteger(map, 700);
    }

    public static Map<String, Integer> readMap(String filename) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filename));
            String line;
            input.readLine();
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String country = items[3];
                int infections = Integer.parseInt(items[5]);
                Integer freq = map.get(country); // Creamos una variable frecuencia para el país
                map.put(country, freq == null ? infections : freq + infections); // Si por ejemplo china tiene 1 infección y pasa a la siguiente línea y sigue siendo china, de normal no lo contaría porque salta al siguiente país
            } // con esto conseguimos meter el país y si la freq es == null que entre aquí y la siguiente infección de China se sume
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return map;
    }

    public static void printMinimumInteger(Map<String, Integer> infections, int min) {
        for (Map.Entry<String, Integer> mapEntry : infections.entrySet()) {
            if (mapEntry.getValue() >= min) {
                System.out.println(mapEntry.getKey() + ": " + mapEntry.getValue());
            }
        }
    }




}