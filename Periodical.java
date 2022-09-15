/***
 * Class to model Periodical
 * 
 * @author Samir Hassan
 * @version 0.1
 *          Date of creation: February 21, 2022
 *          Last Date Modified: February 27, 2022
 */

public class Periodical extends Title {
    private int month; // private data fields
    private int issueNumber;

    /***
     * No parameter constructor the book of the titles array
     * 
     * @return no return value
     */
    public Periodical() {
        super();
        this.month = 0;
        this.issueNumber = 0;
    }

    /***
     * Seven parameter constructor the book of the titles array
     * 
     * @param title      is a string corresponding to title
     * @param publisher  is a string corresponding to the publisher
     * @param callNumber is a string corresponding to the call number
     * @param year       is an integer corresponding to published year
     * @param copies     is an integer corresponding to amount of copies
     * @param month      is a int corresponding to the month published
     * @param ISBN       is a long corresponding to the ISBN of the periodical
     * @return no return value
     */
    public Periodical(String title, String publisher, String callNumber, int year, int copies,
            int month, int issueNumber) {
        super(title, publisher, callNumber, year, copies);
        this.month = month;
        this.issueNumber = issueNumber;
    }

    /***
     * gets the month
     * 
     * @return no return value
     */
    public int getMonth() {
        return month;
    }

    /***
     * gets the issue number
     * 
     * @return no return value
     */
    public int issueNumber() {
        return issueNumber;
    }

    /***
     * sets the month
     * 
     * @param month is the integer corresponding to month
     * @return no return value
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /***
     * sets the issue number
     * 
     * @param issueNumber is an integer corresponding to issue number
     * @return no return value
     */
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    /***
     * Prints the elements of the book
     * 
     * @return no return value
     */
    public String toString() {
        return super.toString();
    }

    /***
     * Prints the elements of the book in a formatted manner for writing back onto
     * text file
     * 
     * @return no return value
     */
    public String simpleString() {
        String output1 = "";
        output1 = super.simpleString() + String.format("%s\n%s\n", month, issueNumber);
        return output1;

    }

    /***
     * Prints the elements of the book in a manner for a certain method
     * 
     * @return no return value
     */
    public String callString() {
        String output2 = "";
        output2 = super.callString() + String.format("\nMonth: %s\nIssue Number: %s", month, issueNumber);
        return output2;
    }

}