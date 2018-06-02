import java.util.Scanner;
import java.util.regex.Pattern;

public class p10_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = "^(\\+359)([ -]*)(2)\\2(\\d{3})\\2(\\d{4})$";

        String input = scanner.nextLine();
        while(!"end".equals(input)){

            if(Pattern.matches(pattern, input)){
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }

}
