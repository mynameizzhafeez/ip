package command;

import dukeexception.commandexception.UnknownCommandException;
import gui.Gui;
import storage.Storage;
import task.TaskList;

/**
 * Command to be executed.
 */
public abstract class Command {
    /**
     * Creates a new Command object based on the command given.
     * @param commandWordContent The content of the user response.
     * @return Command object that can be executed.
     */
    public static Command create(String[] commandWordContent) {
        assert commandWordContent != null : "Command should not be null.";
        String commandWord = commandWordContent[0];
        String commandContent = commandWordContent[1];
        switch (commandWord) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "delete":
            return new DeleteCommand(commandContent);
        case "mark":
        case "unmark":
            return new MarkCommand(commandWord, commandContent);
        case "todo":
        case "deadline":
        case "event":
            return new AddCommand(commandWord.toUpperCase().charAt(0), commandContent);
        case "find":
            return new FindCommand(commandContent.strip().split(" "));
        default:
            throw new UnknownCommandException();
        }
    }

    /**
     * Executes the given command and outputs to the ui.
     * @param taskList List of tasks.
     * @param gui User Interface, which deals with inputs and outputs.
     * @param storage Storage module, which deals with caching the data of the task list.
     */
    public abstract void execute(TaskList taskList, Gui gui, Storage storage);

    /**
     * Returns whether the command is an exit command.
     * @return whether the command is an exit command.
     */
    public boolean isExit() {
        return false;
    }
}
