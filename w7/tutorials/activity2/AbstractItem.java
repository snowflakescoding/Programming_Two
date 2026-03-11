public abstract class AbstractItem implements Item {

    private final int id;
    private final String title;
    private final String author;
    private final ItemType type;

    protected AbstractItem(int id, String title, String author, ItemType type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Title: \"%s\" | Author: %s", type, id, title, author);
    }
}
