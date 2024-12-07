//Level 1 Task 2 PalindromeChecker
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker!");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(cleanedInput)) {
            System.out.println("The input is a palindrome!");
        } else {
            System.out.println("The input is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
