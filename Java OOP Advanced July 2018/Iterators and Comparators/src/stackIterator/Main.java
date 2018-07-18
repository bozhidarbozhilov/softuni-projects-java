package stackIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStackArray<Integer> myStack = new CustomStackArray<>();

        String input = scanner.nextLine();

        while(true){
            String[] tokens = input.split("[\\s,]+");
            if ("Push".equals(tokens[0])) {
                for (int  i = 1; i < tokens.length; i++) {
                    Integer element = Integer.valueOf(tokens[i]);
                    myStack.push(element);
                }

            } else if ("Pop".equals(tokens[0])) {
                try {
                    myStack.pop();
                } catch (NoSuchElementException nse) {
                    System.out.println(nse.getMessage());
                }

            } else if ("END".equals(tokens[0])) {
                break;
            }
            input = scanner.nextLine();
        }
        printElements(myStack);
        printElements(myStack);

    }

    private static void printElements(CustomStackArray<Integer> myStack) {
        for (Integer integer : myStack) {
            System.out.println(integer);
        }
    }
}
