
/***
 * Class to make the testing methods
 * @author Samir Hassan
 * @version 0.1
 * Date of creation: February 21, 2022
 * Last Date Modified: February 27, 2022
 */

import java.util.Scanner;
import java.lang.NullPointerException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;

/*added a null pointer exception however could've opted for global variable to keep track of size
could implement this in printTitles at the break statement and set the global var = i
then I could use i as the size from then on and update it when needed
*/
//IGNORE THIS ^ note to future self if looking over code again

public class Catalog {
    int size = 0; // global variable to keep track of non-null elements in array

    /***
     * Prints the elements of the titles array
     * 
     * @param list is the array of title entities
     * @return no return value
     */
    public void printTitles(Title[] list) {
        try {
            System.out.printf("%-15s\t%-55s\t%-30s\t%-10s\n", "Call Number", "Title", "Publisher", "Year");
            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(null)) {
                    break;
                }
                System.out.println(list[i]);
            }
        } catch (NullPointerException e) {
        }
    }

    /***
     * splits the elements of the media titles text file
     * 
     * @param inFS  is the scanner reading the text file
     * @param list1 is the array of all the media titles
     * @return no return value
     */
    public void splitText(Scanner inFS, Title[] list1) {
        // int count = 0;
        while (inFS.hasNextLine()) {
            String callNumber = inFS.nextLine();

            if (callNumber.charAt(0) == 'P') {
                String title = inFS.nextLine();
                String publisher = inFS.nextLine();
                int year = Integer.valueOf(inFS.nextLine());
                int copies = Integer.valueOf(inFS.nextLine());
                int month = Integer.valueOf(inFS.nextLine());
                int issueNumber = Integer.valueOf(inFS.nextLine());
                list1[size++] = new Periodical(title, publisher, callNumber, year, copies,
                        month, issueNumber); // changed count++ to size++ and removed the size++ on next line
            } else {
                String title = inFS.nextLine();
                String publisher = inFS.nextLine();
                int year = Integer.valueOf(inFS.nextLine());
                int copies = Integer.valueOf(inFS.nextLine());
                String author = inFS.nextLine();
                long ISBN = Long.valueOf(inFS.nextLine());
                list1[size++] = new Book(title, publisher, callNumber, year, copies,
                        author, ISBN); // changed count++ to size++ and removed the size++ on next line
            }

        }
    }

    /***
     * searches the titles array by call number and prints out the titles with
     * corresponding call number
     * 
     * @param callNumber is the call number provided by the user to search for
     * @param list       is the array of title entities
     * @return no return value
     */
    public void searchCallNumber(String callNumber, Title[] list) {
        int count = 0;
        boolean found = true;
        try {
            if (!callNumber.matches("[B|P]-[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]")) {
                throw new InvalidCallNumberException("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
            }
        } catch (InvalidCallNumberException e) {
            System.out.println(e.getMessage());
            found = false;
        }
        try {
            for (int i = 0; i < list.length; i++) {
                if (list[i].getCallNumber().equals(callNumber)) {
                    count++;
                    System.out.println(list[i].callString());
                }
            }
        } catch (NullPointerException e) {
        }
        if (count == 0 && found == true) {
            System.out.println("Title not found");
        }

    }

    /***
     * searches the titles array by title and prints out the titles with
     * corresponding title
     * 
     * @param title is the title the user provides to search for
     * @param list  is the array of title entities
     * @return no return value
     */
    public void searchTitle(String title, Title[] list) {
        int count = 0;
        try {
            for (int i = 0; i < list.length; i++) {
                if (list[i].getTitle().equals(title)) {
                    count++;
                }
            }
        } catch (NullPointerException e) {
        }
        if (count == 0) {
            System.out.println("No titles found.");
        } else {
            System.out.println("List of titles found: " + count); // need this outside try and catch block because
                                                                  // nullPointer is activated for the for loop
            System.out.printf("%-20s\t%-55s\t%-25s\t%-5s\n",
                    "Call Number", "Title", "Publisher", "Year");
            try {
                for (int i = 0; i < list.length; i++) {
                    if (list[i].getTitle().equals(title)) {
                        System.out.println(list[i]);
                    }
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /***
     * looks through the list of titles and finds the titles published in the
     * inputted year
     * 
     * @param year is the year the user provides to search for
     * @param list is the array of title entities
     * @return no return value
     */
    public void searchYear(int year, Title[] list) {
        boolean found = true;
        try {
            if (year >= 1900 && year <= 2022) {
            } else {
                throw new InvalidDateException("Invalid Year. Must be between 1900 and 2022.");
            }
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
            found = false;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].getYear() == year) {
                count++;
            }
        }
        if (count == 0 && found) {
            System.out.println("No titles found.");
        } else if (count == 0 && !found) {

        } else {
            System.out.println("List of titles found: " + count);
            System.out.printf("%-20s\t%-55s\t%-25s\t%-5s\n",
                    "Call Number", "Title", "Publisher", "Year");
            for (int i = 0; i < size; i++) {
                if (list[i].getYear() == year) {
                    System.out.println(list[i]);
                }
            }
        }
    }

    /***
     * sorts the titles array by year
     * 
     * @param list1 is the array of title entities
     * @return no return value
     */
    public void sortTitles(Title[] list1) {
        for (int i = 1; i < size; i++) {
            // Insert element i in the sorted sub-list
            Title currentVal = list1[i];
            int j = i;
            while (j > 0 && (currentVal.compareTo(list1[j - 1]) < 0)) {
                // Shift element (j-1) into element (j)
                list1[j] = list1[j - 1];
                j--;
            }
            // Insert currentVal at position j
            list1[j] = currentVal;
        }
    }

    /***
     * looks through the array and finds titles due for restoration
     * 
     * @param list1 is the array of title entities
     * @return no return value
     */
    public void viewRestoredTitles(Title[] list1) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list1[i].isRestorable(list1[i])) {
                count++;
            }
        }
        System.out.println("List of titles found: " + count);
        System.out.printf("%-20s\t%-55s\t%-25s\t%-5s\n",
                "Call Number", "Title", "Publisher", "Year");
        for (int i = 0; i < size; i++) {
            if (list1[i].isRestorable(list1[i])) {
                System.out.println(list1[i]);
            }
        }

    }

    /***
     * adds a new title to the overarching list of titles
     * 
     * @param list1 is the array of title entities
     * @return no return value
     */
    public void addNewTitle(Scanner scnr1, Title[] list1) {
        boolean yearChecker = false;
        boolean typeChecker = false;
        System.out.println("Enter the title: ");
        String title = scnr1.nextLine();
        System.out.println("Enter the publisher: ");
        String publisher = scnr1.nextLine();
        System.out.println("Enter the year of publication: ");
        int year = scnr1.nextInt();
        try {
            if (year >= 1900 && year <= 2022) {
                yearChecker = true;
            } else {
                throw new InvalidDateException("Invalid Year. Must be between 1900 and 2022.");
            }
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
        if (yearChecker) {
            System.out.println("Enter the number of copies: ");
            int copies = scnr1.nextInt();
            System.out.println("Enter the type of title (book/periodical): ");
            String type = scnr1.nextLine();
            String type1 = scnr1.nextLine();
            try {
                if (type1.equalsIgnoreCase("book") || type1.equalsIgnoreCase("periodical")) {
                    typeChecker = true;
                } else {
                    throw new InvalidTitleException("Invalid type of title. Must be a book or periodical.");
                }
            } catch (InvalidTitleException e) {
                System.out.println(e.getMessage());
            }
            if (typeChecker) {
                System.out.println("Enter the call number: ");
                String callNumber = scnr1.nextLine();
                try {
                    if (!callNumber.matches("[B|P]-[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]")) {
                        throw new InvalidCallNumberException(
                                "Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
                    } else {
                        if (callNumber.charAt(0) == 'P' && type1.equalsIgnoreCase("periodical")) {
                            System.out.println("Enter the month: ");
                            int month = Integer.valueOf(scnr1.nextLine());
                            System.out.println("Enter the issue number: ");
                            int issueNumber = Integer.valueOf(scnr1.nextLine());
                            list1[size++] = new Periodical(title, publisher, callNumber, year, copies,
                                    month, issueNumber);
                            System.out.println("Title added successfully.");
                        } else if (callNumber.charAt(0) == 'B' && type1.equalsIgnoreCase("book")) {
                            System.out.println("Enter the author: ");
                            String author = scnr1.nextLine();
                            System.out.println("Enter the ISBN (10 digits): ");
                            long ISBN = Long.valueOf(scnr1.nextLine());
                            list1[size++] = new Book(title, publisher, callNumber, year, copies,
                                    author, ISBN);
                            System.out.println("Title added successfully.");

                        } else if (callNumber.charAt(0) == 'B' && type1.equalsIgnoreCase("periodical")) {
                            System.out.println("Invalid Call Number for type periodical. Must be P-ddd-ddd-ddd");
                        } else if (callNumber.charAt(0) == 'P' && type1.equalsIgnoreCase("book")) {
                            System.out.println("Invalid Call Number for type book. Must be B-ddd-ddd-ddd");
                        } else {
                            System.out.println("Fail test");
                        }

                    }
                } catch (InvalidCallNumberException e) {
                    System.out.println(e.getMessage());
                }

            }

        }

    }

    /***
     * removes a title from the overarching list of titles
     * 
     * @param callNumber is the call number provided by the user to search for
     * @param list1      is the array of title entities
     * @return no return value
     */
    public void removeTitle(String callNumber, Title[] list1) {
        int count = 0; // counts up until the index of the title we want to remove
        boolean found = true;
        boolean index = false; // we change this if we actually find a call number to match with the other one
        try {
            if (!callNumber.matches("[B|P]-[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]")) {
                throw new InvalidCallNumberException("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
            }
        } catch (InvalidCallNumberException e) {
            System.out.println(e.getMessage());
            found = false;
        }
        try {
            for (int i = 0; i < list1.length; i++) {
                count++;
                if (list1[i].getCallNumber().equals(callNumber)) {
                    index = true;
                    break;
                }

            }
        } catch (NullPointerException e) {
        }
        if (!index && found) {
            System.out.println("Title not found");
        } else if (index && found) {
            count = count - 1;
            for (count = count; count < size; count++) { // shifts each element down to account for the removed media
                                                         // element
                list1[count] = list1[count + 1];
            }
            size--;
            System.out.println("Media removed successfully");
        } else {

        }
    }

    /**
     * gets the integer value
     * 
     * @param scnr the user input for tax status
     * @return integer corresponding to user menu option
     *         THIS CODE IS FROM MY CALCTAXES
     */
    public int getInt(Scanner scnr) {
        boolean correct;
        int taxStatus = 0;
        do { // do-while loop to get the correct input
            correct = scnr.hasNextInt();
            if (correct == false) {
                System.out.println("Invalid operation. Try again.");
                scnr.nextLine();
            } else {
                taxStatus = scnr.nextInt();
                if (taxStatus < 1 || taxStatus > 9) { // gets the correct range
                    System.out.println("\nInvalid operation. Try again.");
                    correct = false;
                }
                scnr.nextLine();
            }
        } while (!correct);
        return taxStatus;
    }

    /***
     * writes the new title information onto the text file
     * 
     * @param list1 is the list of all the title elements
     * @return no return value
     */
    public void saveFile(Title[] list1) {
        try {
            FileOutputStream fileStream = new FileOutputStream("titles.txt");
            PrintWriter outFS = new PrintWriter(fileStream);
            for (int i = 0; i < size; i++) {
                outFS.print(list1[i].simpleString());
            }
            outFS.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

}
