package equalityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> people = new TreeSet<>();
        Set<Person> hashPerson = new HashSet<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < peopleCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            people.add(person);
            hashPerson.add(person);
        }
        System.out.println(people.size());
        System.out.println(hashPerson.size());
    }
}
