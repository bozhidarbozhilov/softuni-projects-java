import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class p02_StudentsByFirstAndLastNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student_p02> students = new ArrayList<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];

            Student_p02 currentStudent = new Student_p02(firstName, lastName);
            students.add(currentStudent);

            input = scanner.nextLine();
        }

        students.stream()
                .filter(student -> student.getFirstName().compareTo(student.getLastName())<0)
                .forEach(student -> System.out.println(student.toString()));

    }
}
class Student_p02{
    String firstName;
    String lastName;

    public Student_p02(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    @Override
    public String toString(){
        return String.format("%s %s", this.firstName, this.lastName);
    }

}