package genericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String element = scanner.nextLine();
            Box<String> box = new Box<>(element);
            System.out.println(box.toString());

        }
    }
}
