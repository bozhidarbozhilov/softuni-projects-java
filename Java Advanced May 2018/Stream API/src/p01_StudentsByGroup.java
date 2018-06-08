import java.util.*;

public class p01_StudentsByGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String group = tokens[2];
            String firstName = tokens[0];
            String lastName = tokens[1];

            Student currentStudent = new Student(firstName, lastName, group);
            students.add(currentStudent);

            input = scanner.nextLine();
        }

        students.stream()
                .filter(student -> student.getGroup().equals("2"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(student -> System.out.println(student.toString()));

    }
}
class Student{
    String firstName;
    String lastName;
    String group;

    public Student(String firstName, String lastName, String group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getGroup(){
        return this.group;
    }
    @Override
    public String toString(){
        return String.format("%s %s", this.firstName, this.lastName);
    }

}

