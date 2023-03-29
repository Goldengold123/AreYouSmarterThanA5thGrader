/*
 * Author: Grace Pu
 * Date: March 20
 * Description: This program simulates a text version of the popular game show, Are You Smarter Than A 5th Grader. 
 * Bonus Features: Lifeline, Colour, Sound Effects
 */

// Import classes
import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class GameShow {

    // Global variables declaration
    public static Scanner in = new Scanner(System.in);
    public static boolean instructionsScreen = false;
    public static boolean gameScreen = false;
    public static String response;

    public static Clip openingMusic;

    // Method for waiting ms milliseconds.
    public static void wait(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    // Method for clearing the screen.
    public static void clearScreen() throws InterruptedException {
        wait(1000);
        // Clear screen
        System.out.println("\n".repeat(100));
    }

    // Method for quitting: display message, close scanner, and quit.
    public static void quitProgram() throws InterruptedException {
        printHeader("Exiting...");
        in.close();
        wait(500);
        System.exit(0);
    }

    // Method for reading input line
    // If 0 is entered, an exception is thrown: since the input was invalid, program should return to main menu instead of managing input.
    public static String readInput() throws Exception {
        // read input
        String input = in.nextLine();

        // check if input is "0"
        if (input.equalsIgnoreCase("0")) {
            // set boolean variables to false -> return to main menu
            instructionsScreen = false;
            gameScreen = false;
            // throw exception to indicate return to main menu
            throw new Exception("main menu");
        } else  // if input is not "0", return the input
            return input;
    }

    // Method for displaying header text; sample below:
    // -------
    // message
    // -------
    public static void printHeader(String s) {
        System.out.println("-".repeat(125) + "\n" + s + "\n" + "-".repeat(125));
    }

    // Method for opening sound based on path
    public static void openSound(Clip sound, String path) {
        try {  // try to load the sound
            sound.open(AudioSystem.getAudioInputStream(new File("sounds/" + path)));
        } catch (Exception e) {  // exception
            e.printStackTrace();
        }
    }

    // Method for playing sound
    public static void playSound(Clip sound) {
        sound.start();  // start the sound
    }

    // Method for intro screen
    public static void introScreen(String[] title) throws InterruptedException {
        // Variable declaration
        int lines = title.length;

        // Play opening music sound clip
        try {
            openingMusic = AudioSystem.getClip();
        } catch (Exception e) {
            e.printStackTrace();
        }
        openSound(openingMusic, "mainTheme.wav");  // call openSound method with path of sound file
        playSound(openingMusic);  // call playSound method

        // clear screen in preparation for intro screen
        clearScreen();

        // Slide title onto screen from the bottom
        for (int i = 0; i < lines; i++) {
            System.out.println(title[i]);
            Thread.sleep(25);
        }
        Thread.sleep(500);

        // Alternating flash of title
        for (int j = 0; j < 3; j++) {
            // Even numbered lines
            System.out.println("\n".repeat(100));
            for (int i = 0; i < lines; i += 2) {
                System.out.println(title[i]);
                System.out.println();
            }
            Thread.sleep(50);

            // Odd numbered lines
            System.out.println("\n".repeat(50));
            for (int i = 1; i < lines; i += 2) {
                System.out.println();
                System.out.println(title[i]);
            }
            Thread.sleep(50);
        }

        // Flashing of title
        for (int j = 0; j < 3; j++) {
            System.out.println("\n".repeat(100));
            for (int i = 0; i < lines; i++)
                System.out.println(title[i]);
            Thread.sleep(150 - 40 * j);
            clearScreen();
            Thread.sleep(150 - 40 * j);
        }
    }

    // Method for main menu
    public static void mainMenu(String[] title) throws InterruptedException {
        // clear screen before displaying main menu elements
        clearScreen();

        // Generate string containing game title from title array
        String s = "";
        for (String l : title) {
            s += l;
            s += "\n";
        }

        // Display title using header display method
        printHeader(s);

        // Options: Instructions, Play, Exit
        System.out.println("Enter the number indicated before the desired option:");
        System.out.printf("%4d: %s\n", 1, "Instructions");
        System.out.printf("%4d: %s\n", 2, "Play");
        System.out.printf("%4d: %s\n", 0, "Return to the main menu at any point in the game.");
        System.out.printf("%4d: %s\n", -1, "Quit");
        System.out.println();

        // Collect input from the user and run the method based on their response.
        try {
            response = readInput();  // read input
            if (response.equals("1")) {  // input is 1 -> instructions
                instructionsScreen = true;
            } else if (response.equals("2")) {  // input is 2 -> play
                gameScreen = true;
            } else if (response.equals("-1")) // input is -1 -> exit
                quitProgram();
            else  // input is other -> invalid
                System.out.println("\nInvalid option...");
        } catch (Exception e) {  // exception thrown -> input is 0 -> main menu
            System.out.println("\nYou are already at the main menu!");
        }

        System.out.println();
    }

    // Method for displaying brief instructions
    public static void instructions() throws InterruptedException {
        // Display instructions
        clearScreen();
        printHeader("\u001b[34mINSTRUCTIONS\u001b[37m");

        // condensed into 1 line so entirety could be selected easily when editing code; to read instructions in the IDE, use word wrap
        System.out.println(
                "\u001b[34mWelcome to the game - Are You Smarter Than A 5th Grader!!!\n\n\n\u001b[37mThere are a total of 10 + 1 final challenging questions for you to answer.\nAs you progress, the money ladder increases - you win more money.\nYou can use any capitalization for you answers but they should be the simplest answer possible (i.e. \u001b[33m1\u001b[37m instead of \u001b[33mone\u001b[37m). \n\nAt any point in the game, you may choose to drop out of school and keep your earnings: enter \u001b[33mdrop out\u001b[37m to do so.\n\nIf you get the question \u001b[32mcorrect\u001b[37m, you will advance onto the next question.\n\nIf you get the question \u001b[31mincorrect\u001b[37m, you will either lose all of your earnings or leave with $25,000.\n\n\nLifeline System: these can only be used in the intial 10 questions - you must complete the final question yourself.\n\n1. \u001b[33mpeek\u001b[37m - shown your classmate's answer for a brief moment before being prompted for your own answer\n\n2. \u001b[33mcopy\u001b[37m - forced to use your classmate's answer, regardless of whether it is correct or not\n\n3. \u001b[33msave\u001b[37m - classmate's answer is automatically deployed when you get a question incorrect\n\n\nThroughout the game, if you wish to return to the main menu, enter \u001b[33m0\u001b[37m.\n\n\n\u001b[34mGood luck and have fun!\u001b[37m\n");

        // Return to menu and see detailed instructions message
        System.out.println("\nFor more detailed instructions, enter 1.");
        System.out.println("\n\u001b[33mTo return to the main menu, enter 0.\u001b[37m\n");

        // Collect input from the user.
        try {
            response = readInput();  // read input
            if (response.equalsIgnoreCase("1"))  // input is 1 -> detailed instructions
                instructionsDetailed();
            else
                System.out.println("\nInvalid option...");  // input is other -> invalid
        } catch (Exception e) {  // exception thrown -> input is 0 -> main menu
            System.out.println("\n\u001b[33mReturning to main menu...\u001b[37m");
        }
    }

    // Method for displaying detailed instructions
    public static void instructionsDetailed() throws InterruptedException {
        // Display instructions
        clearScreen();
        printHeader("\u001b[34mINSTRUCTIONS DETAILED\u001b[37m");

        // condensed into 1 line so entirety could be selected easily when editing code; to read instructions in the IDE, use word wrap
        System.out.println(
                "\u001b[34mWelcome to the game - Are You Smarter Than A 5th Grader!!!\n\n\n\u001b[37mThere are a total of 10 + 1 final challenging questions for you to answer.\nAs you progress, the money ladder increases - you win more money.\nOf the first 10 questions, there are 2 from each grade level (grades 1 to 5).\nThese will be prompted to you based on the grade level order.\nYou can use any capitalization for you answers but they should be the simplest answer possible (i.e. \u001b[33m1\u001b[37m instead of \u001b[33mone\u001b[37m). \n\nAt any point in the game, you may choose to drop out of school and keep your earnings: enter \u001b[33mdrop out\u001b[37m to do so.\n\nIf you get the question \u001b[32mcorrect\u001b[37m, you will advance onto the next question.\n\nIf you get the question \u001b[31mincorrect\u001b[37m, depending on the question number, you will\n\t- lose all of your earnings (if you did not get past question 5)\n\t- leave with $25,000 (if you got to question 5)\n\n\nLifeline System: these can only be used in the intial 10 questions - you must complete the final question yourself.\n\n1. At any point in the game, you can peek at your classmate's answer by entering \u001b[33mpeek\u001b[37m.\nYou will be shown your classmate's answer for a brief moment before being prompted for your own answer.\nFor grade 1, 2, and 3 level questions, there is a 2/3 chance your classmate is correct.\nFor grade 4 and 5 level questions, there is a 1/3 chance your classmate is correct.\n\n2. At any point in the game, you can copy at your classmate's answer by entering \u001b[33mcopy\u001b[37m.\nYou will be forced to use your classmate's answer, regardless of whether it is correct or not.\nThe probabilities of correctness are identical to those of the \u001b[33mpeek\u001b[37m cheat.\n\n3. If you get a question incorrect, the \u001b[33msave\u001b[37m lifeline will be automatically used.\nYour classmate's answer is automatically deployed.\nThe probabilities of correctness are identical to both of the above cheats.\n\n\nThroughout the game, if you wish to return to the main menu, enter \u001b[33m0\u001b[37m.\n\n\nGood luck and have fun!\n");
        
        // Return to menu message
        System.out.println("\n\u001b[33mTo return to the main menu, enter 0.\u001b[37m\n");

        // Collect input from the user.
        try {
            response = readInput();  // read input
            System.out.println("\nInvalid option..."); // input is other -> invalid
        } catch (Exception e) {  // exception thrown -> input is 0 -> main menu
            System.out.println("\n\u001b[33mReturning to main menu...\u001b[37m");
        }
    }

    // Method for actual game
    public static void game() throws LineUnavailableException, InterruptedException {
        // VARIABLE DECLARATION (AND INITIALIZATION OF SOME VARIABLES)

        // Winnings amount
        int[] moneyEarnings = { 0, 1000, 2000, 5000, 10000, 25000, 50000, 100000, 175000, 300000, 500000, 1000000 };
        
        // question array format: question, correct answer, classmates answer for cheats
        // classmates answer is correct for 2/3 questions for grade 1,2,3 and 1/3
        // questions for grade 4,5
        String[][][] questions = {
                { // grade 1 part 1
                        { "How many oceans are there?", "5", "5" },
                        { "How many continents are there?", "7", "7" },
                        { "What is the largest country in the world?", "russia", "canada" }
                },
                { // grade 1 part 2
                        { "How many sides are on a nonagon?", "9", "9" },
                        { "How often is a leap year (ignore exceptions)? Once every _ years.", "4", "4" },
                        { "Fill the blank with the correct homonym: I have a ____ of socks.", "pair", "pear" }
                },
                { // grade 2 part 1
                        { "What protects the user against rain when they hold its central pole?", "umbrella",
                                "umbrela" },
                        { "What is the furthest planet from the sun in our solar system?", "neptune", "neptune" },
                        { "The chloroplast gives plants its green colour. What important process is performed by the chloroplasts?",
                                "photosynthesis", "photosynthesis" }
                },
                { // grade 2 part 2
                        { "Which continent has the least amount of humans living there?", "antarctica", "antarctica" },
                        { "What galaxy is the Earth in (hint: answer is 2 words)?", "milky way", "milky way" },
                        { "What is the largest mammal (hint: answer is 2 words)?", "blue whale", "green whale" }
                },
                { // grade 3 part 1
                        { "What is the antonym of antonym?", "synonym", "synonym" },
                        { "The equator is an imaginary line that divides the Earth into a northern hemisphere and a southern hemisphere.\nWhat is the imaginary line that divides the Earth into the eastern hemisphere and western hemisphere?",
                                "prime meridian", "prime meridian" },
                        { "What is the capital of Canada?", "ottawa", "toronto" }
                },
                { // grade 3 part 2
                        { "Which of the following is not a Prairie Province: British Columbia, Alberta, Saskatchewan, or Manitoba?",
                                "british columbia", "british columbia" },
                        { "How many provinces and territories does Canada have?", "13", "13" },
                        { "What is the last name of the first prime minister of Canada?", "macdonald", "mcdonald" }
                },
                { // grade 4 part 1
                        { "The third biggest country in North America is _____. ", "mexico", "mexico" },
                        { "What year was the Canadian Confederation formed?", "1867", "1967" },
                        { "What is the second longest river in North America: the _______ river. ", "mississippi",
                                "misisipi" },
                },
                { // grade 4 part 2
                        { "What is a group of dolphins called?", "pod", "dolfanes" },
                        { "The mother pig is known as a sow. Similarly, the father pig is known as a ____.", "boar",
                                "bear" },
                        { "What is the french verb for \"to walk\"?", "marcher", "marcher" }
                },
                { // grade 5 part 1
                        { "The states of matter are: solid, liquid, and ___.", "gas", "gas" },
                        { "What is the capital of Canada?", "ottawa", "toronto" },
                        { "What is the capital of Saskatchewan?", "regina", "saskatoon" }
                },
                { // grade 5 part 2
                        { "The body system, _____ system, protects your body's cells from invaders.", "immune",
                                "immune" },
                        { "What is the head of government of Canada called?", "prime minister", "president" },
                        { "Weather refers to the short-term conditions, whereas _____ refers to the average weather conditions \nover a long period of time.",
                                "climate", "long-term weather" },
                },
                { // final question
                        { "A long time ago, several continents were contiguous with each other. What was the name of this singular continent?", "pangaea",
                                "no cheats!" },
                        { "What are the first 10 (9 + initial 1st digit that is 3) digits of the mathematical constant pi?",
                                "3.141592653", "no cheats!" },
                        { "What is always coming but never arrives?", "tomorrow", "no cheats!" }
                }
        };

        int qNum = 1; // question number
        int qRange = 3; // possiblities for each question

        boolean alive = true; // user is alive
        boolean dropOut = false; // user is a drop out

        // booleans for if user used a specific lifeline (cheat)
        boolean peek = false;
        boolean copy = false;
        boolean save = true;

        boolean getInput = true; // should program collect input from user?
        int randQNum; // random number for question choice (3 possibilities for each question)

        String response = ""; // store user response
        String q; // store question
        String a; // store answer
        String classmateAnswer; // store classmate answer for peek, copy, and save lifelines

        // background music and sound effects sound clips variables
        Clip backgroundMusic = AudioSystem.getClip();
        Clip incorrectSound = AudioSystem.getClip();

        // Open and play background music sound
        openSound(backgroundMusic, "music.wav");
        playSound(backgroundMusic);

        // Open incorrect sound effect for future use
        openSound(incorrectSound, "incorrect.wav");

        // MAIN GAME WHILE LOOP
        while (gameScreen && alive && qNum <= 10) {
            // Generate random number; store question, answer, and classmate answer into
            // variables; set collect input to true
            randQNum = (int) (qRange * Math.random());
            q = questions[qNum - 1][randQNum][0];
            a = questions[qNum - 1][randQNum][1];
            classmateAnswer = questions[qNum - 1][randQNum][2];
            getInput = true;

            // while loop for the specific question generated above
            while (gameScreen && alive) {
                // prompt and collect input from user
                if (getInput) {
                    clearScreen();
                    // Display game and question header
                    printHeader("\u001b[34mGAME\u001b[37m");
                    printHeader("\u001b[33mQUESTION " + qNum + "\u001b[37m\n\n" + q);
                    try {  // read input
                        response = readInput();
                    } catch (Exception e) {  // exception thrown -> input is 0 -> main menu
                        System.out.println("\n\u001b[33mReturning to main menu...\u001b[37m");
                        gameScreen = false;
                        break;
                    }
                }

                // manage input collected from user

                if (response.equalsIgnoreCase("copy")) {  // user wants to use copy lifeline
                    if (!copy) {  // user copys classmate
                        System.out.println("\nYou copy your classmate's answer: \u001b[33m" + classmateAnswer + "\u001b[37m.");
                        copy = true;
                        response = classmateAnswer;
                        getInput = false;
                    } else {  // user alredy used copy lifeline
                        System.out.println("\nYou already used your copy cheat! Either use a different cheat (if you haven't already) or figure it out yourself.");
                    }

                    wait(2000);
                }
                else if (response.equalsIgnoreCase("peek")) {  // user wants to use peek lifeline
                    if (!peek) { // user peeks at classmate
                        System.out.println("\nYou peek at your classmate's answer: \u001b[33m" + classmateAnswer + "\u001b[37m. Your turn to answer!\n");
                        peek = true;
                    } else {
                        // user already used peek lifeline
                        System.out.println("\nYou already used your peek cheat! Either use a different cheat (if you haven't already) or figure it out yourself.");
                    }

                    wait(2000);
                }
                else if (response.equalsIgnoreCase("drop out")) {  // user wants to drop out
                    dropOut = true;
                    alive = false;
                }
                else if (!response.equalsIgnoreCase(a)) {  // incorrect answer
                    if (save) {  // user has save lifeline available for use
                        save = false;
                        response = classmateAnswer;

                        System.out.print("\n\u001b[31mIncorrect!\u001b[37m You have been saved with your classmates answer: \u001b[33m" + classmateAnswer + "\u001b[37m");

                        if (!response.equalsIgnoreCase(a)) {  // classmates answer is incorrect, finishes sentence from above
                            System.out.println("... or not. ");
                            alive = false;
                        } 
                        else  // classmates answer is correct, finishes sentence from above
                            System.out.println("!");
                        
                        getInput = false;
                    } 
                    else { // user already used save lifeline, incorrect -> lose game
                        System.out.println("\n\u001b[31mIncorrect!\u001b[37m Unfortunately, you already used your save cheat. The correct answer was \u001b[32m" + a + "\u001b[37m.");
                        playSound(incorrectSound);  // play sound effect for incorrect
                        alive = false;
                    }

                    wait(2000);
                }
                else {  // correct answer
                    System.out.println("\n\u001b[32mCorrect!\u001b[37m");
                    qNum++;
                    break;
                }
            }
        }

        // MAIN GAME LOOP FINISHED

        // display final question and results to user if user is still in the game
        if (gameScreen) {  // user is still in the game (0 was not inputted)
            if (!alive) { // user did not make it to final question
                if (dropOut) { // user dropped out so they get money at the level they dropped out at
                    clearScreen();
                    printHeader("\u001b[31mDrop out\u001b[37m");
                    System.out.println("You dropped out of school... winning $" + moneyEarnings[qNum] + "!");
                }
                else {  // user failed (got question wrong)
                    clearScreen();
                    printHeader("\u001b[31mFailure\u001b[37m");
                    System.out.print("You failed school...");

                    if (qNum < 5)  // user did not get to question 5 -> no money
                        System.out.println(" losing all hard-earned money.");
                    else  // user got to question 5 -> $25,000
                        System.out.println("but you still win $25,000 for getting this far!");
                }

                wait(4000);
            }
            else {  // user made it to final question

                // welcoming message
                clearScreen();
                printHeader("\u001b[34mGAME\u001b[37m");
                System.out.println("You passed! Time for the final question...");
                wait(2000);

                // generate a random question and set variables q and a
                randQNum = (int) (qRange * Math.random());
                q = questions[10][randQNum][0];
                a = questions[10][randQNum][1];

                // display header and question
                clearScreen();
                printHeader("\u001b[34mGAME\u001b[37m");
                printHeader("\u001b[33mFINAL QUESTION " + "\u001b[37m\n\n" + q);

                try {  // collect input from user
                    response = readInput();

                    if (response.equalsIgnoreCase(a)) {  // user is correct
                        clearScreen();
                        printHeader("\u001b[32mAND WE HAVE A WINNER!!!\u001b[37m You win the grand prize of $1,000,000 to take home!");
                    }
                    else {  // user is incorrect
                        printHeader("\n\u001b[31mUnlucky\u001b[37m. The correct answer was \u001b[32m" + a + "\u001b[37m. But you still win $25,000 for getting this far!");
                    }

                    wait(4000);
                } catch (Exception e) {  // exception thrown -> input is 0 -> main menu
                    System.out.println("\n\u001b[33mReturning to main menu...\u001b[37m");
                    gameScreen = false;
                }
            }

            // closing screen if user is still on gameScreen (i.e. if 0 was inputted, this is skipped and user is returned to main menu)
            while (gameScreen) {
                // prompt message
                // this is a component of the classic game as described on wikipedia: when player leaves, they have to answer (on camera) whether they are smarter than a 5th grader
                printHeader("\n\u001b[33mLook at the camera and answer: are you smarter than a 5th grader?\u001b[37m\n");
                
                try {  // collect input
                    response = readInput();
                    if (response.equalsIgnoreCase("yes")) {  // user responded that they beat the game
                        if (alive)  // user did indeed beat the game
                            System.out.println("\nCongratulations!");
                        else  // user is a liar
                            System.out.println("\nLiar!");
                        break;
                    }
                    else if (response.equalsIgnoreCase("no")) {  // user responded that they did not win
                        if (!alive)  // user did indeed lose
                            System.out.println("\nThat's alright, try playing the game again!");
                        else  // user actually beat the game
                            System.out.println("\nWhy would you lie when you beat the game...");
                        break;
                    }
                    else {  // invalid response
                        System.out.println("\nInvalid response. Try again (yes or no): ");
                    }

                    wait(1000);
                } catch (Exception e) {  // exception thrown -> input is 0 -> main menu
                    gameScreen = false;
                }
            }

            // Game has concluded and user has not inputted 0 to return to the main menu
            // As such, automatically return the user to the main menu
            System.out.println("\n\u001b[33mReturning to the main menu...\u001b[37m");
            gameScreen = false;
            wait(1000);
        }

        // close sound clip variables
        backgroundMusic.close();
        incorrectSound.close();
    }

    public static void main(String[] args) {
        // Variable declaration
        String[] title = {
                "\u001b[34m \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2557   \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2557   \u2588\u2588\u2557\u001b[37m",
                "\u001b[34m\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D  \u255A\u2588\u2588\u2557 \u2588\u2588\u2554\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551   \u2588\u2588\u2551\u001b[37m",
                "\u001b[34m\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2557     \u255A\u2588\u2588\u2588\u2588\u2554\u255D \u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\u001b[37m",
                "\u001b[34m\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u255D      \u255A\u2588\u2588\u2554\u255D  \u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551   \u2588\u2588\u2551\u001b[37m",
                "\u001b[34m\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557     \u2588\u2588\u2551   \u255A\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u001b[37m",
                "\u001b[34m\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D     \u255A\u2550\u255D    \u255A\u2550\u2550\u2550\u2550\u255D  \u255A\u2550\u2550\u2550\u2550\u2550\u255D \u001b[37m",
                "",
                "\u001b[34m \u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2557   \u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u001b[37m",
                "\u001b[34m\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u001b[37m",
                "\u001b[34m \u255A\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2554\u2588\u2588\u2588\u2588\u2554\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D   \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u001b[37m",
                "\u001b[34m \u255A\u2550\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2551\u255A\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557   \u2588\u2588\u2551   \u2588\u2588\u2554\u2550\u2550\u255D  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u001b[37m",
                "\u001b[34m\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551 \u255A\u2550\u255D \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551   \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2551\u001b[37m",
                "\u001b[34m\u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D     \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D   \u255A\u2550\u255D   \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u001b[37m",
                "",
                "\u001b[34m\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2557  \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2557  \u2588\u2588\u2557   \u2588\u2588\u2588\u2588\u2588\u2557   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2557  \u2588\u2588\u2557\u001b[37m",
                "\u001b[34m\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2551  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557  \u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\u001b[37m",
                "\u001b[34m   \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551  \u2588\u2588\u2588\u2588\u2588\u2588\u2557    \u2588\u2588\u2551   \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u001b[37m",
                "\u001b[34m   \u2588\u2588\u2551   \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2551\u255A\u2588\u2588\u2588\u2588\u2551  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551  \u255A\u2550\u2550\u2550\u2550\u2588\u2588\u2557   \u2588\u2588\u2551   \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u001b[37m",
                "\u001b[34m   \u2588\u2588\u2551   \u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551 \u255A\u2588\u2588\u2588\u2551  \u2588\u2588\u2551  \u2588\u2588\u2551  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D   \u2588\u2588\u2551   \u2588\u2588\u2551  \u2588\u2588\u2551\u001b[37m",
                "\u001b[34m   \u255A\u2550\u255D   \u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u2550\u255D  \u255A\u2550\u255D  \u255A\u2550\u255D  \u255A\u2550\u2550\u2550\u2550\u2550\u255D    \u255A\u2550\u255D   \u255A\u2550\u255D  \u255A\u2550\u255D\u001b[37m",
                "",
                "\u001b[34m \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2557 ",
                "\u001b[34m\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u001b[37m",
                "\u001b[34m\u2588\u2588\u2551  \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u255A\u2550\u255D\u2588\u2588\u2588\u2554\u255D\u001b[37m",
                "\u001b[34m\u2588\u2588\u2551  \u255A\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u255D  \u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557   \u255A\u2550\u2550\u255D \u001b[37m",
                "\u001b[34m\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2551   \u2588\u2588\u2557  \u001b[37m",
                "\u001b[34m \u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D   \u255A\u2550\u255D  \u001b[37m"
        };

        // Intro screen
        try {
            introScreen(title);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Loop to keep main menu, instructions, or game running
        while (true) {
            if (instructionsScreen) {  // display instructions screen
                try {
                    instructions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (gameScreen) {  // stop and close intro opening music
                openingMusic.stop();
                openingMusic.close();
                
                try {  // display game screen
                    game();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {  // display main menu screen
                try {
                    mainMenu(title);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}