package p03;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n ; i++) {
            printLine(1,i);
            System.out.println();
        }
        printLine(1,n);
        System.out.println();
        for (int j=n-1;j>0;j--){
            printLine(1,j);
            System.out.println();
        }

    }
    public static void printLine(int start,int end){
        for (int i = start; i <= end ; i++) {
            System.out.print(i+" ");
        }
    }
}
