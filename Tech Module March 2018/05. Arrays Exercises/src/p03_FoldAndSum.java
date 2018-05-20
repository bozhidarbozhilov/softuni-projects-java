import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_FoldAndSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf)
                .toArray();
        int k = inputArr.length/4;

        int[] lowerArr = new int[2*k];
        int[] upperArr = new int[2*k];
        int[] tempArr = new int[k];

        for (int i = 0; i < k; i++) {
            upperArr[i] = inputArr[k-i-1];
        }
        for (int i = tempArr.length-1; i >=0; i--) {
            tempArr[i] = inputArr[4*k-i-1];
        }
        for (int i = 0; i < upperArr.length/2 ; i++) {
            upperArr[k+i] = tempArr[i];
        }

        for (int i = 0; i < lowerArr.length; i++) {
            lowerArr[i] = inputArr[i+k];
        }

        int[] sumArr = new int[2*k];
        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i] = upperArr [i] + lowerArr[i];
        }

        System.out.println(Arrays.stream(sumArr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
