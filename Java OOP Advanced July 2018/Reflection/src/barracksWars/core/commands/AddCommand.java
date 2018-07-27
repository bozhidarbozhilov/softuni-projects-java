package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Repository;
import barracksWars.contracts.Unit;
import barracksWars.contracts.UnitFactory;

public class AddCommand extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    public Repository getRepository() {
        return this.repository;
    }

    public UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unit = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unit);
        return unitType + " added!";
    }
}
