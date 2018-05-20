import java.util.Arrays;
import java.util.Scanner;

public class p11_EqualSums {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int len = inputArr.length;

        int leftSum = 0;
        int rightSum = 0;
        int index = 0;

        while(true) {
            leftSum = 0;
            rightSum = 0;
            for (int left = 0; left < index; left++) {
                leftSum+=inputArr[left];
            }
            for (int right = index+1; right < len; right++) {
                rightSum += inputArr[right];
            }
            if (leftSum == rightSum) {
                System.out.println(index);
                break;
            }
                index++;
            if (index == len) {
                System.out.println("no");
                break;
            }
        }
    }
}
