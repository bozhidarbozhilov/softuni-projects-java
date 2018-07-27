package inferno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WeaponManager weaponMenager = new WeaponManager();

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String[] tokens = line.split(";");
            switch (tokens[0]) {
                case "Create":
                    weaponMenager.createWeapon(tokens[2], tokens[1]);
                    break;
                case "Add":
                    weaponMenager.addGemToWeapon(tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
                    break;
                case "Print":
                    weaponMenager.printWeapon(tokens[1]);
                    System.out.println();
                    break;
                case "Remove":
                    weaponMenager.removeWeapon(tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case "Compare":
                    Weapon bigger = weaponMenager.getBiggerWeapon(tokens[1], tokens[2]);
                    double itemLevel = bigger.calcItemLevel();
                    weaponMenager.printWeapon(bigger.getName());
                    System.out.printf(" (Item Level: %.1f)%n",itemLevel);
                    break;
                case "Author":
                    System.out.printf("Author: %s%n", weaponMenager.getAnnotationAuthor());
                    break;
                case "Revision":
                    System.out.printf("Revision: %d%n", weaponMenager.getAnnotationRevision());
                    break;
                case "Description":
                    System.out.printf("Class description: %s%n", weaponMenager.getAnnotationDescription());
                    break;
                case "Reviewers":
                    System.out.printf("Reviewers: %s%n", weaponMenager.getAnnotationReviewers());
                    break;
                default:
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
