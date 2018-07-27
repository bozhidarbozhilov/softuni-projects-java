package barracksWars.core;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Runnable;
import barracksWars.core.commands.Command;
import barracksWars.contracts.Repository;
import barracksWars.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private static final String COMMAND_PATH = "barracksWars.core.commands.";
    private static final String COMMAND_SUFFIX_NAME = "Command";

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private String interpredCommand(String[] data, String commandName){
        String adaptCommandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        String commandClassFullName = COMMAND_PATH + adaptCommandName + COMMAND_SUFFIX_NAME;

        try {
            Class<?> commandClass = Class.forName(commandClassFullName);
            Constructor<?>[] constructors = commandClass.getDeclaredConstructors();
            Constructor<?> commandConstructor =
                    commandClass.getDeclaredConstructor(String[].class);
            commandConstructor.setAccessible(true);
            Command command = (Command) commandConstructor.newInstance(new Object[] {data});
            this.injectDependencies(command);
            return command.execute();
        } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|
                InstantiationException|InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }

    }


	private void injectDependencies(Command command){
        Field[] commandFields = command.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if(commandField.isAnnotationPresent(Inject.class)){
                if(commandField.getName().equals("repository") && commandField.getType().getSimpleName().equals("Repository")){
                    try {
                        commandField.set(command, this.repository);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }else if(commandField.getName().equals("unitFactory") &&
                        commandField.getType().getSimpleName().equals("UnitFactory")){
                    try {
                        commandField.set(command, this.unitFactory);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

}
