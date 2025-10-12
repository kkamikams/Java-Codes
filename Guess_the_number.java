import java.util.Random;
import java.util.Scanner;

public class Guess_the_number {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int number = random.nextInt(50) + 1;
        int guess = 0;

        System.out.println("Guess the Number!!!\n");

        while (guess != number) {
            System.out.print("Enter your guess (1-50): ");
            guess = scanner.nextInt();

            if (guess < 1 || guess > 50) {
                System.out.println("Invalid input! Try again.\n");
                continue;
            }

            if (guess < number) {
                System.out.println("Too low! Try again.\n");
            } else if (guess > number) {
                System.out.println("Too high! Try again.\n");
            } else {
                System.out.println("Yayyy!!! You guessed the number!\n");
            }
        }

        scanner.close();

    }
}
