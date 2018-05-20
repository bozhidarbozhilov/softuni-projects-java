import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p06_SumReversedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> inputList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> intList = new ArrayList<>();

        for (String string : inputList) {
            intList.add(reverseString(string));
        }
        System.out.println(intList.stream().mapToInt(i -> i).sum());
    }

    private static int reverseString(String string) {
        char[] charArr = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length-1; i >= 0 ; i--) {
            sb.append(charArr[i]);
        }
        return Integer.valueOf(sb.toString());
    }
}
