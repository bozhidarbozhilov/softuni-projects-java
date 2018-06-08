import java.util.*;
import java.util.stream.Collectors;

public class p09_StudentsEnrolled_2014or2015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while(!"END".equals(line)){
            String[] tokens = line.split("\\s+");
            String facultyNumber = tokens[0];
            List<Integer> grades = Arrays.stream(tokens).skip(1).map(Integer::parseInt)
                    .collect(Collectors.toList());
            students.putIfAbsent(facultyNumber, new ArrayList<>());
            students.get(facultyNumber).addAll(grades);
            line = scanner.nextLine();
        }

        students.entrySet().stream()
                .filter(student -> student.getKey().endsWith("14") || student.getKey().endsWith("15"))
                .forEach(grades->{
                    grades.getValue().stream()
                            .forEach(g-> System.out.print(g+" "));
                    System.out.println();
                });

    }
}
