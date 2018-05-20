package p05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double area = getTriangleArea(width,height);

        DecimalFormat df = new DecimalFormat("#.###############");
        System.out.println(df.format(area));


    }
    public static double getTriangleArea(double width,double height ){

        return width*height/2;
    }
}
