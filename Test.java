/***
 * Class to test the entities
 * @author Samir Hassan
 * @version 0.1
 * Date of creation: February 21, 2022
 * Last Date Modified: February 27, 2022
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Title[] titlesList = new Title[500]; // creates the array media
        Scanner scnr = new Scanner(System.in); // Scanner object
        Catalog catalog1 = new Catalog(); //creates the catalog object needed to access methods

        try { //opens the file and sets up the titles list array
            FileInputStream fileByteStream = new FileInputStream("titles.txt");
            Scanner inFS = new Scanner(fileByteStream);
            catalog1.splitText(inFS, titlesList);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // create a menu that the user can use to carry out different operations within
        boolean correct = false;
        do {
            System.out.println();
            System.out.println("Select an operation");
            System.out.println("1: View all titles");
            System.out.println("2: Search by call number");
            System.out.println("3: Search by title");
            System.out.println("4: Search by year");
            System.out.println("5: Add a new title");
            System.out.println("6: Remove title");
            System.out.println("7: Sort titles by year");
            System.out.println("8. View titles due for restoration");
            System.out.println("9: Exit");
            int userInt = catalog1.getInt(scnr);
            System.out.println();

            if (userInt == 1) {// prints the titles for the user to view all titles
                catalog1.printTitles(titlesList);
            }
            if (userInt == 2) {// searches the list of titles for a user entered call number
                System.out.println("Enter a call number: ");
                String callNumber = scnr.nextLine();
                catalog1.searchCallNumber(callNumber, titlesList);
            }
            if (userInt == 3) {// searches the list of titles for a user entered title
                System.out.println("Enter a title: ");
                String title = scnr.nextLine();
                catalog1.searchTitle(title, titlesList);
            }
            if (userInt == 4) {// searches the list of titles for a user entered year
                System.out.println("Enter a year: ");
                int year = scnr.nextInt();
                catalog1.searchYear(year, titlesList);

            }
            if (userInt == 5) {// adds a new title to the list after asking user for input
                catalog1.addNewTitle(scnr, titlesList);
            }
            if (userInt == 6) {// removes a title from the list after asking user for a call number
                System.out.println("Enter the call number (B-ddd-ddd-ddd or P-ddd-ddd-ddd):");
                String callNumber1 = scnr.nextLine();
                catalog1.removeTitle(callNumber1, titlesList);
            }

            if (userInt == 7) {// sort titles by year
                catalog1.sortTitles(titlesList);
                catalog1.printTitles(titlesList);
            }

            if (userInt == 8) {// view all the titles due for restoration
                catalog1.viewRestoredTitles(titlesList);
            }
            if (userInt == 9) {// saves the new title array onto the text file
                catalog1.saveFile(titlesList);
                correct = true;
            }
        } while (!correct);
    }

}
