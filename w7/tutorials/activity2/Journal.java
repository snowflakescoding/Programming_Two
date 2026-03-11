import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Journal extends AbstractItem {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final int issueNumber;
    private final LocalDate publicationDate;

    public Journal(int id, String title, String author,
            int issueNumber, LocalDate publicationDate) {
        super(id, title, author, ItemType.JOURNAL);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | Issue: #%d | Published: %s",
                        issueNumber, publicationDate.format(FMT));
    }
}