package strategyPattern;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> nameSorted = new TreeSet<Person>(new NameComparator());
        Set<Person> ageSorted = new TreeSet<Person>(new AgeComparator());

        int peopleCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < peopleCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            nameSorted.add(person);
            ageSorted.add(person);
        }
        for (Person personByName : nameSorted) {
            System.out.println(personByName);
        }
        for (Person personByAge : ageSorted) {
            System.out.println(personByAge);
        }
    }
}
