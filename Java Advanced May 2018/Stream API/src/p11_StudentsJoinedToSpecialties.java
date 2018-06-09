import java.util.*;
import java.util.stream.Collectors;

public class p11_StudentsJoinedToSpecialties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<StudentSpecialty> specialties = new ArrayList<>();
        List<StudentJoin> students = new ArrayList<>();

        String input = scanner.nextLine();

        while(!"Students:".equals(input)){
            String[] tokens = input.split("\\s+");
            String specialty = tokens[0] + " " + tokens[1];
            String facultyNumber = tokens[2];

            StudentSpecialty currentSpecialty = new StudentSpecialty(specialty, facultyNumber);
            specialties.add(currentSpecialty);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");

            String name = tokens[1] + " " + tokens[2];
            String facultyNumber = tokens[0];

            StudentJoin currentStudent = new StudentJoin(name, facultyNumber);
            students.add(currentStudent);

            input = scanner.nextLine();
        }

        students.stream().sorted(Comparator.comparing(StudentJoin::getStudentName))
                .forEach(student-> {
                    specialties.stream().forEach(specialty-> {
                        if (student.getFacultyNumber().equals(specialty.getFacultyNumber())) {
                            System.out.printf("%s %s %s%n", student.getStudentName(), student.getFacultyNumber()
                                    ,specialty.getSpecialtyName());
                        }
                    });

                });

    }
}
class StudentSpecialty{
    String specialtyName;
    String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber){
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }
    public String getSpecialtyName(){
        return specialtyName;
    }
    public String getFacultyNumber(){
        return facultyNumber;
    }
}
class StudentJoin{
    String studentName;
    String facultyNumber;

    public StudentJoin(String studentName, String facultyNumber){
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }
}
