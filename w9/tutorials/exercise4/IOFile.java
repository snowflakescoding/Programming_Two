package w9.tutorials.exercise4;

import java.io.*;
import java.nio.file.*;

public class IOFile {

    private final String filename;

    public IOFile(String filename) {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename must not be null or blank.");
        }
        this.filename = filename;
    }

    public int countLines() throws IOException {
        try (BufferedReader reader = openReader()) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }

    public void write(OutputStream os) throws IOException {
        if (os == null) {
            throw new IllegalArgumentException("OutputStream must not be null.");
        }
        byte[] buffer = new byte[8192];
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        }
    }

    public void print() throws IOException {
        write(System.out);
    }

    public void copy(String destFilename) throws IOException {
        if (destFilename == null || destFilename.isBlank()) {
            throw new IllegalArgumentException("Destination filename must not be null or blank.");
        }
        Files.copy(
                Path.of(filename),
                Path.of(destFilename),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    public void delete() throws IOException {
        Files.delete(Path.of(filename));
    }

    @Override
    public String toString() {
        return "IOFile{filename='" + filename + "'}";
    }

    private BufferedReader openReader() throws IOException {
        return new BufferedReader(new FileReader(filename));
    }

    public static void main(String[] args) throws IOException {
        final String testFile = "/tmp/test_iofile.txt";
        final String copyFile = "/tmp/test_iofile_copy.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(testFile))) {
            pw.println("Line 1: Hello, world!");
            pw.println("Line 2: Java I/O is straightforward.");
            pw.println("Line 3: Goodbye!");
        }

        IOFile ioFile = new IOFile(testFile);

        System.out.println("Line count: " + ioFile.countLines());

        System.out.println("\n--- print() output ---");
        ioFile.print();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ioFile.write(baos);
        System.out.println("--- write() captured " + baos.size() + " bytes ---");

        ioFile.copy(copyFile);
        IOFile copied = new IOFile(copyFile);
        System.out.println("Copy line count: " + copied.countLines());

        ioFile.delete();
        System.out.println("Original deleted: " + !new File(testFile).exists());
        copied.delete();
        System.out.println("Copy deleted:     " + !new File(copyFile).exists());
    }
}