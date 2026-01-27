package activity5;

public class Crypto {

    protected String plainText;
    protected String cipherText;

    private static final int CAESAR_SHIFT = 3;

    public Crypto() {
        this.plainText = "";
        this.cipherText = "";
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public void encrypt() {
        StringBuilder result = new StringBuilder();
        String text = this.plainText.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('A' + (ch - 'A' + CAESAR_SHIFT) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        this.cipherText = result.toString();
    }

    public void decrypt() {
        StringBuilder result = new StringBuilder();
        String text = this.cipherText.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('A' + (ch - 'A' - CAESAR_SHIFT + 26) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        this.plainText = result.toString();
    }
}
