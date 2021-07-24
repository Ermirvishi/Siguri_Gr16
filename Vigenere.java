public class Vigenere {

    public Vigenere() {

    }

    ;

    public static String cipherText(String key, String str) {
        String cipher_text = "";
        for (int i = 0, j = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ' || !Character.isLetter(str.charAt(i))) {
                cipher_text += str.charAt(i);
                continue;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {

                int x = (Character.toUpperCase(str.charAt(i)) + Character.toUpperCase(key.charAt(j))) % 26;
                x += 'A';
                cipher_text += Character.toLowerCase((char) (x));
                j++;
            }// referenca --> https://www.geeksforgeeks.org/vigenere-cipher/
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                int x = (str.charAt(i) + Character.toUpperCase(key.charAt(j))) % 26;
                x += 'A';
                cipher_text += (char) (x);
                j++;
            }
        }
        return cipher_text;
    }

    public static String originalText(String key, String cipher_text) {
        String orig_text = "";

        for (int i = 0, j = 0; i < cipher_text.length(); i++) {
            if (cipher_text.charAt(i) == ' ' || !Character.isLetter(cipher_text.charAt(i))) {
                orig_text += cipher_text.charAt(i);
                continue;
            }// referenca --> https://www.geeksforgeeks.org/vigenere-cipher/
            else if (cipher_text.charAt(i) >= 'A' && cipher_text.charAt(i) <= 'Z') {
                int x = (cipher_text.charAt(i) - Character.toUpperCase(key.charAt(j)) + 26) % 26;
                x += 'A';
                orig_text += (char) (x);
                j++;
            } else if (cipher_text.charAt(i) >= 'a' && cipher_text.charAt(i) <= 'z') {
                int x = (Character.toUpperCase(cipher_text.charAt(i)) -
                        Character.toUpperCase(key.charAt(j)) + 26) % 26;
                x += 'A';
                orig_text += Character.toLowerCase((char) (x));
                j++;
            }

        }
        return orig_text;
    }


    // referenca --> https://www.geeksforgeeks.org/vigenere-cipher/
    public static String generateKey(String str, String key) {
        for (int i = 0; ; i++) {
            if (key.length() == str.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "encrypt": {
                String key = Vigenere.generateKey(args[2], args[1]);
                System.out.println(Vigenere.cipherText(key, args[2]));
            }
            ;
            break;
            case "decrypt": {
                String key = Vigenere.generateKey(args[2], args[1]);
                System.out.println(Vigenere.originalText(key, args[2]));
            }
            ;
            break;
            default:
                System.out.println("Argumenti i dyte duhet te bej pjese ne vargun {encrypt,decrypt}");
        }
    }

}
