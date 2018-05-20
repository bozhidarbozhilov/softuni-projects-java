import java.util.LinkedHashMap;
import java.util.Scanner;

public class p01_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();

        String inputStr = scanner.nextLine();

        while(!inputStr.equals("END")){
            String command = inputStr.split("\\s+")[0];
            if(command.equals("A")){
                String name = inputStr.split("\\s+")[1];
                String phoneNumber = inputStr.split("\\s+")[2];
                phoneBook.put(name,phoneNumber);
            }else if(command.equals("S")){
                String nameToSearch = inputStr.split("\\s+")[1];
                if(phoneBook.containsKey(nameToSearch)){
                    System.out.printf("%s -> %s%n",nameToSearch,phoneBook.get(nameToSearch));
                }else{
                    System.out.printf("Contact %s does not exist.%n",nameToSearch);
                }
            }
            inputStr = scanner.nextLine();
        }
    }
}
