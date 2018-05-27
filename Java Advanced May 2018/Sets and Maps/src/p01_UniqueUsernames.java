import java.util.LinkedHashSet;
import java.util.Scanner;

public class p01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        var userNames = new LinkedHashSet<String>();

        for (int i = 0; i < num; i++) {
            userNames.add(scanner.nextLine());
        }
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}
