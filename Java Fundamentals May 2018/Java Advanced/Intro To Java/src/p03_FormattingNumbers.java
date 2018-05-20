import java.util.Scanner;

public class p03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int intNum = scanner.nextInt();

        double firstDouble = scanner.nextDouble();
        double secondDouble = scanner.nextDouble();

        String firstString = String.format("%-10s",Integer.toHexString(intNum).toUpperCase());
        String secondString = String.format("%10s",Integer.toBinaryString(intNum)).replace(" ", "0");
        String thirdString = String.format("%10.2f", firstDouble);
        String fourthString = String.format("%-10.3f",secondDouble);
        System.out.print("|"+firstString+"|"+secondString+"|"+thirdString+"|"+fourthString+"|");
    }
}
