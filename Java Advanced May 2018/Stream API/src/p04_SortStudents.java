import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class p04_SortStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<StudentByNames> students = new ArrayList<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];

            StudentByNames currentStudent = new StudentByNames(firstName, lastName);
            students.add(currentStudent);

            input = scanner.nextLine();
        }

        students.stream()
                .sorted(Comparator.comparing(StudentByNames::getLastName)
                        .thenComparing((s1,s2)->s2.getFirstName().compareTo(s1.getFirstName())))
                .forEach(student -> System.out.println(student.toString()));

    }
}
class StudentByNames{
    String firstName;
    String lastName;

    public StudentByNames(String firstName, String lastName){
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