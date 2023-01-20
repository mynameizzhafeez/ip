public class ExitCommand extends Command {
    public ExitCommand() {

    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.sayBye();
        try {
            storage.save(taskList);
        } catch (SaveFileException e) {
            ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
