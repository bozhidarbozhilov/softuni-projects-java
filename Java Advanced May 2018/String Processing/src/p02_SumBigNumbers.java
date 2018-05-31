import java.util.Scanner;

public class p02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder firstNum = new StringBuilder(scanner.nextLine());
        StringBuilder secondNum = new StringBuilder(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int lengthDifference = firstNum.length() - secondNum.length();
        if(lengthDifference>0){
            for (int i = 0; i < lengthDifference; i++) {
                secondNum.insert(0,"0");
            }
        }else if(lengthDifference<0){
            for (int i = 0; i < Math.abs(lengthDifference); i++) {
                firstNum.insert(0,"0");
            }
        }
        int remainder = 0;

        for (int i = firstNum.length()-1; i>=0; i--) {
            int currentResult = Character.getNumericValue(firstNum.charAt(i))
                    + Character.getNumericValue(secondNum.charAt(i))
                    + remainder;
            result.insert(0,currentResult%10);
            if(currentResult<10){
                remainder = 0;
            }else {
                remainder = 1;
            }
        }
        if(remainder != 0){
            result.insert(0,remainder);
        }
        while(result.toString().startsWith("0")){
            result.deleteCharAt(0);
        }

        System.out.println(result.toString());
    }
}
