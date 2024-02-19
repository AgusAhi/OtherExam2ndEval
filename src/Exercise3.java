import java.io.*;
import java.util.List;
import java.util.Map;

public class Exercise3 {
    Dni dni;
    String name;
    int age;

    public Exercise3(Dni dni, String name, int age) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public String toString() {
        return dni.toFormattedString() + " " + name + " (" + age + ")";
    }
    
    public void writePersons(List<Exercise3> persons, String filename) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            for (Exercise3 person : persons) {
                out.println(person.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing file " + filename);
        }
    }
}
