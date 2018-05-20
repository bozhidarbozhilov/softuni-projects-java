import java.util.Scanner;

public class p04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c  = scanner.nextDouble();

        double firstMain = ((Math.pow(a,2)+Math.pow(b,2))/(Math.pow(a,2)-Math.pow(b,2)));
        double firstPower = (a+b+c)/Math.sqrt(c);
        double firstExpression = Math.pow(firstMain,firstPower);

        double secondMain = Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,3);
        double secondPower = a-b;
        double secondExpression = Math.pow(secondMain, secondPower);

        double numbersAverage = (a+b+c)/3;
        double expressionsAverage = (firstExpression+secondExpression)/2;
        double absDifference = Math.abs(numbersAverage-expressionsAverage);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",
                firstExpression,secondExpression,absDifference);
    }
}
