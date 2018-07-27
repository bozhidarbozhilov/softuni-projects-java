package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.contracts.Repository;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }


    public Repository getRepository() {
        return this.repository;
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
