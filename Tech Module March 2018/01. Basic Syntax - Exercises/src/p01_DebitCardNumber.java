import java.util.Scanner;

public class p01_DebitCardNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int forthNumber = Integer.parseInt(scanner.nextLine());

        System.out.printf("%04d %04d %04d %04d%n",firstNumber, secondNumber, thirdNumber, forthNumber);
    }
}
