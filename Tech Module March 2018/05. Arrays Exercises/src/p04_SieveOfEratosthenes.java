import java.util.Scanner;

public class p04_SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        boolean[] primeIndex =  new boolean[num+1];
        for (int i = 0; i < primeIndex.length; i++) {
            primeIndex[i] = true;
        }
        primeIndex[0] = false;
        primeIndex[1] = false;
        for (int i = 2; i*i <= num; i++) {
            if(primeIndex[i]){
                for (int j = i; j*i <= num; j++) {
                    primeIndex[j*i] = false;
                }
            }
        }
        for (int i = 0; i < primeIndex.length; i++) {
            if(primeIndex[i]){
                System.out.print(i+" ");
            }
        }
    }
}
