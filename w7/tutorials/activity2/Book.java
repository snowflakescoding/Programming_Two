public class Book extends AbstractItem {

    private final int pages;
    private final String publisher;
    private final int publicationYear;

    public Book(int id, String title, String author,
            int pages, String publisher, int publicationYear) {
        super(id, title, author, ItemType.BOOK);
        this.pages = pages;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | Pages: %d | Publisher: %s | Year: %d",
                        pages, publisher, publicationYear);
    }
}
