import java.util.Scanner;

public class p07_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0.0;
        int constForCapitalLetters = 64;
        int constForLowerCaseLetters = 96;

        for (String anInput : input) {
            double number = Double.parseDouble(anInput.substring(1, anInput.length() - 1));
            char firstLetter = anInput.charAt(0);
            char lastLetter = anInput.charAt(anInput.length() - 1);
            if(Character.isLowerCase(firstLetter)){
                number *= (firstLetter - constForLowerCaseLetters);
            }else{
                number /= (firstLetter - constForCapitalLetters);
            }
            if(Character.isLowerCase(lastLetter)){
                sum += number + (lastLetter-constForLowerCaseLetters);
            }else{
                sum += number - (lastLetter - constForCapitalLetters);
            }
        }
        System.out.printf("%.2f", sum);

    }
}
