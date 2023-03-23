/*
 * Author: Grace Pu
 * Date: March 20
 * Description: This program simulates a text version of the popular game show, Are You Smarter Than A 5th Grader. 
 */

import java.util.*;

public class GameShow {

    // Variable declaration
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
        System.out.println("\n".repeat(50));
    }

    // Method for quitting: display message then quit.
    public static void quitProgram() {
        System.out.println("-".repeat(50));
        System.out.println("Exiting...");

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
        System.out.println("-".repeat(50) + "\n" + s + "\n" + "-".repeat(50));
    }

    // Method for initiating
    // public static void init() {

    // }

    // Method for main menu
    public static void mainMenu() {
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
        printHeader("Instructions");
        System.out.println("hmhmhm");

        // Return to menu message
        System.out.println("\nTo return to the main menu, enter 0.\n");

        // Collect input from the user.
        try {
            response = readInput();
            System.out.println("\nInvalid option...");
        } catch (Exception e) {
            System.out.println("Returning to main screen...");
        }
    }

    public static void game() {
        // Variable declaration
        String[][][] questions = {
                { { "g1q", "g1a", "g1c" }, { "g1q2", "g1a2", "g1c2" } }, // Grade 1
                { { "g2q", "g2a", "g2c" }, { "g2q2", "g2a2", "g2c2" } }, // Grade 2
                { { "g3q", "g3a", "g3c" }, { "g3q2", "g3a2", "g3c2" } }, // Grade 3
                { { "g4q", "g4a", "g4c" }, { "g4q2", "g4a2", "g4c2" } }, // Grade 4
                { { "g5q", "g5a", "g5c" }, { "g5q2", "g5a2", "g5c2" } }, // Grade 5
                { { "fq", "fa", "fc" }, { "fq2", "fa2", "fc2" } } // Final question
        };
        int qNum = 1;
        int qRange = 2;
        boolean alive = true;
        boolean dropOut = false;
        boolean peek = false;
        boolean copy = false;
        boolean save = true;
        boolean getInput = true;
        int money = 0;
        int randQNum;

        String response = "";
        String q;
        String a;
        String classmateAnswer;

        while (gameScreen && alive && qNum <= 10) {
            randQNum = (int) (qRange * Math.random());
            q = questions[qNum / 2][randQNum][0];
            a = questions[qNum / 2][randQNum][1];
            classmateAnswer = questions[qNum / 2][randQNum][2];
            getInput = true;

            while (gameScreen && alive) {
                clearScreen();
                printHeader("Game");
                printHeader("Question " + qNum);
                System.out.println(q + "\n");
                if (getInput) {
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
                    } else {
                        System.out.println("\nYou already used your copy cheat!");
                    }
                    wait(2000);
                    getInput = false;
                } else if (response.equalsIgnoreCase("peek")) {
                    // peek
                    if (!peek) {
                        System.out.println(
                                "\nYou peek at your classmate's answer: " + classmateAnswer + ". Your turn to answer!");
                        peek = true;
                    } else {
                        System.out.println("\nYou already used your peek cheat!");
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
                                "\nIncorrect! You have been saved with your classmates answer: " + classmateAnswer);
                        response = classmateAnswer;
                        if (!response.equalsIgnoreCase(a)) {
                            System.out.println("... or not. ");
                            alive = false;
                        } else
                            System.out.println("!");
                        getInput = false;
                    } else {
                        System.out.println("\nIncorrect! Unfortunately, you already used your save cheat.");
                        alive = false;
                    }
                    wait(2000);
                } else {
                    // correct answer
                    System.out.println("\nCorrect!");
                    qNum++;
                    break;
                }
            }
        }

        if (gameScreen) {
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
                } catch (Exception e) {
                }
            }
            System.out.println("\nPress 0 to return to the main menu.");
            gameScreen = false;
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
