package petClinic;

import petClinic.controller.ClinicManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ClinicManager clinicManager = new ClinicManager();

        for (int i = 0; i < num; i++) {
            String[] commandTokens = scanner.nextLine().split("\\s+");

            switch (commandTokens[0]) {
                case "Create":
                    if("Pet".equals(commandTokens[1])){
                        clinicManager.createPet(commandTokens[2], Integer.parseInt(commandTokens[3]), commandTokens[4]);
                    }else{
                        clinicManager.createClinic(commandTokens[2], Integer.parseInt(commandTokens[3]));
                    }
                    break;
                case "Add":
                    System.out.println(clinicManager.addPet(commandTokens[1], commandTokens[2]));
                    break;
                case "Print":
                    if(commandTokens.length == 2){
                        clinicManager.printClinic(commandTokens[1]);
                    }else{
                        clinicManager.printRoom(commandTokens[1], Integer.parseInt(commandTokens[2]));
                    }
                    break;
                case "Release":
                    System.out.println(clinicManager.releaseClinic(commandTokens[1]));
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinicManager.hasEmptyRooms(commandTokens[1]));
                    break;
                default:
                    break;
            }
        }
    }
}
