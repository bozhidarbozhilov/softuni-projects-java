import java.util.Scanner;

public class p01_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        String substring = scanner.nextLine().toLowerCase();

        int index = text.indexOf(substring);
        int counter = 0;

        while(index != -1){
            counter++;
            index = text.indexOf(substring, index+1);

        }
        System.out.println(counter);

    }
}
