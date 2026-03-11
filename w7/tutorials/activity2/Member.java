import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member extends Person {

    private final List<Item> borrowedItems;

    public Member(int id, String name, String email) {
        super(id, name, email);
        this.borrowedItems = new ArrayList<>();
    }

    public List<Item> getBorrowedItems() {
        return Collections.unmodifiableList(borrowedItems);
    }

    public void borrowItem(Item item) {
        if (borrowedItems.contains(item)) {
            System.out.printf("  [WARNING] Member '%s' already has \"%s\" borrowed.%n",
                    getName(), item.getTitle());
            return;
        }
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        if (!borrowedItems.remove(item)) {
            System.out.printf("  [WARNING] Member '%s' did not borrow \"%s\".%n",
                    getName(), item.getTitle());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Member ID: %d | Name: %s | Email: %s%n",
                getId(), getName(), getEmail()));

        if (borrowedItems.isEmpty()) {
            sb.append("  Borrowed Items: (none)");
        } else {
            sb.append("  Borrowed Items:");
            for (Item item : borrowedItems) {
                sb.append(String.format("%n    • %s", item));
            }
        }
        return sb.toString();
    }
}
