import java.util.Arrays;
import java.util.Scanner;

public class p07_MaxSequenceOfIncreasingElements {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] intArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        int start = 0;
        int len = 1;
        int bestStart = Integer.MIN_VALUE;
        int bestLen = Integer.MIN_VALUE;

        for (int i = 1; i < intArr.length; i++) {
            if(intArr[i-1] < intArr[i]){
                len++;
            }else{
                len = 1;
                start = i;
            }
            if(len>bestLen){
                bestLen = len;
                bestStart = start;
            }
        }
        for (int i = bestStart; i < bestStart+bestLen; i++) {
            System.out.print(intArr[i]+" ");
        }
    }
}
