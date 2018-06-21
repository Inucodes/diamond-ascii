package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        plusLine(size); //starting top line

         //jumping to new line
        mOut.print("\n");

        // draw side wall and "size" number of lines
        for (int i=1; i<=size; i++) {
            mOut.print("|");

            // draw decreasing number of spaces on the left
            for (int j = size; j > i; j--) {
                mOut.print(" ");
            }

            if (i == size) {
                mOut.print("<"); // draw the pointy separator on the left
            } else {
                mOut.print("/"); // draw the standard separator on the left
            }

            // draw increasing number of inside lines
            for (int j = 1; j <= i; j++) {
                String insideLine = oddOrEven(i); // calling method to select the type of inside lines
                if (j > 1) {
                    mOut.print(insideLine); // variable for inside lines
                }

            }

            if (i == size) {
                mOut.print(">"); // draw the pointy separator on the right
            } else {
                mOut.print("\\"); // draw the separator on the right
            }

            // draw decreasing number of spaces on the right
            for (int j = size; j > i; j--) {
                mOut.print(" ");
            }

            //ending wall
            mOut.print("|");
            // end the current line
            mOut.print("\n");

        }


        // drawing lower "triangle" part
        // draw "size-1" number of lines

        for (int i=1; i<size; i++) {
            mOut.print("|"); // left side wall

            // draw increasing number of spaces on the left
            for (int j = 0; j < i; j++) {
                mOut.print(" ");
            }

            mOut.print("\\"); // draw the standard bottom separator on the left


            // draw decreasing number of inside lines
            for (int j = size; j > i; j--) {
                String insideLine = oddOrEven(size+i);
                if (j < size) {
                    mOut.print(insideLine); // variable for inside lines
                }

            }

            mOut.print("/"); // draw the bottom separator on the right

            // draw increasing number of spaces on the right
            for (int j = 0; j < i; j++) {
                mOut.print(" ");
            }

            //ending wall
            mOut.print("|");
            // end the current line
            mOut.print("\n");
        }

        plusLine(size); //ending line

    }

    /**
     * Method draws a start and end line
     * @param SelectedSize the size selected by the user
     */
        private void plusLine(int SelectedSize) {

            // starting +
            mOut.print("+");

            // loop for the line size
            for (int i = 1; i <= SelectedSize * 2; i++) {
                mOut.print("-");
            }
            // ending +
            mOut.print("+");

        }

    /**
     * @param number number to check
     * @return returns the correct value of insideLine on odd or even number
     */
    private String oddOrEven(int number) {

        String resultString;

        if (number % 2 == 0) {

            resultString = "--"; // number is even

        } else {

            resultString = "=="; // number is odd

        }

        return resultString;
    }




}