import java.util.ArrayDeque;
import java.util.Scanner;

public class p07_ReverseNumbersWithStack {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(Integer.valueOf(number));
        }
        while(stack.size()>0){
            System.out.print(stack.pop()+" ");
        }
    }
}
