import java.util.Arrays;
import java.util.Scanner;

public class p05_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        if(numbers.length%2==0){
            for (int cnt = 1; cnt < numbers.length; cnt+=2) {
                if(numbers[cnt-1]%2==0 && numbers[cnt]%2==0){
                    System.out.printf("%d, %d -> both are even\n", numbers[cnt-1], numbers[cnt]);
                }else if(numbers[cnt-1]%2!=0 && numbers[cnt]%2!=0){
                    System.out.printf("%d, %d -> both are odd\n", numbers[cnt-1], numbers[cnt]);
                }else{
                    System.out.printf("%d, %d -> different\n", numbers[cnt-1], numbers[cnt]);
                }
            }
        }else{
            System.out.println("invalid length");
        }

    }
}
