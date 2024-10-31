import java.util.Scanner;

import Library.Library;
import Library.LibraryItem;

public class LibraryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("Welcome to the Library Management System");
            // there are more options needed for the project.
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. List all Library Items");
            System.out.println("7. Search Library Item by Title");
            System.out.println("8. Search Library Item by Author");
            System.out.println("9. Search Library Item by ISBN");
            System.out.println("10. List all Borrowed Items for a Patron");
            System.out.println("11. Add Author");
            System.out.println("12. Edit Author");
            System.out.println("13. Delete Author");
            System.out.println("14. Add Patron");
            System.out.println("15. Edit Patron");
            System.out.println("16. Delete Patron");


            System.out.println("17. Exit");
            System.out.print("Enter your choice (1-17): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new library item...");
                    // Add logic to add a library item
                    System.out.println("Enter ID: ");
                    String ID = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter total copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();
                    LibraryItem libraryItem = new LibraryItem(ID, title, author, ISBN, publisher, copies);
                    library.addItem(libraryItem);
                    
                    break;
                case 2:
                    System.out.println("Editing an existing library item...");
                    // Add logic to edit a library item
                    break;
                case 3:
                    System.out.println("Deleting a library item...");
                    // Add logic to delete a library item
                    break;
                case 4:
                    System.out.println("Borrowing a library item...");
                    // Add logic to borrow a library item
                    break;
                case 5:
                    System.out.println("Returning a library item...");
                    // Add logic to return a library item
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
