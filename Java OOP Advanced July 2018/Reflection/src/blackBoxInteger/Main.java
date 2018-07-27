package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class blackBoxClass = BlackBoxInt.class;
        Field field = blackBoxClass.getDeclaredField("innerValue");
        field.setAccessible(true);
        Constructor blackBoxConstructor = blackBoxClass.getDeclaredConstructor();
        blackBoxConstructor.setAccessible(true);
        BlackBoxInt blackBoxIntInstance = (BlackBoxInt) blackBoxConstructor.newInstance();

        String command = scanner.nextLine();

        while(!"END".equals(command)){
            int index = command.indexOf("_");
            String method = command.substring(0,index);
            int value = Integer.parseInt(command.substring(index+1));
            Method currentMethod = blackBoxClass.getDeclaredMethod(method, int.class);
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxIntInstance, value);
            System.out.println(field.getInt(blackBoxIntInstance));
            command = scanner.nextLine();
        }
    }
}
