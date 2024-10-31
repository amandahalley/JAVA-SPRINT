import java.util.List;
import java.util.Scanner;

import Items.Book;
import Library.Library;
import Library.LibraryItem;
import People.Author;
import People.Patron;

public class LibraryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Predefined data
        initializeLibraryData(library);

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
                    System.out.print("Enter the ID of the library item to edit: ");
                    String editID = scanner.nextLine();

                    // Use the findItemById method in the Library class to find the item
                    LibraryItem itemToEdit = library.findItemById(editID);

                    // Check if the item was found
                    if (itemToEdit != null) {
                        System.out.println("Item found: " + itemToEdit.getTitle());

                        // Display current details and prompt for new values
                        System.out.print("Enter new title (current: " + itemToEdit.getTitle() + "): ");
                        String newTitle = scanner.nextLine();
                        if (!newTitle.isEmpty()) {
                            itemToEdit.setTitle(newTitle);
                        }

                        System.out.print("Enter new author (current: " + itemToEdit.getAuthor() + "): ");
                        String newAuthor = scanner.nextLine();
                        if (!newAuthor.isEmpty()) {
                            itemToEdit.setAuthor(newAuthor);
                        }

                        System.out.print("Enter new ISBN (current: " + itemToEdit.getISBN() + "): ");
                        String newISBN = scanner.nextLine();
                        if (!newISBN.isEmpty()) {
                            itemToEdit.setISBN(newISBN);
                        }

                        System.out.print("Enter new publisher (current: " + itemToEdit.getPublisher() + "): ");
                        String newPublisher = scanner.nextLine();
                        if (!newPublisher.isEmpty()) {
                            itemToEdit.setPublisher(newPublisher);
                        }

                        System.out.print("Enter new total copies (current: " + itemToEdit.getCopies() + "): ");
                        String newCopiesStr = scanner.nextLine();
                        if (!newCopiesStr.isEmpty()) {
                            int newCopies = Integer.parseInt(newCopiesStr);
                            itemToEdit.setCopies(newCopies);
                        }

                        System.out.println("Library item updated successfully!");
                    } else {
                        System.out.println("Item with ID " + editID + " not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter the ID of the library item to delete: ");
                    String deleteItemID = scanner.nextLine();
                    if (library.deleteItem(deleteItemID)) {
                        System.out.println("Library item deleted successfully.");
                    } else {
                        System.out.println("Library item with ID " + deleteItemID + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the item to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.print("Enter the name of the patron borrowing the item: ");
                    String patronName = scanner.nextLine();
                    library.borrowItem(borrowTitle, patronName);
                    break;

                case 5:
                    System.out.print("Enter the title of the item to return: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Enter the name of the patron returning the item: ");
                    String returnPatronName = scanner.nextLine();
                    library.returnItem(returnTitle, returnPatronName);
                    break;
                case 6:
                    library.listAllItems();
                    break;
                case 7:
                    System.out.print("Enter the title of the library item to search for: ");
                    String searchTitle = scanner.nextLine();
                    List<LibraryItem> itemsByTitle = library.searchByTitle(searchTitle);
                    if (itemsByTitle.isEmpty()) {
                        System.out.println("No items found with the title: " + searchTitle);
                    } else {
                        System.out.println("Items found:");
                        for (LibraryItem item : itemsByTitle) {
                            System.out.println(item);
                        }
                    }
                    break;
                case 8:
                    System.out.print("Enter the author name to search for: ");
                    String searchAuthor = scanner.nextLine();
                    List<LibraryItem> itemsByAuthor = library.searchByAuthor(searchAuthor);
                    if (itemsByAuthor.isEmpty()) {
                        System.out.println("No items found for author: " + searchAuthor);
                    } else {
                        System.out.println("Items found:");
                        for (LibraryItem item : itemsByAuthor) {
                            System.out.println(item);
                        }
                    }
                    break;
                case 9:
                    System.out.print("Enter the ISBN of the library item to search for: ");
                    String searchISBN = scanner.nextLine();
                    LibraryItem itemByISBN = library.searchByISBN(searchISBN);
                    if (itemByISBN != null) {
                        System.out.println("Item found: " + itemByISBN);
                    } else {
                        System.out.println("No item found with ISBN: " + searchISBN);
                    }
                    break;
                case 10:
                    System.out.print("Enter the name of the patron: ");
                    String patronToList = scanner.nextLine();
                    Patron foundPatron = library.findPatronByName(patronToList);
                    if (foundPatron != null) {
                        System.out.println("Borrowed items for " + patronToList + ":");
                        List<LibraryItem> borrowedItems = foundPatron.getBorrowedItems();
                        if (borrowedItems.isEmpty()) {
                            System.out.println("No items borrowed.");
                        } else {
                            for (LibraryItem borrowedItem : borrowedItems) {
                                System.out.println(borrowedItem);
                            }
                        }
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;
                case 11:
                    System.out.print("Enter the name of the author: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter the date of birth of the author: ");
                    String authorDOB = scanner.nextLine();
                    Author newAuthor = new Author(authorName, authorDOB);
                    library.addAuthor(newAuthor);
                    break;
                case 12:
                    System.out.print("Enter the name of the author to edit: ");
                    String editAuthorName = scanner.nextLine();
                    Author authorToEdit = library.findAuthorByName(editAuthorName);
                    if (authorToEdit != null) {
                        System.out.print("Enter new name (current: " + authorToEdit.getName() + "): ");
                        String newAuthorName = scanner.nextLine();
                        if (!newAuthorName.isEmpty()) {
                            authorToEdit.setName(newAuthorName);
                        }
                        System.out.print("Enter new date of birth (current: " + authorToEdit.getDateOfBirth() + "): ");
                        String newDOB = scanner.nextLine();
                        if (!newDOB.isEmpty()) {
                            authorToEdit.setDateOfBirth(newDOB);
                        }
                        System.out.println("Author updated successfully.");
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case 13:
                    System.out.print("Enter the name of the author to delete: ");
                    String deleteAuthorName = scanner.nextLine();
                    if (library.deleteAuthor(deleteAuthorName)) {
                        System.out.println("Author deleted successfully.");
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case 14:
                    System.out.print("Enter the name of the patron: ");
                    String inputPatronName = scanner.nextLine();
                    System.out.print("Enter the address of the patron: ");
                    String inputPatronAddress = scanner.nextLine();
                    System.out.print("Enter the phone number of the patron: ");
                    String inputPatronPhone = scanner.nextLine();
                    Patron newPatron = new Patron(inputPatronName, inputPatronAddress, inputPatronPhone);
                    library.addPatron(newPatron);
                    break;
                case 15:
                    System.out.print("Enter the name of the patron to edit: ");
                    String editPatronName = scanner.nextLine();
                    Patron patronToEdit = library.findPatronByName(editPatronName);
                    if (patronToEdit != null) {
                        System.out.print("Enter new name (current: " + patronToEdit.getName() + "): ");
                        String newPatronName = scanner.nextLine();
                        if (!newPatronName.isEmpty()) {
                            patronToEdit.setName(newPatronName);
                        }
                        System.out.print("Enter new address (current: " + patronToEdit.getAddress() + "): ");
                        String newAddress = scanner.nextLine();
                        if (!newAddress.isEmpty()) {
                            patronToEdit.setAddress(newAddress);
                        }
                        System.out.print("Enter new phone number (current: " + patronToEdit.getPhoneNumber() + "): ");
                        String newPhone = scanner.nextLine();
                        if (!newPhone.isEmpty()) {
                            patronToEdit.setPhoneNumber(newPhone);
                        }
                        System.out.println("Patron updated successfully.");
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;
                case 16:
                    System.out.print("Enter the name of the patron to delete: ");
                    String deletePatronName = scanner.nextLine();
                    if (library.deletePatron(deletePatronName)) {
                        System.out.println("Patron deleted successfully.");
                    } else {
                        System.out.println("Patron not found.");
                    }
                    break;
                case 17:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return; // Exit the program

            }
        } while (choice != 17);

        scanner.close();
    }

    private static void initializeLibraryData(Library library) {
        // Create and add some library items
        LibraryItem item1 = new Book("1", "Effective Java", "Joshua Bloch", "9780134686097", "Addison-Wesley", 5, "Printed");
        LibraryItem item2 = new Book("2", "Clean Code", "Robert C. Martin", "9780136083238", "Prentice Hall", 3, "Electronic");
        library.addItem(item1);
        library.addItem(item2);

        // Create and add some authors
        Author author1 = new Author("Joshua Bloch", "1961-08-28");
        Author author2 = new Author("Robert C. Martin", "1952-12-05");
        library.addAuthor(author1);
        library.addAuthor(author2);

        // Create and add some patrons
        Patron patron1 = new Patron("Alice Smith", "123 Main St", "555-1234");
        Patron patron2 = new Patron("Bob Johnson", "456 Elm St", "555-5678");
        library.addPatron(patron1);
        library.addPatron(patron2);
    }
}
