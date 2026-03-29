import java.io.*;

public class XFile {
    public static byte[] read(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] data = new byte[fis.available()];
            int totalRead = 0, bytesRead;
            while (totalRead < data.length &&
                   (bytesRead = fis.read(data, totalRead, data.length - totalRead)) != -1) {
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

    public static Object readObject(String path) {
        try (ObjectInputStream ois =
                new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeObject(String path, Object object) {
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            oos.writeObject(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}