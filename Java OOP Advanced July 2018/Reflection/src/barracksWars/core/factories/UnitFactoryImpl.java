package barracksWars.core.factories;

import barracksWars.contracts.Unit;
import barracksWars.contracts.UnitFactory;
import jdk.jshell.spi.ExecutionControl;
import barracksWars.contracts.Unit;
import barracksWars.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unitInstance = null;
		try {
			Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> unitConstuctor = unitClass.getDeclaredConstructor();
			unitInstance =(Unit) unitConstuctor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException |
				IllegalAccessException | InstantiationException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return unitInstance;
	}
}
