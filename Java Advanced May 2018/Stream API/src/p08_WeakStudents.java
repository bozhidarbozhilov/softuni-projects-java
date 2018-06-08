import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p08_WeakStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<WeakStudents> students = new ArrayList<>();
        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }

            WeakStudents currentStudent = new WeakStudents(firstName, lastName, grades);
            students.add(currentStudent);

            input = scanner.nextLine();
        }
        students.stream()
                .filter(student->student.getGrades().stream().filter(g->g<=3).count()>= 2)
                .forEach(s-> System.out.println(s.toString()));
    }

}
class WeakStudents{
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public WeakStudents(String firstName, String lastName, List<Integer> grades){
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
