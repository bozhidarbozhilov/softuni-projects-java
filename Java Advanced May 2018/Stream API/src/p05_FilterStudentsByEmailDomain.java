import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class p05_FilterStudentsByEmailDomain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<StudentByEmail> students = new ArrayList<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String email = tokens[2];
            String firstName = tokens[0];
            String lastName = tokens[1];

            StudentByEmail currentStudent = new StudentByEmail(firstName, lastName, email);
            students.add(currentStudent);

            input = scanner.nextLine();
        }

        students.stream()
                .filter(student -> student.getEmail().endsWith("@gmail.com"))
                .forEach(student -> System.out.println(student.toString()));

    }
}
class StudentByEmail{
    String firstName;
    String lastName;
    String email;

    public StudentByEmail(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    @Override
    public String toString(){
        return String.format("%s %s", this.firstName, this.lastName);
    }

}
