/*
 * Author: Grace Pu
 * Date: March 20
 * Description: This program simulates a text version of the popular game show, Are You Smarter Than A 5th Grader. 
 * Bonus Features: Colour, Timer?, Lifeline, To-DO: maybe write to file later
 */

// import java.io.PrintWriter;
import java.util.*;

public class GameShow {

    // Variable declaration
    // public static PrintWriter out = new PrintWriter(System.out,true)
    public static Scanner in = new Scanner(System.in);
    public static boolean instructionsScreen = false;
    public static boolean gameScreen = false;
    public static String response;

    // Method for waiting ms milliseconds.
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method for clearing the screen.
    public static void clearScreen() {
        wait(1000);
        // Clear screen
        System.out.println("\n".repeat(100));
    }

    // Method for quitting: display message then quit.
    public static void quitProgram() {
        printHeader("Exiting...");
        wait(1000);
        System.exit(0);
    }

    // Method for reading input line that also checks if 0 is enter (return to main
    // menu).
    public static String readInput() throws Exception {
        String input = in.nextLine();
        if (input.equalsIgnoreCase("0")) {
            instructionsScreen = false;
            gameScreen = false;
            throw new Exception("main menu");
        } else
            return input;

    }

    // Method for header text
    public static void printHeader(String s) {
        System.out.println("-".repeat(100) + "\n" + s + "\n" + "-".repeat(100));
    }

    // Method for main menu
    public static void mainMenu() {
        clearScreen();

        // Game Title
        // printHeader("Are You Smarter Than A 5th Grader?");
        printHeader(
                "\u001b[34m \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2557   \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2557   \u2588\u2588\u2557\n\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D  \u255A\u2588\u2588\u2557 \u2588\u2588\u2554\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551   \u2588\u2588\u2551\n\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2557     \u255A\u2588\u2588\u2588\u2588\u2554\u255D \u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\n\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u255D      \u255A\u2588\u2588\u2554\u255D  \u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\n\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557     \u2588\u2588\u2551   \u255A\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\n\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D     \u255A\u2550\u255D    \u255A\u2550\u2550\u2550\u2550\u255D  \u255A\u2550\u2550\u2550\u2550\u2550\u255D \n\n \u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2557   \u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2557 \n\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\n \u255A\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2554\u2588\u2588\u2588\u2588\u2554\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D   \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\n \u255A\u2550\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551\u255A\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557   \u2588\u2588\u2551   \u2588\u2588\u2554\u2550\u2550\u255D  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\n\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551 \u255A\u2550\u255D \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551   \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2551\n\u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D     \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D   \u255A\u2550\u255D   \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\n\n\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2557  \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2557  \u2588\u2588\u2557   \u2588\u2588\u2588\u2588\u2588\u2557   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2557  \u2588\u2588\u2557\n\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2551  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557  \u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\n   \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551  \u2588\u2588\u2588\u2588\u2588\u2588\u2557    \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\n   \u2588\u2588\u2551   \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2551\u255A\u2588\u2588\u2588\u2588\u2551  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551  \u255A\u2550\u2550\u2550\u2550\u2588\u2588\u2557   \u2588\u2588\u2551   \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\n   \u2588\u2588\u2551   \u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551 \u255A\u2588\u2588\u2588\u2551  \u2588\u2588\u2551  \u2588\u2588\u2551  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D   \u2588\u2588\u2551   \u2588\u2588\u2551  \u2588\u2588\u2551\n   \u255A\u2550\u255D   \u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u2550\u255D  \u255A\u2550\u255D  \u255A\u2550\u255D  \u255A\u2550\u2550\u2550\u2550\u2550\u255D    \u255A\u2550\u255D   \u255A\u2550\u255D  \u255A\u2550\u255D\n\n \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2557 \n\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\n\u2588\u2588\u2551  \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u255A\u2550\u255D\u2588\u2588\u2588\u2554\u255D\n\u2588\u2588\u2551  \u255A\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u255D  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557   \u255A\u2550\u2550\u255D \n\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2551   \u2588\u2588\u2557  \n \u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D   \u255A\u2550\u255D  \u001b[37m");

        // Options - Instructions, PLay, Exit
        System.out.println("Enter the number indicated before the desired option:");
        System.out.printf("%4d: %s\n", 1, "Instructions");
        System.out.printf("%4d: %s\n", 2, "Play");
        System.out.printf("%4d: %s\n", 0, "Return to the main menu at any point in the game.");
        System.out.printf("%4d: %s\n", -1, "Quit");
        System.out.println();

        // Collect input from the user and run the method based on their response.
        try {
            response = readInput();
            if (response.equals("1")) {
                instructionsScreen = true;
            } else if (response.equals("2")) {
                gameScreen = true;
            } else if (response.equals("-1"))
                quitProgram();
            else
                System.out.println("\nInvalid option...");
        } catch (Exception e) {
            System.out.println("\nYou are already at the main menu!");
        }
        System.out.println();
    }

    // Method for displaying instructions
    public static void instructions() {

        // Display instructions
        clearScreen();
        printHeader("\u001b[34mINSTRUCTIONS\u001b[37m");
        System.out.println(
                "game: are you smarter than a 5th grader\nquestions are 2 from g1, 2 from g2, 2 from g3, 2 from g4, 2 from g5, final boss challange from g5\ncheats (lifeline): peek, copy, save which is auto used"); // TO-DO:
                                                                                                                                                                                                                       // type
                                                                                                                                                                                                                       // instructions
                                                                                                                                                                                                                       // in
                                                                                                                                                                                                                       // sentences

        // Return to menu message
        System.out.println("\nTo return to the main menu, enter 0.\n");

        // Collect input from the user.
        try {
            response = readInput();
            System.out.println("\nInvalid option...");
        } catch (Exception e) {
            System.out.println("\nReturning to main screen...");
        }
    }

    public static void game() {
        // Variable declaration
        int[] moneyEarnings = { 0, 1000, 2000, 5000, 10000, 25000, 50000, 100000, 175000, 300000, 500000, 1000000 };
        String[][][] questions = {
                { { "g1qp1", "g1ap1", "g1cp1" }, { "g1q2p1", "g1a2p1", "g1c2p1" } }, // Grade 1 p1
                { { "g1qp2", "g1ap2", "g1cp2" }, { "g1q2p2", "g1a2p2", "g1c2p2" } }, // Grade 1 p2
                { { "g2qp1", "g2ap1", "g2cp1" }, { "g2q2p1", "g2a2p1", "g2c2p1" } }, // Grade 2 p1
                { { "g2qp2", "g2ap2", "g2cp2" }, { "g2q2p2", "g2a2p2", "g2c2p2" } }, // Grade 2 p2
                { { "g3qp1", "g3ap1", "g3ap1" }, { "g3q2p1", "g3a2p1", "g3a2p1" } }, // Grade 3 p1
                { { "g3qp2", "g3ap2", "g3ap2" }, { "g3q2p2", "g3a2p2", "g3a2p2" } }, // Grade 3 p2
                { { "g4qp1", "g4ap1", "g4cp1" }, { "g4q2p1", "g4a2p1", "g4c2p1" } }, // Grade 4 p1
                { { "g4qp2", "g4ap2", "g4cp2" }, { "g4q2p2", "g4a2p2", "g4c2p2" } }, // Grade 4 p2
                { { "g5qp1", "g5ap1", "g5ap1" }, { "g5q2p1", "g5a2p1", "g5a2p1" } }, // Grade 5 p1
                { { "g5qp2", "g5ap2", "g5ap2" }, { "g5q2p2", "g5a2p2", "g5a2p2" } }, // Grade 5 p2
                { { "fq", "fa", "fc" }, { "fq2", "fa2", "fc2" } } // Final question
        };
        int qNum = 1;
        int qRange = 2; // change later
        boolean alive = true;
        boolean dropOut = false;
        boolean peek = false;
        boolean copy = false;
        boolean save = true;
        boolean getInput = true;
        int randQNum;

        String response = "";
        String q;
        String a;
        String classmateAnswer;

        while (gameScreen && alive && qNum <= 10) {
            randQNum = (int) (qRange * Math.random());
            q = questions[qNum - 1][randQNum][0];
            a = questions[qNum - 1][randQNum][1];
            classmateAnswer = questions[qNum - 1][randQNum][2];
            getInput = true;

            while (gameScreen && alive) {
                if (getInput) {
                    clearScreen();
                    printHeader("\u001b[34mGAME\u001b[37m");
                    printHeader("\u001b[33mQUESTION " + qNum + "\u001b[37m\n\n" + q);
                    try {
                        response = readInput();
                    } catch (Exception e) {
                        System.out.println("Returning to main screen...");
                        gameScreen = false;
                        break;
                    }
                }

                if (response.equalsIgnoreCase("copy")) {
                    // copy
                    if (!copy) {
                        System.out.println("\nYou copy your classmate's answer: " + classmateAnswer + ".");
                        copy = true;
                        response = classmateAnswer;
                        getInput = false;
                    } else {
                        System.out.println(
                                "\nYou already used your copy cheat! Either use a different cheat (if you haven't already) or figure it out yourself.");
                    }
                    wait(2000);
                } else if (response.equalsIgnoreCase("peek")) {
                    // peek
                    if (!peek) {
                        System.out.println(
                                "\nYou peek at your classmate's answer: " + classmateAnswer
                                        + ". Your turn to answer!\n");
                        peek = true;
                    } else {
                        System.out.println(
                                "\nYou already used your peek cheat! Either use a different cheat (if you haven't already) or figure it out yourself.");
                    }
                    wait(2000);
                } else if (response.equalsIgnoreCase("drop out")) {
                    // drop out
                    dropOut = true;
                    alive = false;
                } else if (!response.equalsIgnoreCase(a)) {
                    // incorrect answer
                    if (save) {
                        save = false;
                        System.out.print(
                                "\n\u001b[31mIncorrect!\u001b[37m You have been saved with your classmates answer: "
                                        + classmateAnswer);
                        response = classmateAnswer;
                        if (!response.equalsIgnoreCase(a)) {
                            System.out.println("... or not. ");
                            alive = false;
                        } else
                            System.out.println("!");
                        getInput = false;
                    } else {
                        System.out.println(
                                "\n\u001b[31mIncorrect!\u001b[37m Unfortunately, you already used your save cheat. The correct answer was "
                                        + a + ".");

                        alive = false;
                    }
                    wait(2000);
                } else {
                    // correct answer
                    System.out.println("\n\u001b[32mCorrect!\u001b[37m");
                    qNum++;
                    wait(1000);
                    break;
                }
            }
        }

        if (gameScreen) {
            if (!alive) {
                if (dropOut) {
                    clearScreen();
                    printHeader("Drop Out");
                    System.out.println("You dropped out of school... winning $" + moneyEarnings[qNum] + "!");
                } else {
                    clearScreen();
                    printHeader("Failure");
                    System.out.print("You failed school...");
                    if (qNum < 5)
                        System.out.println(" losing all hard-earned money.");
                    else
                        System.out.println("but you still win $25,000 for getting this far!");
                }
                wait(4000);
            } else {
                printHeader("Winner");
                System.out.println("You passed! Time for the final question...");
                randQNum = (int) (qRange * Math.random());
                q = questions[10][randQNum][0];
                a = questions[10][randQNum][1];
                clearScreen();
                printHeader("\u001b[34mGAME\u001b[37m");
                printHeader("\u001b[33mFINAL QUESTION " + "\u001b[37m\n\n" + q);
                try {
                    response = readInput();
                    if (response.equalsIgnoreCase(a)) {
                        System.out.println(
                                "\nAND WE HAVE A WINNER!!! You win the grand prize of $1,000,000 to take home!");
                    } else {
                        System.out.println("\nUnlucky. The correct answer was " + a
                                + ". But you still win $25,000 for getting this far!");
                    }
                    wait(4000);
                } catch (Exception e) {
                    System.out.println("Returning to main screen...");
                    gameScreen = false;
                }
            }

            while (gameScreen) {
                System.out.println("\nLook at the camera and answer: are you smarter than a 5th grader?\n");
                try {
                    response = readInput();

                    if (response.equalsIgnoreCase("yes")) {
                        if (alive)
                            System.out.println("\nCongratulations!");
                        else
                            System.out.println("\nLiar!");
                        break;
                    } else if (response.equalsIgnoreCase("no")) {
                        if (!alive)
                            System.out.println("\nLoser");
                        else
                            System.out.println("\nNerd");
                        break;
                    } else {
                        System.out.println("\nInvalid response. Try again: ");
                    }
                    wait(1000);
                } catch (Exception e) {
                    gameScreen = false;
                }
            }
            System.out.println("\nReturning to the main menu...");
            gameScreen = false;
            wait(1000);
        }
    }

    public static void main(String[] args) {
        while (true) {
            if (instructionsScreen)
                instructions();
            else if (gameScreen)
                game();
            else
                mainMenu();
        }
    }
}