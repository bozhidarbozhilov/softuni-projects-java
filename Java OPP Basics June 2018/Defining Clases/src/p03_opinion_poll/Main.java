package p03_opinion_poll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person currentPerson = new Person(name, age);
            persons.add(currentPerson);
        }

        persons.stream()
                .filter(p->p.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p-> System.out.println(p));
    }
}
