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


    //Item management methods
    //Add item - adds item to the collection, if left empty error message occurs.
    public void addItem(LibraryItem item) {
        if (item != null) {
            items.add(item);
        System.out.println("Item succesfully added: " + item.getTitle());        
    } else {
        System.out.println("Can not add item. Please try again.");
        }
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
            if (item.getID().equals(item)) {
                items.remove(item);
                System.out.println("Item successfully deleted: " + item.getTitle());
                return true;
            }
        }
        //print statement if itemid is not found
        System.out.println("Item ID: " + itemID + "not found.");
        return false; 
    }
    // Patron management methods
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





};