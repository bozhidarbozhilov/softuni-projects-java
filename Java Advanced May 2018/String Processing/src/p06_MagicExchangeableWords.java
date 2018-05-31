import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        System.out.println(isExchangeable(input[0], input[1]));
    }

    private static boolean isExchangeable(String firstWord, String secondWord) {
        char[] firstChars = firstWord.toCharArray();
        char[] secondChars = secondWord.toCharArray();
        Map<Character, Character> symbols = new LinkedHashMap<>();
        boolean isExchangeable = true;
        int lengthDifference = firstChars.length - secondChars.length;

        if(lengthDifference>=0){
            for (int i = 0; i < secondChars.length; i++) {
                symbols.putIfAbsent(firstChars[i], secondChars[i]);
                if(symbols.containsKey(firstChars[i]) && symbols.get(firstChars[i]) != secondChars[i]){
                    isExchangeable = false;
                    break;
                }
            }
            for (int i = secondChars.length; i < firstChars.length; i++) {
                if(!symbols.containsKey(firstChars[i])){
                    isExchangeable = false;
                    break;
                }
            }
        }else{
            for (int i = 0; i < firstChars.length; i++) {
                symbols.putIfAbsent(secondChars[i], firstChars[i]);
                if(symbols.containsKey(secondChars[i]) && symbols.get(secondChars[i]) != firstChars[i]){
                    isExchangeable = false;
                    break;
                }
            }
            for (int i = firstChars.length; i < secondChars.length; i++) {
                if(!symbols.containsKey(secondChars[i])){
                    isExchangeable = false;
                    break;
                }
            }
        }

        return isExchangeable;
    }
}
