import java.util.Arrays;
import java.util.Scanner;

public class p07_1_BombNumbersArrayEdition {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numPower = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int bombNumber = numPower[0];
        int power = numPower[1];

        for (int leftSide = 0; leftSide< inputArr.length; leftSide++) {
            if(inputArr[leftSide] == bombNumber){
                if(leftSide-power<=0){
                    for (int leftBomb1 = 0;  leftBomb1<leftSide ; leftBomb1++) {
                        inputArr[leftBomb1] = 0;
                    }
                }else{
                    for (int leftBomb2 = leftSide-power; leftBomb2 < leftSide; leftBomb2++) {
                        inputArr[leftBomb2] = 0;
                    }
                }
            }
        }
        for (int rightSide = 0; rightSide < inputArr.length; rightSide++) {
            if(inputArr[rightSide] == bombNumber){
                if(power+rightSide>=inputArr.length){
                    for (int rightBomb1 = rightSide; rightBomb1 < inputArr.length; rightBomb1++) {
                        inputArr[rightBomb1] = 0;
                    }
                }else{
                    for (int rightBomb2 = rightSide; rightBomb2 <= rightSide+power; rightBomb2++) {
                        inputArr[rightBomb2] = 0;
                    }
                }
            }
        }
        int sum = 0;
        for (int sumCnt = 0; sumCnt < inputArr.length; sumCnt++) {
            sum += inputArr[sumCnt];
        }
        System.out.println(sum);
    }
}
