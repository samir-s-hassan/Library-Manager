/***
 * Class to model Book
 * 
 * @author Samir Hassan
 * @version 0.1
 *          Date of creation: February 21, 2022
 *          Last Date Modified: February 27, 2022
 */

public class Book extends Title {
    private String author; // private data fields
    private Long ISBN;

    /***
     * No parameter constructor the book of the titles array
     * 
     * @return no return value
     */
    public Book() {
        super();
        this.author = "none";
        this.ISBN = 00000000L;
    }

    /***
     * Seven parameter constructor the book of the titles array
     * 
     * @param title      is a string corresponding to title
     * @param publisher  is a string corresponding to the publisher
     * @param callNumber is a string corresponding to the call number
     * @param year       is an integer corresponding to published year
     * @param copies     is an integer corresponding to amount of copies
     * @param author     is a string corresponding to the author of book
     * @param ISBN       is a long corresponding to the ISBN
     * @return no return value
     */
    public Book(String title, String publisher, String callNumber, int year, int copies,
            String author, long ISBN) {
        super(title, publisher, callNumber, year, copies);
        this.author = author;
        this.ISBN = ISBN;
    }

    /***
     * gets the authors
     * 
     * @return no return value
     */
    public String getAuthor() {
        return author;
    }

    /***
     * gets the ISBN
     * 
     * @return no return value
     */
    public long getISBN() {
        return ISBN;
    }

    /***
     * sets the author
     * 
     * @param author is the author
     * @return no return value
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /***
     * sets the ISBN
     * 
     * @param ISBN is the long corresponding to the ISBN
     * @return no return value
     */
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
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
        output1 = super.simpleString() + String.format("%s\n%s\n", author, ISBN);
        return output1;

    }

    /***
     * Prints the elements of the book in a manner for a certain method
     * 
     * @return no return value
     */
    public String callString() {
        String output2 = "";
        output2 = super.callString() + String.format("\nAuthor: %s\nISBN: %s", author, ISBN);
        return output2;
    }

}