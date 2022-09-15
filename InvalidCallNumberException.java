/***
 * Class to model the entity InvalidCallNumberException
 * @author Samir Hassan
 * @version 0.1
 * Date of creation: February 22, 2022
 * Last Date Modified: February 27, 2022
 */

import java.util.InputMismatchException;

public class InvalidCallNumberException extends InputMismatchException {

    /***
     * Default constructor
     * No parameters
     */
    public InvalidCallNumberException() {
        super("Invalid Call Number");
    }

    /***
     * One argument constructor
     * 
     * @param message is a message that should be output upon the occurence
     */
    public InvalidCallNumberException(String message) {
        super(message);
    }

}