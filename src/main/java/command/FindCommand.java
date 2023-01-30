package command;

import gui.Gui;
import storage.Storage;
import task.TaskList;

/**
 * Command for finding matches to user inputs.
 */
public class FindCommand extends Command {
    private final String searchTerm;

    /**
     * Constructor for FindCommand;
     * @param searchTerm The term to search.
     */
    public FindCommand(String searchTerm) {
        this.searchTerm = searchTerm.strip();
    }

    @Override
    public void execute(TaskList taskList, Gui gui, Storage storage) {
        gui.say(taskList.listItems((task) -> task.getContent().contains(this.searchTerm)));
    }
}
