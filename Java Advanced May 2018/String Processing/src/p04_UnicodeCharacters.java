import java.util.Scanner;

public class p04_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String hexChar = String.format("\\u00%s", Integer.toHexString(input.charAt(i)));
            result.append(hexChar);
        }
        System.out.println(result.toString());
    }
}
