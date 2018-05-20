package p06;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());
        double result = raiseToPower(num,power);

        DecimalFormat df = new DecimalFormat("##.###############");
        System.out.println(df.format(result));
    }
    public static double raiseToPower(double number,double power){
        return Math.pow(number,power);
    }
}
