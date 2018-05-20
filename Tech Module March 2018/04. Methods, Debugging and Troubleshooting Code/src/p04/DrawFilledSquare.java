package p04;

import java.util.Scanner;

public class DrawFilledSquare {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(printStr("-",2*n));
        for (int i = 0; i < n-2; i++) {
            System.out.println("-"+printStr("\\/",n-1)+"-");
        }
        System.out.println(printStr("-",2*n));

    }
    public static String printStr(String str, int cnt){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
