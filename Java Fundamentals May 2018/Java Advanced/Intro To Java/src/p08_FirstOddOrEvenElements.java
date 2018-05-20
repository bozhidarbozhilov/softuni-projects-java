import java.util.Arrays;
import java.util.Scanner;

public class p08_FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] parameters = scanner.nextLine().split("\\s+");
        int maxNumberOfElements = Integer.parseInt(parameters[1]);
        String oddOrEven = parameters[2];
        int counter = 1;

        switch(oddOrEven){
            case "odd":
                for (int num : nums) {
                    if (counter <= maxNumberOfElements) {
                        if (num % 2 != 0) {
                            System.out.print(num + " ");
                            counter++;
                        }

                    }
                }
                break;
            case "even":
                for (int num : nums) {
                    if (counter <= maxNumberOfElements) {
                        if (num % 2 == 0) {
                            System.out.print(num + " ");
                            counter++;
                        }

                    }
                }

                    break;
            default:
                break;

        }
    }
}
