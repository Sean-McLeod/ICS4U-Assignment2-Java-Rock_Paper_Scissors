/*
* This program is the
* Rock Paper Scissors program.
* @author  Sean McLeod
* @version 1.0
* @since   2021-05-08
*/

import java.util.Scanner;
import java.util.Random;


final class RockPaperScissors {
    private RockPaperScissors() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** The min number for array. */
    public static final int ROCKVALUE = 1;
    /** The min number for array. */
    public static final int PAPERVALUE = 2;
    /** The min number for array. */
    public static final int SCISSORSVALUE = 3;

    public static String gameResult(final int comChoice, final int userValue) {
        String result;

        if (comChoice == userValue) {
            result = "It's a tie!";
        } else if ((comChoice == SCISSORSVALUE && userValue == ROCKVALUE)
                   || (comChoice == ROCKVALUE && userValue == PAPERVALUE)
                   || (comChoice == PAPERVALUE && userValue == SCISSORSVALUE)) {
            result = "You Win!";
        } else {
            result = "You Lose!";
        }
        // return result
        return result;
    }

    public static void main(final String[] args) {
        final int high = 3;
        final int low = 1;
        int userValue;
        String computerValue;

        System.out.println("Play Rock Paper Scissors with a computer");
        System.out.println("Options: Rock, Paper, Scissors");

        // input
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nYour choice: ");

        String userChoice = userInput.nextLine().toLowerCase();

        if ((userChoice.equals("rock"))
            || (userChoice.equals("paper"))
            || (userChoice.equals("scissors"))) {
            // declare values to strings to deal with it later
            if (userChoice.equals("rock")) {
                userValue = ROCKVALUE;
            } else if (userChoice.equals("paper")) {
                userValue = PAPERVALUE;
            } else {
                userValue = SCISSORSVALUE;
            }

            // generate random number
            Random rand = new Random();
            int comChoice = rand.nextInt(high - low + 1) + low;

            // change comChoice to string for users to understand
            if (comChoice == ROCKVALUE) {
                computerValue = "Rock";
            } else if (comChoice == PAPERVALUE) {
                computerValue = "paper";
            } else {
                computerValue = "Scissors";
            }
            // pass & accept parameter
            String result = gameResult(comChoice, userValue);
            // output
            System.out.println("Computer's Choice: " + computerValue);
            System.out.println("\n" + result);
        } else {
            System.out.println("\n" + userChoice + " is not an option");
        }
    }
}
