import java.util.Scanner;

public class p06_HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());

        for (int first = 1; first <= 20; first++) {
            for (int second = 1; second <=20 ; second++) {
                if(first + second == target){
                    System.out.println(first + " + " + second+ " = " + target);
                }else if(first-second == target){
                    System.out.println(first + " - " + second+ " = " + target);
                }
            }
        }
    }
}
