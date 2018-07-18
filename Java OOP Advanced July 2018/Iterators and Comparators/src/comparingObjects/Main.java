package comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            input = scanner.nextLine();
        }

        int indexFromListToEqual = Integer.parseInt(scanner.nextLine());
        Person personToEqual = people.get(indexFromListToEqual-1);

        int equalPeople = 0;
        int unequalPeople = 0;

        for (Person person : people) {
            if(personToEqual.compareTo(person)==0){
                equalPeople++;
            }else{
                unequalPeople++;
            }
        }

        if(equalPeople == 0 || equalPeople == 1){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d", equalPeople, unequalPeople, people.size());
        }
    }
}
