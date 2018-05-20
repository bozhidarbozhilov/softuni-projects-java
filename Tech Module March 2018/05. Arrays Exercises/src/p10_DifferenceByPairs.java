import java.util.Arrays;
import java.util.Scanner;

public class p10_DifferenceByPairs {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int difference = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int firstDigit = 0; firstDigit < inputArr.length; firstDigit++) {
            for (int secondDigit = firstDigit; secondDigit < inputArr.length; secondDigit++) {
                if(Math.abs(inputArr[firstDigit]-inputArr[secondDigit])==difference){
                    counter++;
                }
            }
        }
        System.out.println(counter);

    }
}
