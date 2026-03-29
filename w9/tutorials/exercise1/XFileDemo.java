package w9.tutorials.exercise1;

import java.io.*;

public class XFileDemo {
    public static void main(String[] args) throws IOException {
        String src;
        String dst;

        if (args.length >= 2) {
            src = args[0];
            dst = args[1];
        } else {
            src = "/tmp/source_demo.bin";
            dst = "/tmp/dest_demo.bin";
            createDemoFile(src);
        }

        System.out.println("Reading  : " + src);
        byte[] data = XFile.read(src);
        System.out.println("Read     : " + data.length + " bytes");

        System.out.println("Writing  : " + dst);
        XFile.write(dst, data);
        System.out.println("Written  : " + new File(dst).length() + " bytes");

        byte[] written = XFile.read(dst);
        boolean identical = java.util.Arrays.equals(data, written);
        System.out.println("Identical: " + identical);

        if (args.length < 2) {
            new File(src).delete();
            new File(dst).delete();
            System.out.println("Demo files cleaned up.");
        }
    }

    private static void createDemoFile(String path) throws IOException {
        byte[] sample = new byte[256];
        for (int i = 0; i < sample.length; i++) {
            sample[i] = (byte) i;
        }
        XFile.write(path, sample);
        System.out.println("Created demo source file: " + path);
    }
}
