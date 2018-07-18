package tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tuple<String, String> strTuple = new Tuple<>();
        Tuple<String, Integer> intTuple = new Tuple<>();
        Tuple<Integer, Double> numTuple = new Tuple<>();

        String[] input1 = scanner.nextLine().split("\\s+");
        strTuple.setParameter1(input1[0] + " " +input1[1]);
        strTuple.setParameter2(input1[2]);

        String[] input2 = scanner.nextLine().split("\\s+");
        intTuple.setParameter1(input2[0]);
        intTuple.setParameter2(Integer.parseInt(input2[1]));

        String[] input3 = scanner.nextLine().split("\\s+");
        numTuple.setParameter1(Integer.parseInt(input3[0]));
        numTuple.setParameter2(Double.parseDouble(input3[1]));

        System.out.println(strTuple.toString());
        System.out.println(intTuple.toString());
        System.out.println(numTuple.toString());
    }
}
