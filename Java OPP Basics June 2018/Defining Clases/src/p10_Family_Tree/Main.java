package p10_Family_Tree;

import javafx.util.Pair;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Pair<String, String>> pairs = new ArrayList<>();
        Map<String, String> namesAndBirthdays = new LinkedHashMap<>();

        String mainPerson = scanner.nextLine();

        String treeData = scanner.nextLine();

        while(!"End".equals(treeData)){

            if(treeData.contains(" - ")){
                String[] tokens = treeData.split(" - ");
                pairs.add(new Pair<>(tokens[0], tokens[1]));
            }else{
                String[] tokens = treeData.split("\\s+");
                namesAndBirthdays.put(tokens[0]+" "+tokens[1], tokens[2]);
            }
            treeData = scanner.nextLine();
        }

        Pair<String, String> mainPersonNameAndDate = setPair(namesAndBirthdays, mainPerson);
        Person currentPerson = new Person(mainPersonNameAndDate.getKey(), mainPersonNameAndDate.getValue());
        for (Pair<String, String> pair : pairs) {
            if(pair.getKey().equals(currentPerson.getName())||pair.getKey().equals(currentPerson.getBirthDate())){
                Pair<String, String> child = setPair(namesAndBirthdays, pair.getValue());
                Child currentChild = new Child(child.getKey(), child.getValue());
                currentPerson.addChild(currentChild);
            }
            if(pair.getValue().equals(currentPerson.getName())||pair.getValue().equals(currentPerson.getBirthDate())){
                Pair<String, String> parent = setPair(namesAndBirthdays, pair.getKey());
                Parent currentParent = new Parent(parent.getKey(), parent.getValue());
                currentPerson.addParent(currentParent);
            }
        }

        System.out.printf("%s %s%n", currentPerson.getName(), currentPerson.getBirthDate());
        System.out.println("Parents:");
        currentPerson.getParents()
                .forEach(parent -> System.out.printf("%s %s%n", parent.getName(),parent.getBirthDate()));
        System.out.println("Children:");
        currentPerson.getChildren()
                .forEach(child -> System.out.printf("%s %s%n", child.getName(), child.getBirthDate()));
    }
    private static Pair<String, String> setPair(Map<String, String> namesAndDates, String knownParameter){
        Pattern namePattern = Pattern.compile("\\w* \\w*");
        Pattern datePattern = Pattern.compile("\\d+\\/\\d+\\/\\d+");
        String birthDate = "";
        String name = "";
        if(namePattern.matcher(knownParameter).matches()){
            name = knownParameter;
            birthDate = namesAndDates.get(knownParameter);
        }else if(datePattern.matcher(knownParameter).matches()){
            birthDate = knownParameter;
            name = namesAndDates.entrySet().stream()
                    .filter(d->d.getValue().equals(knownParameter)).findFirst().get().getKey();
        }
        return new Pair<String, String> (name, birthDate);
    }
}
