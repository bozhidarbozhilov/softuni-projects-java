import java.util.Scanner;

public class p03_MilesToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double miles = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.2f", miles * 1.60934);
    }
}
