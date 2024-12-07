//Level 1 Task 4 RandomPasswordGenerator
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Random Password Generator!");

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        System.out.println("Should the password include the following? (y/n)");
        System.out.print("Numbers (0-9): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Lowercase letters (a-z): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Uppercase letters (A-Z): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Special characters (!@#$%^&*): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*";
        StringBuilder charPool = new StringBuilder();

        if (includeNumbers) charPool.append(numbers);
        if (includeLowercase) charPool.append(lowercase);
        if (includeUppercase) charPool.append(uppercase);
        if (includeSpecialChars) charPool.append(specialChars);

        if (charPool.length() == 0) {
            System.out.println("You must select at least one character type!");
            return;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        System.out.println("Generated password: " + password);

        scanner.close();
    }
}
