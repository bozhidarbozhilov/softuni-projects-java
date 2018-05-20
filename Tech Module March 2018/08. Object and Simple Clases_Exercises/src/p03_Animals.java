import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class p03_Animals {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Snake> snakes = new ArrayList<>();

        String inputStr = scanner.nextLine();



        while(!inputStr.equals("I'm your Huckleberry")){
            String[] inputTokens = inputStr.split(" ");
            String name = inputTokens[1];
            switch (inputTokens[0]){
                case "Dog":
                    int ageOfDog = Integer.parseInt(inputTokens[2]);
                    int numberOfLegs = Integer.parseInt(inputTokens[3]);
                    Dog dog = Dog.parseDog(name,ageOfDog,numberOfLegs);
                    dogs.add(dog);
                    break;
                case "Cat":
                    int ageOfCat = Integer.parseInt(inputTokens[2]);
                    int intelligenceQuotient = Integer.parseInt(inputTokens[3]);
                    Cat cat = Cat.parseCat(name,ageOfCat,intelligenceQuotient);
                    cats.add(cat);
                    break;
                case "Snake":
                    int ageOfSnake = Integer.parseInt(inputTokens[2]);
                    int crueltyCoefficient = Integer.parseInt(inputTokens[3]);
                    Snake snake = Snake.parseSnake(name,ageOfSnake,crueltyCoefficient);
                    snakes.add(snake);
                    break;
                case "talk":
                    if(dogs.stream().anyMatch(n->n.getName().equals(name))){
                        Dog.produceSound();
                }else if(cats.stream().anyMatch(n->n.getName().equals(name))){
                        Cat.produceSound();
                }else{
                    Snake.produceSound();
                    }
                    break;
                default:
                    break;
            }
            inputStr = scanner.nextLine();
        }

        dogs.forEach(d-> System.out.printf("Dog: %s, Age: %d, Number Of Legs: %d%n",
                d.getName(),d.getAge(),d.getNumberOfLegs()));
        cats.forEach(c-> System.out.printf("Cat: %s, Age: %d, IQ: %d%n",
                c.getName(),c.getAge(),c.getIntelligenceQuotient()));
        snakes.forEach(s-> System.out.printf("Snake: %s, Age: %d, Cruelty: %d%n",
                s.getName(),s.getAge(),s.getCrueltyCoefficient()));
    }
}
class Dog{
    private String name;
    private int age;
    private int numberOfLegs;

    public Dog(String nameIn, int ageIn, int numberOfLegsIn){
        this.name = nameIn;
        this.age = ageIn;
        this.numberOfLegs = numberOfLegsIn;
    }
    public static Dog parseDog(String nameIn, int ageIn, int numberOfLegsIn){
        return new Dog(nameIn,ageIn,numberOfLegsIn);
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public int getNumberOfLegs(){return numberOfLegs;}
    public static void produceSound(){
        System.out.println("I'm a Distinguishedog, and I will now produce a distinguished sound! Bau Bau.");
    }
}
class Cat{
    private String name;
    private int age;
    private int intelligenceQuotient;

    public Cat(String nameIn, int ageIn, int intelligenceQuotientIn){
        this.name = nameIn;
        this.age = ageIn;
        this.intelligenceQuotient = intelligenceQuotientIn;
    }

    public static Cat parseCat(String nameIn, int ageIn, int intelligenceQuotientIn){
        return new Cat(nameIn,ageIn,intelligenceQuotientIn);
    }
    public String getName(){return name;}
    public int getAge(){return age;}
    public int getIntelligenceQuotient(){return intelligenceQuotient;}
    public static void produceSound(){
        System.out.println("I'm an Aristocat, and I will now produce an aristocratic sound! Myau Myau.");
    }
}
class Snake{
    private String name;
    private int age;
    private int crueltyCoefficient;

    public Snake(String name, int age, int crueltyCoefficient){
        this.name = name;
        this.age = age;
        this.crueltyCoefficient = crueltyCoefficient;
    }
    public static Snake parseSnake(String nameIn, int ageIn, int crueltyCoefficientIn){
        return new Snake(nameIn,ageIn,crueltyCoefficientIn);
    }

    public int getAge() {
        return age;
    }
    public String getName(){return name;}
    public int getCrueltyCoefficient(){return crueltyCoefficient;}
    public static void produceSound(){
        System.out.println("I'm a Sophistisnake, and I will now produce a sophisticated sound! Honey, I'm home.");
    }
}