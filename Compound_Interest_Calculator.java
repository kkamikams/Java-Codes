import java.util.Scanner;

public class Compound_Interest_Calculator {
    public static void main(String[] args) {

        // 4

        Scanner scanner = new Scanner(System.in);

        double principal;
        double interest;
        int compounded;
        int years;
        double amount;

        System.out.print("Enter principal amount: ");
        principal = scanner.nextDouble();
        System.out.print("Enter annual interest rate (in %): ");
        interest = scanner.nextDouble() / 100;
        System.out.print("Enter number of times interest is compounded per year: ");
        compounded = scanner.nextInt();
        System.out.print("Enter years: ");
        years = scanner.nextInt();

        amount = principal * Math.pow(1 + interest / compounded, compounded * years);

        System.out.printf("Total amount: %.2f", amount);
        scanner.close();
    }
}