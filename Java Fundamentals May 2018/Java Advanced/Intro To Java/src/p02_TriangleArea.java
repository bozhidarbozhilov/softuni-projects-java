import java.util.Scanner;

public class p02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstX = scanner.nextDouble();
        double firstY = scanner.nextDouble();
        scanner.nextLine();
        double secondX = scanner.nextDouble();
        double secondY = scanner.nextDouble();
        scanner.nextLine();
        double thirdX = scanner.nextDouble();
        double thirdY = scanner.nextDouble();
        scanner.nextLine();

        double firstPart = firstX*(secondY - thirdY);
        double secondPart = secondX*(thirdY - firstY);
        double thirdPart = thirdX*(firstY- secondY);

        int area = (int) (Math.abs((firstPart+secondPart+thirdPart)/2));

        System.out.printf("%d",area);
    }
}
