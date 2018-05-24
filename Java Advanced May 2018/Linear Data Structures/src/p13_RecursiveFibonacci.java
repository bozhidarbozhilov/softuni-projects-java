import java.util.HashMap;
import java.util.Scanner;

public class p13_RecursiveFibonacci {
    public static long[] fibonacci;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        fibonacci = new long[num];

        if(num==1){
            fibonacci[0] = 1;
        }else{
            fibonacci[num-1] = getNthFibonacci(num);
        }
        System.out.println(fibonacci[num-1]);
    }

    private static long getNthFibonacci(int num) {
        long result = 0L;
        if(num == 0 || num == 1){
            return fibonacci[0] = 1;
        }else if(fibonacci[num-1] != 0){
            result = fibonacci[num-1];
        }else if(fibonacci[num-1] == 0){
            result = getNthFibonacci(num-1)+getNthFibonacci(num-2);
            fibonacci[num-1] = result;
        }
        return result;
    }
}
