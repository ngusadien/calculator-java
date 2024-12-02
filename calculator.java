//utility for user input
import java.util.Scanner;

//main class
public class calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator!");
        boolean continueCalculator = true;

        while (continueCalculator) {
            showMenu();
            int choice = scanner.nextInt();

          // declaration of operatins objects
            Operations operations = new Operations();

            switch (choice) {
                case 1:
                    System.out.println("Enter numbers to add (separated by space, end with 0):");
                    double[] additionData = inputNumbers();
                    System.out.println("Result: " + operations.addition(additionData));
                    break;
                case 2:
                    System.out.println("Enter two numbers to subtract:");
                    double[] subtractData = inputTwoNumbers();
                    System.out.println("Result: " + operations.subtract(subtractData));
                    break;
                case 3:
                    System.out.println("Enter two numbers to multiply:");
                    double[] multiplyData = inputTwoNumbers();
                    System.out.println("Result: " + operations.multiply(multiplyData));
                    break;
                case 4:
                    System.out.println("Enter two numbers to divide:");
                    double[] divideData = inputTwoNumbers();
                    System.out.println("Result: " + operations.divide(divideData));
                    break;
                case 5:
                    System.out.println("Enter base and exponent:");
                    double[] powerData = inputTwoNumbers();
                    System.out.println("Result: " + operations.power(powerData));
                    break;
                case 6:
                    System.out.println("Enter a number to find the square root:");
                    double sqrtNumber = scanner.nextDouble();
                    System.out.println("Result: " + operations.sqrt(sqrtNumber));
                    break;
                default:
                    System.out.println("Invalid operation! Please try again.");
            }

            System.out.println("Do you want to perform another calculation? (yes/no)");
            continueCalculator = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for using the Calculator!");
    }

    static void showMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Power");
        System.out.println("6. Square Root");
        System.out.print("Enter your choice: ");
    }

    static double[] inputNumbers() {
        // Dynamic input handling
        System.out.println("Enter numbers (terminate with 0):");
        double[] numbers = new double[100];
        int count = 0;
        while (true) {
            double number = scanner.nextDouble();
            if (number == 0) break;
            numbers[count++] = number;
        }
        double[] result = new double[count];
        System.arraycopy(numbers, 0, result, 0, count);
        return result;
    }

    static double[] inputTwoNumbers() {
        double[] numbers = new double[2];
        numbers[0] = scanner.nextDouble();
        numbers[1] = scanner.nextDouble();
        return numbers;
    }
}

class Operations {
    public double addition(double[] numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    public double subtract(double[] numbers) {
        return numbers[0] - numbers[1];
    }

    public double multiply(double[] numbers) {
        return numbers[0] * numbers[1];
    }

    public double divide(double[] numbers) {
        if (numbers[1] == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return numbers[0] / numbers[1];
    }

    public double power(double[] numbers) {
        return Math.pow(numbers[0], numbers[1]);
    }

    public double sqrt(double number) {
        if (number < 0) {
            System.out.println("Error: Cannot calculate square root of a negative number.");
            return Double.NaN;
        }
        return Math.sqrt(number);
    }
}
