//Level 1 Task 3 StudentGradeCalculator
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");

        System.out.print("Enter the number of grades to calculate: ");
        int numberOfGrades = scanner.nextInt();

        if (numberOfGrades <= 0) {
            System.out.println("The number of grades must be greater than 0.");
            return;
        }

        double[] grades = new double[numberOfGrades];
        double sum = 0;

        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();

            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                i--; // Redo current iteration for invalid input
                continue;
            }
            sum += grades[i];
        }

        double average = sum / numberOfGrades;

        System.out.printf("The average grade is: %.2f%n", average);

        scanner.close();
    }
}
