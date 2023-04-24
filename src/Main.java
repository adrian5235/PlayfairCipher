import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cipher cipher = new Cipher();

        System.out.print("Key word = ");
        String keyWord = sc.nextLine();
        cipher.sendKeyWord(keyWord);
        System.out.println();
        System.out.println("Matrix made of given key word");
        cipher.printArray();

        System.out.print("Text to encrypt = ");
        String text = sc.nextLine();
        String encrypted = cipher.encrypt(text);
        System.out.print("Encrypted = " + encrypted);

        System.out.println();
        System.out.print("Text to decrypt = ");
        text = sc.nextLine();
        String decrypted = cipher.decrypt(text);
        System.out.print("Decrypted = " + decrypted);
    }
}