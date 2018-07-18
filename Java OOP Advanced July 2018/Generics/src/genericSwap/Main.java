package genericSwap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Box<String>> stringBoxes = new ArrayList<>();
        List<Box<Integer>> intBoxes = new ArrayList<>();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            //String element = scanner.nextLine();
            Integer element = Integer.valueOf(scanner.nextLine());
            //Box<String> box = new Box<>(element);
            Box<Integer> intBox = new Box<>(element);
            intBoxes.add(intBox);
        }

        String[] indices = scanner.nextLine().split("\\s+");
        int firtsIndex = Integer.parseInt(indices[0]);
        int secondIndex = Integer.parseInt(indices[1]);

        Box.swap(intBoxes, firtsIndex, secondIndex);
        for (Box<Integer> box : intBoxes) {
            System.out.println(box.toString());
        }
    }
}
