import java.util.Scanner;

public class p05_CharacterStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int currentHealth = Integer.parseInt(scanner.nextLine());
        int maxHealth = Integer.parseInt(scanner.nextLine());
        int currentEnergy = Integer.parseInt(scanner.nextLine());
        int maxEnergy = Integer.parseInt(scanner.nextLine());

        System.out.printf("Name: %s%n", name);
        System.out.printf("Health: |%s%s|%n",
                repeatString("|", currentHealth), repeatString(".",maxHealth - currentHealth));
        System.out.printf("Energy: |%s%s|%n",
                repeatString("|", currentEnergy), repeatString(".",maxEnergy - currentEnergy));

    }
    public static String repeatString(String str, int times){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
