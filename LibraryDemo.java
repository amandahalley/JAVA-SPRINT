import java.util.List;
import java.util.Scanner;

import Library.Library;
import Library.LibraryItem;
import People.Patron;

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





            }
        } while (choice != 17);

        scanner.close();
    }
}
