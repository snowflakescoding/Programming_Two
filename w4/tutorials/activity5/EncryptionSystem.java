package activity5;

public class EncryptionSystem {

    public static void main(String[] args) {
        System.out.println("### Testing Crypto (Caesar Cipher) ###");
        Crypto caesar = new Crypto();

        caesar.setPlainText("HELLO WORLD");
        caesar.encrypt();
        System.out.println("Plain Text: " + caesar.getPlainText());
        System.out.println("Encrypted:  " + caesar.getCipherText());

        caesar.decrypt();
        System.out.println("Decrypted:  " + caesar.getPlainText());
        System.out.println();

        System.out.println("### Testing SubCrypto (Substitution Cipher) ###");
        SubCrypto sub = new SubCrypto();

        sub.setPlainText("HELLO WORLD");
        sub.encrypt();
        System.out.println("Plain Text: " + sub.getPlainText());
        System.out.println("Encrypted:  " + sub.getCipherText());

        sub.decrypt();
        System.out.println("Decrypted:  " + sub.getPlainText());
    }
}
