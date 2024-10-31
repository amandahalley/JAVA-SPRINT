package Library;
import People.Author;
import People.Patron;

import java.util.ArrayList;
import java.util.List;

public class Library {
    //Creating lists specifying what objects each list can hold 
    private List <LibraryItem> items = new ArrayList<>(); //List of LibraryItem (Books and Periodicals)
    private List <Author> authors = new ArrayList<>(); //List of Authors 
    private List <Patron> patrons = new ArrayList<>(); //List of Patrons (Students or Employees)


    public Library() { // empty consturctor as lists have already been initialized 
    };


    //Item management methods:
    //Add item - adds item to the collection, if left empty error message occurs.
    public void addItem(LibraryItem item) {
        if (item != null) {
            items.add(item);
        System.out.println("Item: " + item.getTitle() + "has been successfully added to the Library.");        
    } else {
        System.out.println("Can not add item. Please try again.");
        }
    }

   // Method to find an item by its ID within the Library class
    public LibraryItem findItemById(String itemID) {
        for (LibraryItem item : items) {
            if (item.getID().equals(itemID)) {
                return item;
            }
        }
        return null; // Return null if no item is found
    }

   
    //Edit item - updates item existing in collection by matching itemID and updating items attributes
    public boolean editItem(String itemID, LibraryItem updatedItem) {
        for (LibraryItem item : items) {  //cycles through items and finds matching id then updates properties with new details
            if (item.getID().equals(itemID)) { 
                item.setTitle(updatedItem.getTitle());
                item.setAuthor(updatedItem.getAuthor());
                item.setISBN(updatedItem.getISBN());
                item.setPublisher(updatedItem.getPublisher());
                item.setCopies(updatedItem.getCopies());

                System.out.println("Item successfully updated: " + updatedItem.getTitle());
                return true;

            }
        }
        //print statement if itemid is not found
        System.out.println("Item ID: " + itemID + " not found.");
        return false;
    }

    //Delete item from collection
    public boolean deleteItem(String itemID) {
        for (LibraryItem item : items) { //cycles through items finding matching id, if id matches item is removed
            if (item.getID().equals(itemID)) {
                items.remove(item);
                System.out.println("Item successfully deleted: " + item.getTitle());
                return true;
            }
        }
        //print statement if itemid is not found
        System.out.println("Item ID: " + itemID + "not found.");
        return false; 
    }
    
    // Method for a patron to borrow a library item
public boolean borrowItem(String title, String patronName) {
    // Find the item by title
    LibraryItem itemToBorrow = null;
    for (LibraryItem item : items) {
        if (item.getTitle().equalsIgnoreCase(title) && item.getCopies() > 0) {
            itemToBorrow = item;
            break;
        }
    }

    // Check if the item was found and has available copies
    if (itemToBorrow == null) {
        System.out.println("Item not available for borrowing: " + title);
        return false;
    }

    // Find the patron by name
    Patron borrowingPatron = null;
    for (Patron patron : patrons) {
        if (patron.getName().equalsIgnoreCase(patronName)) {
            borrowingPatron = patron;
            break;
        }
    }

    // Check if the patron was found
    if (borrowingPatron == null) {
        System.out.println("Patron not found: " + patronName);
        return false;
    }

    // Update the item copies and add the item to the patron's borrowed list
    itemToBorrow.setCopies(itemToBorrow.getCopies() - 1);
    borrowingPatron.getBorrowedItems().add(itemToBorrow);

    System.out.println("Item '" + title + "' successfully borrowed by " + patronName);
    return true;
}

    // Method for a patron to return a library item
    public boolean returnItem(String title, String patronName) {
        // Find the patron by name
        Patron returningPatron = null;
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(patronName)) {
                returningPatron = patron;
                break;
            }
        }

        // Check if the patron was found
        if (returningPatron == null) {
            System.out.println("Patron not found: " + patronName);
            return false;
        }

        // Find the borrowed item in the patron's list
        LibraryItem itemToReturn = null;
        for (LibraryItem item : returningPatron.getBorrowedItems()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                itemToReturn = item;
                break;
            }
        }

        // Check if the item was found
        if (itemToReturn == null) {
            System.out.println("Item not found in borrowed list: " + title);
            return false;
        }

        // Update the item copies and remove the item from the patron's borrowed list
        itemToReturn.setCopies(itemToReturn.getCopies() + 1);
        returningPatron.getBorrowedItems().remove(itemToReturn);

        System.out.println("Item '" + title + "' successfully returned by " + patronName);
        return true;
    }


    

    //Search methods:
    //Search by title
    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> foundItems = new ArrayList<>(); //create list for matching items
        for (LibraryItem item : items) { //cycle through items
            if(item.getTitle().equalsIgnoreCase(title)) { //check if title matches
                foundItems.add(item); // add item to list
            }
        }
        return foundItems; //return list of found items
    }

    //Search by author
    public List<LibraryItem> searchByAuthor(String authorName) {
        List<LibraryItem> foundItems = new ArrayList<>(); //create list for matching items
        for (LibraryItem item : items) { //cycle through items
            if (item.getAuthor().equalsIgnoreCase(authorName)) { //check for author match
                foundItems.add(item); //add match to list
            }
        }
        return foundItems; //return list of found items
    }

    //Search by ISBN
    public LibraryItem searchByISBN(String isbn) {
        for (LibraryItem item : items) { // cycle through items
            if (item.getISBN().equals(isbn)) { // check if isbn matches
                return item; // return match
            }
        }
        return null; //If no item is found by isbn
    }
    
    // Patron management methods:
    // Add Patron to collection
    public void addPatron(Patron patron) {
    if (patron != null) {
        patrons.add(patron);
        System.out.println("Name successfully added: " + patron.getName());
    } else {
        System.out.println("Could not add name. Please try again.");
    }
}
    
    // Delete patron from collection
    public boolean deletePatron(String patronName) {
        for (Patron patron : patrons) { // Cycle through patrons list to find a matching name
            if (patron.getName().equalsIgnoreCase(patronName)) {
                patrons.remove(patron);
                System.out.println("Patron successfully deleted: " + patron.getName());
                return true;
        }
    }
    // Print statement if the patron is not found
    System.out.println("Patron with name: " + patronName + " not found.");
    return false;
}

    // Author management methods
    // Add author to collection
    public void addAuthor(Author author) {
        if (author != null) {
            authors.add(author);
        System.out.println("Author successfully added: " + author.getName());
        } else {
        System.out.println("Could not add author. Please try again.");
        }
}
    
    // Delete author from collection
    public boolean deleteAuthor(String authorName) {
        for (Author author : authors) { // Cycle through authors list to find a matching name
            if (author.getName().equalsIgnoreCase(authorName)) {
                authors.remove(author);
                System.out.println("Author successfully deleted: " + author.getName());
                return true;
        }
    }
    // Print statement if the author is not found
    System.out.println("Author with name: " + authorName + " not found.");
    return false;
    }


    //A method to list all of the items in the Library
    public void listAllItems() {
        //if there are no items currently in library - print statement saying so
        if (items.isEmpty()) {
            System.out.println("There are no items currently in the Library.");
        } else {
            //Loop through list of all items currently in Library and print them all
            System.out.println("Libary Inventory: ");
            for (LibraryItem item : items) {
                System.out.println(item);
            }
        }
    }
};