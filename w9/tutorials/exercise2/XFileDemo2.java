import java.util.*;

public class XFileDemo2 {

    public static void main(String[] args) {

        final String file = "/tmp/students.dat";

        List<Student> list = new ArrayList<>();
        list.add(new Student("Tuấn",  5.0, "CNTT"));
        list.add(new Student("Cường", 7.5, "TKW"));
        list.add(new Student("Hạnh",  8.5, "CNTT"));

        XFile.writeObject(file, list);
        System.out.println("Written " + list.size() + " students to: " + file);

        @SuppressWarnings("unchecked")
        List<Student> loaded = (List<Student>) XFile.readObject(file);

        System.out.println("Read back " + loaded.size() + " students:");
        for (Student s : loaded) {
            System.out.println("  " + s);
        }

        boolean ok = list.size() == loaded.size();
        for (int i = 0; i < list.size() && ok; i++) {
            ok = list.get(i).toString().equals(loaded.get(i).toString());
        }
        System.out.println("Data integrity: " + (ok ? "PASS ✓" : "FAIL ✗"));
    }
}