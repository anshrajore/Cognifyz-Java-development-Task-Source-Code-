//Level 2 Task 2 FileEncryptionDecryption 
import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for encryption or decryption
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = scanner.next().charAt(0);
        scanner.nextLine();  // consume the leftover newline

        // Prompt for file name
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Prompt for shift key (for Caesar Cipher)
        System.out.print("Enter the shift key (positive integer): ");
        int shift = scanner.nextInt();

        // Perform encryption or decryption
        if (choice == 'E' || choice == 'e') {
            encryptFile(filePath, shift);
        } else if (choice == 'D' || choice == 'd') {
            decryptFile(filePath, shift);
        } else {
            System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }

    // Method to encrypt the file
    private static void encryptFile(String filePath, int shift) {
        try {
            File inputFile = new File(filePath);
            if (!inputFile.exists()) {
                System.out.println("The specified file does not exist.");
                return;
            }

            // Read the input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            // Encrypt the content
            String encryptedContent = encryptContent(content.toString(), shift);

            // Write the encrypted content to a new file
            FileWriter writer = new FileWriter("encrypted_" + inputFile.getName());
            writer.write(encryptedContent);
            writer.close();

            System.out.println("File encrypted successfully. Saved as: encrypted_" + inputFile.getName());

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to decrypt the file
    private static void decryptFile(String filePath, int shift) {
        try {
            File inputFile = new File(filePath);
            if (!inputFile.exists()) {
                System.out.println("The specified file does not exist.");
                return;
            }

            // Read the encrypted file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            // Decrypt the content
            String decryptedContent = decryptContent(content.toString(), shift);

            // Write the decrypted content to a new file
            FileWriter writer = new FileWriter("decrypted_" + inputFile.getName());
            writer.write(decryptedContent);
            writer.close();

            System.out.println("File decrypted successfully. Saved as: decrypted_" + inputFile.getName());

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to encrypt the content using Caesar Cipher
    private static String encryptContent(String content, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (c + shift);
                if (Character.isLowerCase(c) && shiftedChar > 'z' || Character.isUpperCase(c) && shiftedChar > 'Z') {
                    shiftedChar -= 26; // Wrap around the alphabet
                }
                encrypted.append(shiftedChar);
            } else {
                encrypted.append(c); // Keep non-alphabetic characters unchanged
            }
        }
        return encrypted.toString();
    }

    // Method to decrypt the content using Caesar Cipher
    private static String decryptContent(String content, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (c - shift);
                if (Character.isLowerCase(c) && shiftedChar < 'a' || Character.isUpperCase(c) && shiftedChar < 'A') {
                    shiftedChar += 26; // Wrap around the alphabet
                }
                decrypted.append(shiftedChar);
            } else {
                decrypted.append(c); // Keep non-alphabetic characters unchanged
            }
        }
        return decrypted.toString();
    }
}
