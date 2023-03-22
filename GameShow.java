/*
 * Author: Grace Pu
 * Date: March 20
 * Description: This program simulates a text version of the popular game show, Are You Smarter Than A 5th Grader. 
 */

import java.util.*;

public class GameShow {

    // Variable declaration
    public static Scanner in = new Scanner(System.in);

    // // QUestion-Answer Pair class
    // class Pair<T> {
    // T q, a;

    // Pair() {

    // }

    // void make(T q, T a) {
    // this.q = q;
    // this.a = a;
    // }

    // Pair getP() {
    // return this;
    // }

    // T getQ() {
    // return this.q;
    // }

    // T getA() {
    // return this.a;
    // }
    // }

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

    // Method for header text
    public static void printHeader(String s) {
        System.out.println("-".repeat(50) + "\n" + s + "\n" + "-".repeat(50));
    }

    // Method for initiating
    // public static void init() {

    // }

    // Method for main menu
    public static void mainMenu() {
        // Variable declaration
        String input;
        boolean good = false;

        while (!good) {
            clearScreen();

            // Game Title
            printHeader("Are You Smarter Than A 5th Grader?");
            // System.out.println(" █████╗ ██████╗ ███████╗ ██╗ ██╗ █████╗ ██╗
            // ██╗\n██╔══██╗██╔══██╗██╔════╝ ╚██╗ ██╔╝██╔══██╗██║
            // ██║\n███████║██████╔╝█████╗ ╚████╔╝ ██║ ██║██║ ██║\n██╔══██║██╔══██╗██╔══╝
            // ╚██╔╝ ██║ ██║██║ ██║\n██║ ██║██║ ██║███████╗ ██║ ╚█████╔╝╚██████╔╝\n╚═╝
            // ╚═╝╚═╝ ╚═╝╚══════╝ ╚═╝ ╚════╝ ╚═════╝ \n\n ██████╗███╗ ███╗ █████╗ ██████╗
            // ████████╗███████╗██████╗ \n██╔════╝████╗
            // ████║██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔══██╗\n ╚█████╗
            // █╔████╔██║███████║██████╔╝ ██║ █████╗ ██████╔╝\n
            // ╚═══██╗██║╚██╔╝██║██╔══██║██╔══██╗ ██║ ██╔══╝ ██╔══██╗\n██████╔╝██║ ╚═╝
            // ██║██║ ██║██║ ██║ ██║ ███████╗██║ ██║\n╚═════╝ ╚═╝ ╚═╝╚═╝ ╚═╝╚═╝ ╚═╝ ╚═╝
            // ╚══════╝╚═╝ ╚═╝\n\n████████╗██╗ ██╗ █████╗ ███╗ ██╗ █████╗
            // ███████╗████████╗██╗ ██╗\n╚══██╔══╝██║ ██║██╔══██╗████╗ ██║ ██╔══██╗
            // ██╔════╝╚══██╔══╝██║ ██║\n ██║ ███████║███████║██╔██╗██║ ███████║ ██████╗ ██║
            // ███████║\n ██║ ██╔══██║██╔══██║██║╚████║ ██╔══██║ ╚════██╗ ██║ ██╔══██║\n ██║
            // ██║ ██║██║ ██║██║ ╚███║ ██║ ██║ ██████╔╝ ██║ ██║ ██║\n ╚═╝ ╚═╝ ╚═╝╚═╝ ╚═╝╚═╝
            // ╚══╝ ╚═╝ ╚═╝ ╚═════╝ ╚═╝ ╚═╝ ╚═╝\n\n ██████╗ ██████╗ █████╗ ██████╗
            // ███████╗██████╗ █████╗ \n██╔════╝
            // ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔══██╗\n██║ ██╗ ██████╔╝███████║██║
            // ██║█████╗ ██████╔╝╚═╝███╔╝\n██║ ╚██╗██╔══██╗██╔══██║██║ ██║██╔══╝ ██╔══██╗
            // ╚══╝ \n╚██████╔╝██║ ██║██║ ██║██████╔╝███████╗██║ ██║ ██╗ \n ╚═════╝ ╚═╝
            // ╚═╝╚═╝ ╚═╝╚═════╝ ╚══════╝╚═╝ ╚═╝ ╚═╝ ");
            // System.out.println(" ╚═════╝ ╚═╝ ╚═╝╚═╝ ╚═╝╚═════╝ ╚══════╝╚═╝ ╚═╝ ╚═╝");

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
        printHeader("Instructions");
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
        String[][][] questions = {
                { { "g1q", "g1a" }, { "g1q2", "g1a2" } }, // Grade 1
                { { "g2q", "g2a" }, { "g2q2", "g2a2" } }, // Grade 2
                { { "g3q", "g3a" }, { "g3q2", "g3a2" } }, // Grade 3
                { { "g4q", "g4a" }, { "g4q2", "g4a2" } }, // Grade 4
                { { "g5q", "g5a" }, { "g5q2", "g5a2" } }, // Grade 5
                { { "fq", "fa" }, { "fq2", "fa2" } } // Final question
        };
        int qNum = 1;
        int qRange = 2;
        boolean alive = true;
        boolean dropOut = false;
        boolean peek = true;
        boolean copy = true;
        boolean save = true;
        int money = 0;

        String response = "";
        String q;
        String a;
        String classmateAnswer = "think where to put later, in array or smt";

        while (alive && qNum <= 10) {
            int randQNum = (int) (qRange * Math.random());
            q = questions[qNum / 2][randQNum][0];
            a = questions[qNum / 2][randQNum][1];

            while (true) {
                clearScreen();
                printHeader("Game");
                printHeader("Question " + qNum);
                System.out.println(q);
                response = in.nextLine();

                if (response.equalsIgnoreCase("peek")) {
                    // peek
                    if (!peek) {
                        System.out.println("You peek at your classmate's answer: [tmp].");
                        peek = true;
                    }
                    else {
                        System.out.println("You already used your peek cheat!");
                    }
                } else if (response.equalsIgnoreCase("copy")) {
                    // copy
                    if (!copy) {
                        System.out.println("You copy your classmate's answer: [tmp2].");
                        response = classmateAnswer;
                    }
                    else {
                        System.out.println("You already used your copy cheat!");
                    }
                } else if (response.equalsIgnoreCase(a)) {
                    // correct answer
                    System.out.println("Correct!");
                } else {
                    // incorrect answer
                    if (save) {
                        System.out.println("Incorrect! [use classmate answer]");
                    }
                    else {
                        System.out.println();
                    }
                }
            }

        }

        if (!alive) {
            if (dropOut) {
                clearScreen();
                printHeader("Drop Out");
                System.out.println("You dropped out of school... winning $" + money + "!");
            } else {
                clearScreen();
                printHeader("Failure");
                System.out.println("You failed school... losing all hard-earned money.");
            }
        } else {
            printHeader("Winner");
            System.out.println("You passed! Time for the final question...");
            // final q
        }

        while (true) {
            System.out.println("\n");
            System.out.println("Look at the camera and answer: are you smarter than a 5th grader?");
            response = in.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                if (alive)
                    System.out.println("Congratulations!");
                else
                    System.out.println("Liar!");
                break;
            } else if (response.equalsIgnoreCase("no")) {
                if (!alive)
                    System.out.println("Loser");
                else
                    System.out.println("Nerd");
                break;
            } else {
                System.out.println("Invalid response. Try again: ");
            }
        }
        System.out.println("Press 0 to return to the main menu and -1 to exit the game.");
    }

    public static void main(String[] args) {
        // Variable declaration

        mainMenu();
    }
}
