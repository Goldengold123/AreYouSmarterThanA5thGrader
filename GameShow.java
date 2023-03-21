/*
 * Author: Grace Pu
 * Date: March 20
 * Description: This program simulates a text version of the popular game show, Are You Smarter Than A 5th Grader. 
 */

import java.io.IOException;
import java.util.*;

public class GameShow {

    // Variable declaration
    public static Scanner in = new Scanner(System.in);

    // Method for clearing the screen.
    public static void clearScreen() {
        // OS is windows
        // Runtime.getRuntime().exec("cls");

        // 1 second delay for user to read (potential) message sent earlier
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clear screen
        System.out.println("\n".repeat(50));

        // try {
        // Runtime.getRuntime().exec("cls");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

    }

    // Method for quitting: display message then quit.
    public static void quitProgram() {
        System.out.println("-".repeat(50));
        System.out.println("Exiting...");

        // 1 second delay for user to read message
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    // Method for initiating
    public static void init() {

    }

    // Method for main menu
    public static void mainMenu() {
        // Variable declaration
        String input;
        boolean good = false;

        while (!good) {
            clearScreen();
            
            // Game Title
            //System.out.println("-".repeat(50) + "\nAre You Smarter Than A 5th Grader?\n" + "-".repeat(50));
            //System.out.println(" █████╗ ██████╗ ███████╗  ██╗   ██╗ █████╗ ██╗   ██╗\n██╔══██╗██╔══██╗██╔════╝  ╚██╗ ██╔╝██╔══██╗██║   ██║\n███████║██████╔╝█████╗     ╚████╔╝ ██║  ██║██║   ██║\n██╔══██║██╔══██╗██╔══╝      ╚██╔╝  ██║  ██║██║   ██║\n██║  ██║██║  ██║███████╗     ██║   ╚█████╔╝╚██████╔╝\n╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝     ╚═╝    ╚════╝  ╚═════╝ \n\n ██████╗███╗   ███╗ █████╗ ██████╗ ████████╗███████╗██████╗ \n██╔════╝████╗ ████║██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔══██╗\n ╚█████╗ █╔████╔██║███████║██████╔╝   ██║   █████╗  ██████╔╝\n ╚═══██╗██║╚██╔╝██║██╔══██║██╔══██╗   ██║   ██╔══╝  ██╔══██╗\n██████╔╝██║ ╚═╝ ██║██║  ██║██║  ██║   ██║   ███████╗██║  ██║\n╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝\n\n████████╗██╗  ██╗ █████╗ ███╗  ██╗   █████╗   ███████╗████████╗██╗  ██╗\n╚══██╔══╝██║  ██║██╔══██╗████╗ ██║  ██╔══██╗  ██╔════╝╚══██╔══╝██║  ██║\n   ██║   ███████║███████║██╔██╗██║  ███████║  ██████╗    ██║   ███████║\n   ██║   ██╔══██║██╔══██║██║╚████║  ██╔══██║  ╚════██╗   ██║   ██╔══██║\n   ██║   ██║  ██║██║  ██║██║ ╚███║  ██║  ██║  ██████╔╝   ██║   ██║  ██║\n   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝  ╚═╝  ╚═╝  ╚═════╝    ╚═╝   ╚═╝  ╚═╝\n\n ██████╗ ██████╗  █████╗ ██████╗ ███████╗██████╗  █████╗ \n██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔══██╗\n██║  ██╗ ██████╔╝███████║██║  ██║█████╗  ██████╔╝╚═╝███╔╝\n██║  ╚██╗██╔══██╗██╔══██║██║  ██║██╔══╝  ██╔══██╗   ╚══╝ \n╚██████╔╝██║  ██║██║  ██║██████╔╝███████╗██║  ██║   ██╗  \n ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝  ");
            System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝");

            // Options - Instructions, PLay, Exit
            System.out.println("Enter the number indicated before the desired option:");
            System.out.printf("%4d: %s\n", 1, "Instructions");
            System.out.printf("%4d: %s\n", 2, "Play");
            System.out.printf("%4d: %s\n", 0, "Return to the main menu at any point in the game.");
            System.out.printf("%4d: %s\n", -1, "Quit at any point in the game.");
            System.out.println();

            // Collect input from the user and run the method based on their response.
            input = in.nextLine();

            if (input.equals("1")) {
                instructions();
                good = true;
            } else if (input.equals("2")) {
                game();
                good = true;
            } else if (input.equals("0"))
                System.out.println("\nYou are already at the main menu!");
            else if (input.equals("-1"))
                quitProgram();
            else
                System.out.println("\nInvalid option...");
            System.out.println();
        }
    }

    // Method for displaying instructions
    public static void instructions() {
        // Variable declaration
        String input;
        boolean good = false;

        // Display instructions
        clearScreen();
        System.out.println("\n" + "-".repeat(50) + "\nInstructions\n" + "-".repeat(50));
        System.out.println("hmhmhm");
        System.out.println();

        while (!good) {
            // Return to menu message
            System.out.println("To return to the main menu, enter 0.");

            // Collect input from the user.
            input = in.nextLine();

            if (input.equals("0")) {
                mainMenu();
                good = true;
            } else if (input.equals("-1"))
                quitProgram();
            else
                System.out.println("\nInvalid option...");
            System.out.println();
        }
    }

    public static void game() {
        // Variable declaration

        String[][] questions = { {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {} };

        int qNum = 1;

        System.out.println("-".repeat(50) + "\nGame\n" + "-".repeat(50));

    }

    public static void main(String[] args) {
        // Variable declaration

        mainMenu();
    }
}
