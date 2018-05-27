import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> fixedEmails = new LinkedHashMap<>();
        int counter = 1;

        String name = "";
        String email = "";

        String input = scanner.nextLine();

        while(!"stop".equals(input)){
            if(counter % 2 != 0){
                name = input;
                fixedEmails.putIfAbsent(name, "");
            }else{
                email = input;
                fixedEmails.put(name, email);
            }
            counter++;
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : fixedEmails.entrySet()) {
            if (!entry.getValue().endsWith("uk") && !entry.getValue().endsWith("us") && !entry.getValue().endsWith("com")) {
                System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
