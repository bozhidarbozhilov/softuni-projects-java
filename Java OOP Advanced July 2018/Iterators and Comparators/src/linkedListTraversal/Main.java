package linkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomLinkedList<Integer> integers = new CustomLinkedList<>();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch(tokens[0]){
                case "Add":
                    integers.add(Integer.valueOf(tokens[1]));
                    break;
                case "Remove":
                    integers.remove(Integer.valueOf(tokens[1]));
                    break;
                default:
                    break;
            }
        }

        StringBuilder output = new StringBuilder();

        for (Integer integer : integers) {
            output.append(integer).append(" ");
        }
        System.out.println(integers.getSize());
        System.out.println(output.toString());
    }
}
