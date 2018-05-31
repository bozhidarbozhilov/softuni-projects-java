import java.util.Scanner;

public class p03_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banList = scanner.nextLine().split(", ");
        StringBuilder text = new StringBuilder(scanner.nextLine());

        for (String aBanList : banList) {
            int index = text.indexOf(aBanList);

            while (index != -1) {
                text.replace(index, index + aBanList.length(), repeatChars(aBanList.length()));
                index = text.indexOf(aBanList, index + 1);
            }
        }
        System.out.println(text);
    }

    private static String repeatChars(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
