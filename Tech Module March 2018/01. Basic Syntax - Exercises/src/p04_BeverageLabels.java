import java.text.DecimalFormat;
import java.util.Scanner;

public class p04_BeverageLabels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int volume = Integer.parseInt(scanner.nextLine());
        int energy = Integer.parseInt(scanner.nextLine());
        int sugar = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(volume + "ml " + name + ":");
        System.out.printf("%skcal, %sg sugars",
                df.format(energy*volume/100.0), df.format(sugar*volume/100.0));
    }
}
