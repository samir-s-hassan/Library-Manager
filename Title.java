/***
 * Class to model abstract Title
 * 
 * @author Samir Hassan
 * @version 0.1
 *          Date of creation: February 21, 2022
 *          Last Date Modified: February 27, 2022
 */

public abstract class Title implements Comparable<Title>, Restorable {
    private String title; // private data fields
    private String publisher;
    private String callNumber;
    private int year;
    private int copies;

    /***
     * No parameter protected constructor the book of the titles array
     * 
     * @return no return value
     */
    protected Title() {
        this("none", "none", "none", 0, 0);
    }

    /***
     * Five parameter constructor of the titles array
     * 
     * @param title      is a string corresponding to title
     * @param publisher  is a string corresponding to the publisher
     * @param callNumber is a string corresponding to the call number
     * @param year       is an integer corresponding to published year
     * @param copies     is an integer corresponding to amount of copies
     * @return no return value
     */
    protected Title(String title, String publisher, String callNumber, int year, int copies) {
        this.title = title;
        this.publisher = publisher;
        this.callNumber = callNumber;
        this.year = year;
        this.copies = copies;
    }

    /***
     * gets the title
     * 
     * @return no return value
     */
    public String getTitle() {
        return title;
    }

    /***
     * gets the publisher
     * 
     * @return no return value
     */
    public String getPublisher() {
        return publisher;
    }

    /***
     * gets the call Number
     * 
     * @return no return value
     */
    public String getCallNumber() {
        return callNumber;
    }

    /***
     * gets the year
     * 
     * @return no return value
     */
    public int getYear() {
        return year;
    }

    /***
     * gets the copies
     * 
     * @return no return value
     */
    public int getCopies() {
        return copies;
    }

    /***
     * sets the title number
     * 
     * @param title is a string corresponding to title
     * @return no return value
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /***
     * sets the publisher
     * 
     * @param publisher is a string corresponding to publisher
     * @return no return value
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /***
     * sets the call number
     * 
     * @param callNumber is a string corresponding to call Number
     * @return no return value
     */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /***
     * sets the year
     * 
     * @param year is an integer corresponding to year
     * @return no return value
     */
    public void setYear(int year) {
        this.year = year;
    }

    /***
     * sets the amount of copies
     * 
     * @param copies is an integer corresponding to amount of copies
     * @return no return value
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }

    /***
     * Prints the elements of the book
     * 
     * @return no return value
     */
    public String toString() {
        String output = "";
        output = String.format("%-15s\t%-55s\t%-30s\t%-10s", callNumber, title, publisher, year);
        return output;
    }

    /***
     * Prints the elements of the book in a formatted manner for writing back onto
     * text file
     * 
     * @return no return value
     */
    public String simpleString() {
        String output1 = "";
        output1 = String.format("%s\n%s\n%s\n%s\n%s\n",
                callNumber, title, publisher, year, copies);
        return output1;
    }

    /***
     * Prints the elements of the book in a manner for a certain method
     * 
     * @return no return value
     */
    public String callString() {
        String output2 = "";
        output2 = String.format("Title found: \nCall Number: %s\nTitle: %s\nPublisher: %s\nYear: %s\nCopies: %s",
                callNumber, title, publisher, year, copies);
        return output2;
    }

    /***
     * Method to compare the age of a title to another title
     * 
     * @param t is an object of title
     * @return a number corresponding to whether the title's year is greater, equal,
     *         or
     *         less than the other title's
     */
    public int compareTo(Title t) {
        if (this.getYear() == t.getYear()) {
            return -1;
        } else if (this.getYear() > t.getYear()) {
            return 1; // 1 means greater then
        } else {
            return -1; // -1 means less then
        }
    }

    /***
     * Method to view if the title is restorable
     * 
     * @param t is an object of title
     * @return a number corresponding to whether the title's year is greater, equal,
     *         or
     *         less than the other title's
     */
    public boolean isRestorable(Title t) {
        boolean restorable1 = false;
        if (t.getYear() < 2002) {
            restorable1 = true;
        }
        return restorable1;
    }

}