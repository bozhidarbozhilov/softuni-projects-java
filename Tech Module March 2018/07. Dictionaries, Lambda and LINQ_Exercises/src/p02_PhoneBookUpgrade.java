import java.util.Scanner;
import java.util.TreeMap;

public class p02_PhoneBookUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> phoneBook = new TreeMap<>();

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
            }else if(command.equals("ListAll")){
                phoneBook.entrySet().stream()
                        .forEach(c -> System.out.printf("%s -> %s%n",c.getKey(),c.getValue()));
            }
            inputStr = scanner.nextLine();
        }
    }
}
