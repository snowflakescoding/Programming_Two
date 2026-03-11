import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {

        public static void main(String[] args) {

                Library library = new Library();

                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║   Library Management System Demo     ║");
                System.out.println("╚══════════════════════════════════════╝\n");

                System.out.println("── Adding items to the catalogue ──────────────────────────");

                Book cleanCode = new Book(101, "Clean Code",
                                "Robert C. Martin", 431, "Prentice Hall", 2008);
                Book effectiveJava = new Book(102, "Effective Java",
                                "Joshua Bloch", 412, "Addison-Wesley", 2018);
                Book designPatterns = new Book(103, "Design Patterns",
                                "Gang of Four", 395, "Addison-Wesley", 1994);

                Journal ieeeJournal = new Journal(201, "IEEE Software",
                                "IEEE Editorial", 47, LocalDate.of(2024, 3, 1));
                Journal natureJournal = new Journal(202, "Nature: Computer Science",
                                "Springer Nature", 12, LocalDate.of(2024, 6, 15));

                DVD matrixDVD = new DVD(301, "The Matrix",
                                "Warner Bros.", 136, "The Wachowskis",
                                List.of("Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"));
                DVD inceptionDVD = new DVD(302, "Inception",
                                "Warner Bros.", 148, "Christopher Nolan",
                                List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page"));

                library.addItem(cleanCode);
                library.addItem(effectiveJava);
                library.addItem(designPatterns);
                library.addItem(ieeeJournal);
                library.addItem(natureJournal);
                library.addItem(matrixDVD);
                library.addItem(inceptionDVD);

                System.out.println("\n── Registering members ─────────────────────────────────────");

                Member alice = new Member(1001, "Alice Nguyen", "alice@email.com");
                Member bob = new Member(1002, "Bob Tran", "bob@email.com");
                Member carol = new Member(1003, "Carol Le", "carol@email.com");

                library.addMember(alice);
                library.addMember(bob);
                library.addMember(carol);

                System.out.println("\n── Borrow operations ───────────────────────────────────────");

                library.borrowItem(1001, 101);
                library.borrowItem(1001, 201);
                library.borrowItem(1001, 301);
                library.borrowItem(1002, 102);
                library.borrowItem(1002, 302);
                library.borrowItem(1003, 103);

                System.out.println("\n── Edge-case warnings ──────────────────────────────────────");

                library.borrowItem(1001, 101);
                library.returnItem(1002, 301);
                library.borrowItem(9999, 101);
                library.borrowItem(1001, 9999);
                library.addMember(new Member(1001, "Alice Clone", "clone@email.com"));

                System.out.println("\n── Return operations ───────────────────────────────────────");

                library.returnItem(1001, 101);
                library.returnItem(1002, 102);

                System.out.println("\n── Search demo ─────────────────────────────────────────────");

                Optional<Item> found = library.findItemById(302);
                found.ifPresentOrElse(
                                i -> System.out.println("  findById(302)   → " + i),
                                () -> System.out.println("  findById(302)   → not found"));

                Optional<Item> byTitle = library.findItemByTitle("java");
                byTitle.ifPresentOrElse(
                                i -> System.out.println("  findByTitle('java') → " + i),
                                () -> System.out.println("  findByTitle('java') → not found"));

                System.out.println("\n── Remove demo ─────────────────────────────────────────────");

                library.removeItem(natureJournal);
                library.removeMember(1003);
                library.removeItem(natureJournal);
                library.removeMember(9999);

                library.printAllItems();
                library.printAllMembers();
        }
}