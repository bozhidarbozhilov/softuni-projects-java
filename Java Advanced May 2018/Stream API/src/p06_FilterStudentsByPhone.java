import java.util.*;

public class p06_FilterStudentsByPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,List<String>> students = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String phone = tokens[2];
            String firstName = tokens[0];
            String lastName = tokens[1];

            students.putIfAbsent(phone, new ArrayList<>());
            students.get(phone).add(firstName+" "+lastName);

            input = scanner.nextLine();
        }

        students.entrySet().stream()
                .filter(student -> student.getKey().startsWith("02") || student.getKey().startsWith("+3592"))
                .forEach(s-> s.getValue().stream()
                        .forEach(v-> System.out.println(v)));
    }
}
