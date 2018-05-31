import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> palindromes = new TreeSet<>();
        String[] input = scanner.nextLine().split("[!,.?\\s]+");

        for (String word : input) {
            if(isPalindrome(word)){
                palindromes.add(word);
            }
        }
        System.out.println(palindromes);
    }

    private static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);

        return sb.toString().equals(sb.reverse().toString());
    }
}
