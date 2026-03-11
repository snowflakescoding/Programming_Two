import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private final List<Item> items;
    private final List<Member> members;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null.");
        if (findItemById(item.getId()).isPresent()) {
            System.out.printf("  [WARNING] Item with ID %d already exists in the library.%n",
                    item.getId());
            return;
        }
        items.add(item);
        System.out.printf("  Added item     : %s%n", item);
    }

    public void removeItem(Item item) {
        if (!items.remove(item)) {
            System.out.printf("  [WARNING] Item \"%s\" not found in the library.%n",
                    item.getTitle());
        } else {
            System.out.printf("  Removed item   : \"%s\"%n", item.getTitle());
        }
    }

    public Optional<Item> findItemById(int id) {
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }

    public Optional<Item> findItemByTitle(String title) {
        return items.stream()
                .filter(i -> i.getTitle().toLowerCase()
                        .contains(title.toLowerCase()))
                .findFirst();
    }

    public void addMember(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member cannot be null.");
        if (findMemberById(member.getId()).isPresent()) {
            System.out.printf("  [WARNING] Member with ID %d already registered.%n",
                    member.getId());
            return;
        }
        members.add(member);
        System.out.printf("  Added member   : %s (ID: %d)%n",
                member.getName(), member.getId());
    }

    public void removeMember(int memberId) {
        Optional<Member> found = findMemberById(memberId);
        if (found.isEmpty()) {
            System.out.printf("  [WARNING] Member with ID %d not found.%n", memberId);
            return;
        }
        members.remove(found.get());
        System.out.printf("  Removed member : %s (ID: %d)%n",
                found.get().getName(), memberId);
    }

    public Optional<Member> findMemberById(int id) {
        return members.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }

    public void borrowItem(int memberId, int itemId) {
        Optional<Member> member = findMemberById(memberId);
        Optional<Item> item = findItemById(itemId);

        if (member.isEmpty()) {
            System.out.printf("  [ERROR] Cannot borrow: member ID %d not found.%n", memberId);
            return;
        }
        if (item.isEmpty()) {
            System.out.printf("  [ERROR] Cannot borrow: item ID %d not found.%n", itemId);
            return;
        }

        member.get().borrowItem(item.get());
        System.out.printf("  Borrowed       : \"%s\" → member '%s'%n",
                item.get().getTitle(), member.get().getName());
    }

    public void returnItem(int memberId, int itemId) {
        Optional<Member> member = findMemberById(memberId);
        Optional<Item> item = findItemById(itemId);

        if (member.isEmpty()) {
            System.out.printf("  [ERROR] Cannot return: member ID %d not found.%n", memberId);
            return;
        }
        if (item.isEmpty()) {
            System.out.printf("  [ERROR] Cannot return: item ID %d not found.%n", itemId);
            return;
        }

        member.get().returnItem(item.get());
        System.out.printf("  Returned       : \"%s\" ← member '%s'%n",
                item.get().getTitle(), member.get().getName());
    }

    public void printAllItems() {
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.printf("  LIBRARY CATALOGUE  (%d item%s)%n",
                items.size(), items.size() == 1 ? "" : "s");
        System.out.println("══════════════════════════════════════════════════════════");
        if (items.isEmpty()) {
            System.out.println("  (no items in catalogue)");
        } else {
            items.forEach(i -> System.out.println("  " + i));
        }
        System.out.println("══════════════════════════════════════════════════════════\n");
    }

    public void printAllMembers() {
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.printf("  REGISTERED MEMBERS  (%d member%s)%n",
                members.size(), members.size() == 1 ? "" : "s");
        System.out.println("══════════════════════════════════════════════════════════");
        if (members.isEmpty()) {
            System.out.println("  (no members registered)");
        } else {
            members.forEach(m -> {
                System.out.println(m);
                System.out.println("──────────────────────────────────────────────────────────");
            });
        }
        System.out.println("══════════════════════════════════════════════════════════\n");
    }
}
