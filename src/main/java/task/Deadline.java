package task;

import parser.DateParser;
import parser.Parser;

import java.time.LocalDateTime;

public class Deadline extends Task {
    private final LocalDateTime by;

    public Deadline(String content, String by) {
        super(content);
        this.by = DateParser.parse(by);
    }

    public static Deadline create(String content) {
        /**
         * @param content what to place in this seedu.task.
         * @returns the output Task.Deadline object.
         */
        String source = "Task.Deadline Creation";
        String[] contentAndBy = Parser.handleMissingField(content, "/by", "by", source);

        String parsedContent = contentAndBy[0].strip();
        String by = contentAndBy[1].strip();

        Parser.handleEmptyField(parsedContent, "content", source);
        Parser.handleEmptyField(by, "by", source);

        return new Deadline(parsedContent, by);
    }

    @Override
    public String toString() {
        return String.format(
                "[D]%s (by: %s)",
                super.toString(),
                DateParser.formatDateToPrint(this.by));
    }

    @Override
    public String toStorageString() {
        return String.format(
                "D|%d|%s /by %s",
                this.isMarked() ? 1 : 0,
                this.getContent(),
                DateParser.formatDateToStore(this.by));
    }
}