import java.util.Scanner;

public class p01_LargestCommonEnd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] firstString = scanner.nextLine().split("\\s+");
        String[] secondString = scanner.nextLine().split("\\s+");

        int rightCounter = 0;
        int leftCounter = 0;
        int smallerArrayLength = Math.min(firstString.length,secondString.length);

        for (int leftCount = 0; leftCount < smallerArrayLength; leftCount++) {
            if(firstString[leftCount].equals(secondString[leftCount])){
                leftCounter++;

            }
        }
        for (int rightCount = 0; rightCount < smallerArrayLength ; rightCount++) {
            if(firstString[firstString.length-1-rightCount].equals(secondString[secondString.length-1-rightCount])){
                rightCounter++;

            }
        }
        System.out.println(Math.max(leftCounter,rightCounter));
    }
}
