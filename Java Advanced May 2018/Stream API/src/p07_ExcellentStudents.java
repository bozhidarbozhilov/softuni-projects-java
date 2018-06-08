import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p07_ExcellentStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<ExcellentStudents> students = new ArrayList<>();
        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }

            ExcellentStudents currentStudent = new ExcellentStudents(firstName, lastName, grades);
            students.add(currentStudent);

            input = scanner.nextLine();
        }
        students.stream()
                .filter(student->student.getGrades().contains(6))
                .forEach(s-> System.out.println(s.toString()));
    }
}
class ExcellentStudents{
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public ExcellentStudents(String firstName, String lastName, List<Integer> grades){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString(){
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
