/***
 * Class to model the entity InvalidDateException
 * @author Samir Hassan
 * @version 0.1
 * Date of creation: February 21, 2022
 * Last Date Modified: February 21, 2022
 */

import java.util.InputMismatchException;

public class InvalidDateException extends InputMismatchException {

    /***
     * Default constructor
     * No parameters
     */
    public InvalidDateException() {
        super("Invalid Date");
    }

    /***
     * One argument constructor
     * 
     * @param message is a message that should be output upon the occurence
     */
    public InvalidDateException(String message) {
        super(message);
    }

}