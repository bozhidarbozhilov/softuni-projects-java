import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!"search".equals(input)){
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phoneBook.put(name, number);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while(!"stop".equals(input)){
            if(phoneBook.containsKey(input)){
                System.out.println(input + " -> " + phoneBook.get(input));
            }else{
                System.out.printf("Contact %s does not exist.%n",input);
            }
            input = scanner.nextLine();
        }
    }
}
