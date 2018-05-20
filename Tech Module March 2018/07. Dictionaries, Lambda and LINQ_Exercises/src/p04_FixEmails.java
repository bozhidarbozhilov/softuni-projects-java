import java.util.LinkedHashMap;
import java.util.Scanner;

public class p04_FixEmails {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();


        LinkedHashMap<String,String> emailList = new LinkedHashMap<>();

        while(!name.equals("stop")){
            String email = scanner.nextLine();
            if(!email.endsWith("uk") && !email.endsWith("us")){
                emailList.put(name,email);
            }

            name = scanner.nextLine();
        }

        emailList.entrySet().stream().forEach(e-> System.out.println(e.getKey()+" -> "+e.getValue()));
    }
}
