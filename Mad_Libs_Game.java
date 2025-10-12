import java.util.Scanner;

public class Mad_Libs_Game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String adjective1;
        String pluralNoun1;
        String relative;
        String adjective2;
        String pluralNoun2;
        String noun1;
        String noun2;
        String pluralNoun3;
        String pluralNoun4;
        String adjective3;

        System.out.println("The Mad Libs Game \n");

        System.out.print("Enter adjective 1: ");
        adjective1 = scanner.nextLine();

        System.out.print("Enter plural noun 1: ");
        pluralNoun1 = scanner.nextLine();

        System.out.print("Enter relative: ");
        relative = scanner.nextLine();

        System.out.print("Enter adjective 2: ");
        adjective2 = scanner.nextLine();

        System.out.print("Enter plural noun 2: ");
        pluralNoun2 = scanner.nextLine();

        System.out.print("Enter noun 1: ");
        noun1 = scanner.nextLine();

        System.out.print("Enter noun 2: ");
        noun2 = scanner.nextLine();

        System.out.print("Enter plural noun 3: ");
        pluralNoun3 = scanner.nextLine();

        System.out.print("Enter plural noun 4: ");
        pluralNoun4 = scanner.nextLine();

        System.out.print("Enter adjective 3: ");
        adjective3 = scanner.nextLine();

        System.out.println("\nAt the " + adjective1 + " circus, the " + pluralNoun1 + " were in charge of the show.");
        System.out.println("The  " + relative + " of the ringmaster thought they were " + adjective2 + " and always wore colorful " + pluralNoun2 + " on their head.");
        System.out.println("The clowns were constantly tripping over their big " + noun1 + " making everyone laugh.");
        System.out.println("The acrobats performed daring flips and twists, landing in a pile of " + noun2 + ".");
        System.out.println("The audience couldn't stop giggling at the hilariously clumsy " + pluralNoun3 + " as they tried to juggle " + pluralNoun4 + " while riding unicycles.");
        System.out.println("In the end, the whole circus turned into a chaotic, yet " +adjective3 + " spectacle that left everyone smiling.");

        scanner.close();

    }
}
