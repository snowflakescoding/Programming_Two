package activity5;

public class SubCrypto extends Crypto {

    private static final String ORIGINAL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SUBSTITUTION_KEY = "QWERTYUIOPASDFGHJKLZXCVBNM";

    @Override
    public void encrypt() {
        StringBuilder result = new StringBuilder();
        String text = getPlainText().toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = ORIGINAL_ALPHABET.indexOf(ch);

            if (index != -1) {
                result.append(SUBSTITUTION_KEY.charAt(index));
            } else {
                result.append(ch);
            }
        }
        setCipherText(result.toString());
    }

    @Override
    public void decrypt() {
        StringBuilder result = new StringBuilder();
        String text = getCipherText().toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = SUBSTITUTION_KEY.indexOf(ch);

            if (index != -1) {
                result.append(ORIGINAL_ALPHABET.charAt(index));
            } else {
                result.append(ch);
            }
        }
        setPlainText(result.toString());
    }
}
