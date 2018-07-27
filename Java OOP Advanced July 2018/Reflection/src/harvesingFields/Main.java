package harvesingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class soilLandClass = RichSoilLand.class;
        Field[] soilLandFields = soilLandClass.getDeclaredFields();

        String command = scanner.nextLine();

        while(!"HARVEST".equals(command)){
            switch(command){
                case "private":
                    for (Field soilLandField : soilLandFields) {
                        if(Modifier.isPrivate(soilLandField.getModifiers())){
                            printField(soilLandField);
                        }
                    }
                    break;
                case "protected":
                    for (Field soilLandField : soilLandFields) {
                        if(Modifier.isProtected(soilLandField.getModifiers())){
                            printField(soilLandField);
                        }
                    }
                    break;
                case "public":
                    for (Field soilLandField : soilLandFields) {
                        if(Modifier.isPublic(soilLandField.getModifiers())){
                            printField(soilLandField);
                        }
                    }
                    break;
                case "all":
                    for (Field soilLandField : soilLandFields) {
                        printField(soilLandField);
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
    }

    private static void printField(Field field) {
        System.out.println(String.format("%s %s %s",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(), field.getName()));
    }
}
