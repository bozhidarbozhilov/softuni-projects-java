import java.util.*;
import java.util.stream.Collectors;

public class p10_GroupByGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String name =tokens[0]+" "+tokens[1];
            String group = tokens[2];
            Person currentPerson = new Person(name, group);
            persons.add(currentPerson);
            input = scanner.nextLine();
        }

        Map<String, List<Person>> groupedPeople = persons.stream()
                .collect(Collectors.groupingBy(Person::getGroup));


        groupedPeople.entrySet().stream()
                .forEach(group->{
                    System.out.println(group.getKey() + " - " +
                    group.getValue().stream().map(p->p.getName()).collect(Collectors.joining(", ")));

                });
    }
}
class Person{
    private String name;
    private String group;

    public Person(String name, String group){
        this.name = name;
        this.group = group;
    }

    public String getName(){
        return name;
    }
    public String getGroup(){
        return group;
    }
}
