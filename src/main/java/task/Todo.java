package task;

import parser.Parser;

public class Todo extends Task {

    public Todo(String content) {
        super(content);
    }

    public static Todo create(String content) {
        /**
         * @param content what to place in this seedu.task.
         * @returns the output Task.Todo object.
         */
        Parser.handleEmptyField(content, "content", "Task.Todo Creation");
        return new Todo(content);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toStorageString() {
        return String.format("T|%d|%s", this.isMarked() ? 1 : 0, this.getContent());
    }
}