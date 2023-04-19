public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();

        cipher.sendKeyWord("PLAYFAIR EXAMPLE");
        System.out.println();
        System.out.println("Array made of sent key word");
        cipher.printArray();

        System.out.println("Encrypting");
        String encrypted = cipher.encrypt("TEKST JAWNY");
        System.out.println(encrypted);

        System.out.println();
        System.out.println("Decrypting");
        String decrypted = cipher.decrypt("VI NK PB YV QL");
        System.out.println(decrypted);
    }
}