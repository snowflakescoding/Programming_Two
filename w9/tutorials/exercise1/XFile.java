package w9.tutorials.exercise1;

import java.io.*;

public class XFile {
    public static byte[] read(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] data = new byte[fis.available()];
            int totalRead = 0;
            int bytesRead;
            while (totalRead < data.length && (bytesRead = fis.read(data, totalRead, data.length - totalRead)) != -1) {
                totalRead += bytesRead;
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String path, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}       

