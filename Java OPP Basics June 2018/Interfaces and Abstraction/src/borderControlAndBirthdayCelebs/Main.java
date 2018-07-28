package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifable> identities = new ArrayList<>();

        String line = scanner.nextLine();
        while(!"End".equals(line)){
            String[] tokens = line.split("\\s+");
            if(tokens.length==3){
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
            }
            line = scanner.nextLine();
        }
        String fakeIds = scanner.nextLine();

        for (Identifable identity : identities) {
            if(identity.getId().endsWith(fakeIds)){
                System.out.println(identity.getId());
            }
        }
    }
}
