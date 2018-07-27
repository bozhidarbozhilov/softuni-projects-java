package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Repository;
import barracksWars.contracts.UnitFactory;

public class RetireCommand extends Command {
    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);

    }

    public Repository getRepository() {
        return this.repository;
    }

    @Override
    public String execute() {
       try{
           String unitType = this.getData()[1];
           this.getRepository().removeUnit(unitType);
           return unitType + " retired!";
       }catch (IllegalArgumentException iae){
           return iae.getMessage();
       }
    }
}
