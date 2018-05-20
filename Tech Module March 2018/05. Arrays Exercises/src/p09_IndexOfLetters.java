import java.util.Scanner;

public class p09_IndexOfLetters {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char[] letters = new char[26];
        for (int letter = 0; letter < 26; letter++) {
            letters[letter] = (char) (letter+97) ;
        }
        char[] inputStr = scanner.nextLine().toLowerCase().toCharArray();

        for (char _char : inputStr) {
                for (int letter = 0; letter < letters.length; letter++) {

                if(_char == letters[letter]){
                    System.out.println(_char+" -> "+letter);
                }
            }
        }

    }
}
