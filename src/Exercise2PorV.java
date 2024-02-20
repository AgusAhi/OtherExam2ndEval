import java.util.*;

class Person implements Comparable<Person> { // tiene que ser comparable porque estamos comparando una persona con otra
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    @Override
    public int compareTo(Person person) { // la interfaz comparable obliga a implementar esta clase
        if (this.age < person.age) {
            return -1;
        } else if (this.age > person.age) {
            return 1;
        } else {
            return 0;
        }
        // Forma rápida: return age - person.age;
    }
}

public class Exercise2PorV {
    public static void main(String[] args) { // public solo irá la clase del examen
        List<Person> list = new ArrayList<>();
        list.add(new Person("Victor", 24));
        list.add(new Person("Eva", 25));
        list.add(new Person("Lusi", 14));
        Collections.sort(list); // lo que me pide aquí es un comparable, una lista de comparables
        for (Person p : list) {
            System.out.println(p);
        }


    }
}
