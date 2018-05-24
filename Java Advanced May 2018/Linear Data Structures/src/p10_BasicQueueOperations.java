import java.util.ArrayDeque;
import java.util.Scanner;

public class p10_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parameters = scanner.nextLine().split("\\s+");
        int elementsToPush = Integer.parseInt(parameters[0]);
        int elementsToPop = Integer.parseInt(parameters[1]);
        int checkElement = Integer.parseInt(parameters[2]);
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int push = 0; push < elementsToPush; push++) {
            numberStack.offer(scanner.nextInt());
        }
        for (int pop = 0; pop < elementsToPop; pop++) {
            numberStack.poll();
        }
        if(!numberStack.isEmpty()){
            if(numberStack.contains(checkElement)){
                System.out.println(true);
            }else{
                System.out.println(numberStack.stream().mapToInt(Integer::valueOf).min().getAsInt());
            }
        }else{
            System.out.println(0);
        }
    }
}
