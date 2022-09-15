/***
 * Class to model the entity InvalidTitleException
 * @author Samir Hassan
 * @version 0.1
 * Date of creation: February 21, 2022
 * Last Date Modified: February 21, 2022
 */

import java.util.InputMismatchException;

public class InvalidTitleException extends InputMismatchException {

    /***
     * Default constructor
     * No parameters
     */
    public InvalidTitleException() {
        super("Invalid Title");
    }

    /***
     * One argument constructor
     * 
     * @param message is a message that should be output upon the occurence
     */
    public InvalidTitleException(String message) {
        super(message);
    }

}
    
