import java.util.Scanner;

public class Simple_Registration {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isRegistered;
        boolean hasPassword;

        System.out.print("Are you registered? (true/false) ");
        isRegistered = scanner.nextBoolean();


        if (isRegistered) {
            System.out.print("Do you have a password? (true/false) ");
            hasPassword = scanner.nextBoolean();
            if (hasPassword) {
                System.out.println("Access Granted!");
            } else {
                System.out.println("Please set your password first.");
            }
        } else {
            System.out.println("Access Denied! Please register first.");

        }
        scanner.close();
    }
}
