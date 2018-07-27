package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Executable;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data){
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }

}
