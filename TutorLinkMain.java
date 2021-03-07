import java.io.FileNotFoundException;
import java.util.Scanner;

public class TutorLinkMain {

    public static void main(String[] args) {
        TutorLink tl = new TutorLink();
        try {
            tl.processData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tl.getMatches();
        Scanner keyboard = new Scanner(System.in);
        askForChoices(keyboard);

    }

    public static void askForChoices(Scanner keyboard) {
        System.out.println("Hello! Would you like to get information on a tutor or tutee?");
        System.out.print("Enter (1) for tutor or (2) for tutee: ");
        while (!keyboard.hasNextInt()) {
            System.out.println("Sorry, that's not a valid choice.");
            System.out.println("Please enter (1) for tutor or (2) for tutee: ");
        }
        int choice = keyboard.nextInt();
        String type = (choice == 1) ? "tutor" : "tutee";
        ArrayList<Person> activeList = (choice == 1) ? TutorLink.tutors : TutorLink.tutees;
        System.out.println("Awesome! Would you like to get information on a specific " +
                type + "?");
        System.out.println("Enter (1) for a specific tutor or (2) to see all tutors: ");
        while (!keyboard.hasNextInt()) {
            System.out.println("Sorry, that's not a valid choice.");
            System.out.println("Enter (1) for a specific " + type + " or (2) to see all " + type + "s: ");
        }
        boolean wantSpecific = (keyboard.nextInt() == 1);
        if (wantSpecific) {
            System.out.println("Great! Enter a name of a " + type + ": ");
            String name = keyboard.nextLine();
        } else {
            System.out.println("Here is the current information we have for all " + type + "s: ");
        }
    }

    public static ArrayList<Person> findMatch(Scanner keyboard)
    {

        System.out.println("Are you looking as a tutor (0) or tutee (1)?");
        while (!keyboard.hasNextInt()) {
            System.out.println("Sorry, that's not a valid choice.");
            System.out.println("Please enter 0 for tutor or 1 for tutee: ");
        }
        int type = keyboard.nextInt();

    }
}
