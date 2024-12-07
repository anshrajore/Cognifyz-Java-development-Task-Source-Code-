//Task: Temperature Converter
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.println("Enter 'C' to convert from Celsius to Fahrenheit.");
        System.out.println("Enter 'F' to convert from Fahrenheit to Celsius.");

  
        System.out.print("Enter the unit of the input temperature (C/F): ");
        String unit = scanner.next().toUpperCase();

        if (!unit.equals("C") && !unit.equals("F")) {
            System.out.println("Invalid input. Please enter 'C' or 'F'.");
            return;
        }

      
        System.out.print("Enter the temperature value: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid temperature value. Please enter a number.");
            return;
        }
        double temperature = scanner.nextDouble();
        if (unit.equals("C")) {
            double convertedTemp = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f°C is equal to %.2f°F.%n", temperature, convertedTemp);
        } else if (unit.equals("F")) {
            double convertedTemp = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f°F is equal to %.2f°C.%n", temperature, convertedTemp);
        }

        scanner.close();
    }
}
