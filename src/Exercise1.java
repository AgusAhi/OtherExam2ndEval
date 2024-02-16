import java.io.*;
import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid number of arguments");
            System.exit(1);
        }
        Scanner scanner = new Scanner(System.in);
        String province = "";
        while (!province.equals("EXIT")) {
            province = readProvince(scanner, args[0]);
            if (!province.equals("EXIT")) {
                try {
                    printDeaths(province , args[0]);
                } catch (FileNotFoundException ex) {
                    System.out.println("File" + args[0] + " not found");
                    System.exit(1);
                } catch (IOException ex) {
                    System.err.println("Error reading file " + args[0]);
                }

            }
        }
    }

    public static String readProvince(Scanner scanner, String arg) {
        System.out.println("Enter a province name: ");
        return scanner.nextLine();
    }

    public static void printDeaths(String province, String filename) throws IOException {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filename));
            String line = input.readLine();
            int totalDeaths = 0;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String provinceItem = items[2];
                if (province.equalsIgnoreCase(provinceItem)) {
                    int deaths = Integer.parseInt(items[6]);
                    totalDeaths += deaths;
                }
            }
            System.out.println("Number of deaths in " + province + ": " + totalDeaths);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

}
