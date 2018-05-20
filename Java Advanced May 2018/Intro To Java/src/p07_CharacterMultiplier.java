import java.util.Scanner;

public class p07_CharacterMultiplier {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] inputStrings = scanner.nextLine().split("\\s+");
        String firstStr = inputStrings[0];
        String secondStr = inputStrings[1];
        int sum = 0;

        if(firstStr.length()>secondStr.length()){
            for (int i = 0; i < secondStr.length(); i++) {
                int firstChar = firstStr.charAt(i);
                int secondChar = secondStr.charAt(i);
                sum += firstChar*secondChar;
            }
            for (int i = secondStr.length(); i < firstStr.length(); i++) {
                int _char = firstStr.charAt(i);
                sum += _char;
            }
        }else if(firstStr.length()<secondStr.length()){
            for (int i = 0; i < firstStr.length(); i++) {
                int firstChar = firstStr.charAt(i);
                int secondChar = secondStr.charAt(i);
                sum += firstChar*secondChar;
            }
            for (int i = firstStr.length(); i < secondStr.length(); i++) {
                int _char = secondStr.charAt(i);
                sum += _char;
            }
        }else{
            for (int i = 0; i < firstStr.length(); i++) {
                int firstChar = firstStr.charAt(i);
                int secondChar = secondStr.charAt(i);
                sum += firstChar*secondChar;
            }
        }

        System.out.println(sum);
    }
}
