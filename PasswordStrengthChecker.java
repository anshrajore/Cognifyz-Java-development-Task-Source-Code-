//Level 2 Task 3 PasswordStrengthChecker
import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);

        System.out.println("Password Strength: " + strength);

        scanner.close();
    }

    private static String checkPasswordStrength(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean isLongEnough = password.length() >= 8;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (isLongEnough && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Strong";
        } else if (isLongEnough && ((hasUppercase && hasLowercase) || hasDigit) && hasSpecialChar) {
            return "Medium";
        } else {
            return "Weak";
        }
    }
}
