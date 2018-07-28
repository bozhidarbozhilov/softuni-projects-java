package problems_5_6_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifable> identities = new ArrayList<>();
        List<Birthable> birthables = new ArrayList<>();


        String line = scanner.nextLine();
        while(!"End".equals(line)){
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            switch (type){
                case "Citizen":

                    Integer age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    Birthable citizen = new Citizen(name,age,id,birthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String petBirthDate = tokens[2];
                    Birthable pet = new Pet(name, petBirthDate);
                    birthables.add(pet);
                    break;
                case "Robot":
                    break;
                default:
                    break;


            }
/*            if(tokens.length==3){
                String name = tokens[0];
                Integer age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Identifable citizen = new Citizen(name,age,id);
                identities.add(citizen);
            }else{
                String name = tokens[0];
                String id = tokens[1];
                Identifable robot = new Robot(name,id);
                identities.add(robot);
            }*/
            line = scanner.nextLine();
        }
/*        String fakeIds = scanner.nextLine();

        for (Identifable identity : identities) {
            if(identity.getId().endsWith(fakeIds)){
                System.out.println(identity.getId());
            }
        }*/
        String specificYear = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if(birthable.getBirthDate().endsWith(specificYear)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
