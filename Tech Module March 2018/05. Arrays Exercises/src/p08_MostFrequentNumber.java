import java.util.Arrays;
import java.util.Scanner;

public class p08_MostFrequentNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] intArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        //int currentBest = intArr[0];

        int maxOccurrencies = Integer.MIN_VALUE;

        int[] count = new int[intArr.length];

        for (int cnt = 0; cnt < intArr.length; cnt++) {
            for (int currentNum = cnt; currentNum < intArr.length; currentNum++) {
                if(intArr[currentNum]==intArr[cnt]){
                    count[cnt] +=1;
                }

            }
        }
        int counter = count[0];
        int bestNum = intArr[0];
        for (int maxValue = 1; maxValue < count.length; maxValue++) {
            if(count[maxValue]>counter){
                counter = count[maxValue];
                bestNum = intArr[maxValue];
            }
        }
        System.out.println(bestNum);
    }
}
