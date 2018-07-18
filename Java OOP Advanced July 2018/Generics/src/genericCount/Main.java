package genericCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CompBox<String>> stringBoxes = new ArrayList<>();
        //List<CompBox<Double>> doubleBoxes = new ArrayList<>();

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String element = scanner.nextLine();
            //Double element = Double.valueOf(scanner.nextLine());
            CompBox<String> box = new CompBox<>();
            //CompBox<Double> box = new CompBox<>();
            box.setElement(element);
            stringBoxes.add(box);
            //doubleBoxes.add(box);
        }

        String elementToCompare = scanner.nextLine();
        CompBox<String> boxToCompare = new CompBox<>();
        boxToCompare.setElement(elementToCompare);
        System.out.println(countGreaterElements(stringBoxes, boxToCompare));

/*        Double elementToCompare = Double.valueOf(scanner.nextLine());
        CompBox<Double> boxToCompare = new CompBox<>();
        boxToCompare.setElement(elementToCompare);

        System.out.println(countGreaterElements(doubleBoxes, boxToCompare))*/;
    }

    public static <T extends Comparable<T>> int countGreaterElements(List<CompBox<T>> list, CompBox<T> elementToCompare){
        int count = 0;
        for (CompBox<T> compBox : list) {
            if(compBox.compareTo(elementToCompare)>0){
                count++;
            }
        }
        return count;
    }
}
