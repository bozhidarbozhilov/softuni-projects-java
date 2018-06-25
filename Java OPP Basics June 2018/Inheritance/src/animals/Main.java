package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while(true){
            String _class = scanner.nextLine();
            if(_class.equals("Beast!")){
                break;
            }
            String[] animalParameters = scanner.nextLine().split("\\s+");

            try{
                if(animalParameters.length<3){
                    throw new IllegalArgumentException("Invalid input!");
                }
                String name = animalParameters[0];
                String age = animalParameters[1];
                String gender = animalParameters[2];

                Animal currentAnimal = createObject(_class);
                if(currentAnimal == null){
                    throw new IllegalArgumentException("Invalid input!");
                }
                currentAnimal.setName(name);
                currentAnimal.setAge(age);
                currentAnimal.setGender(gender);
                System.out.print(currentAnimal);
            }catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

    }

    private static Animal createObject(String aClass) {
        switch (aClass){
            case "Animal":
                return new Animal();
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            case "Frog":
                return new Frog();
            case "Kitten":
                return new Kitten();
            case "Tomcat":
                return new Tomcat();
            default:
                return null;
        }
    }
}
