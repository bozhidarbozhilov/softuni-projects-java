import java.util.ArrayList;
import java.util.Scanner;

public class p03_StudentsByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<StudentByAge> students = new ArrayList<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            int age = Integer.parseInt(tokens[2]);
            String firstName = tokens[0];
            String lastName = tokens[1];

            StudentByAge currentStudent = new StudentByAge(firstName, lastName, age);
            students.add(currentStudent);

            input = scanner.nextLine();
        }

        students.stream()
                .filter(student -> student.getAge()>=18 && student.getAge()<=24)
                .forEach(student -> System.out.println(student.toString()));

    }
}
class StudentByAge{
    String firstName;
    String lastName;
    int age;

    public StudentByAge(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString(){
        return String.format("%s %s %d", this.firstName, this.lastName, this.age);
    }

}

