package threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Threeuple<String, String, String> strThreeuple = new Threeuple<>();
        Threeuple<String, Integer, Boolean> boolThreeuple = new Threeuple<>();
        Threeuple<String, Double, String> doubleThreeuple = new Threeuple<>();


        String[] input1 = scanner.nextLine().split("\\s+");
        strThreeuple.setParameter1(input1[0] + " " +input1[1]);
        strThreeuple.setParameter2(input1[2]);
        strThreeuple.setParameter3(input1[3]);

        String[] input2 = scanner.nextLine().split("\\s+");
        boolThreeuple.setParameter1(input2[0]);
        boolThreeuple.setParameter2(Integer.parseInt(input2[1]));
        if(input2[2].equals("drunk")){
            boolThreeuple.setParameter3(true);
        }else{
            boolThreeuple.setParameter3(false);
        }

        String[] input3 = scanner.nextLine().split("\\s+");
        doubleThreeuple.setParameter1(input3[0]);
        doubleThreeuple.setParameter2(Double.parseDouble(input3[1]));
        doubleThreeuple.setParameter3(input3[2]);

        System.out.println(strThreeuple.toString());
        System.out.println(boolThreeuple.toString());
        System.out.println(doubleThreeuple.toString());
    }
}
