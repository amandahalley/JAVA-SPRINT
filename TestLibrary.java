import java.util.List;

import Items.Book;
import Items.Periodical;
import People.Author;
import People.Patron;
import Library.LibraryItem;
import Library.Library;

public class TestLibrary {
    public static void main(String[] args) {
        
        Library library = new Library();

        //Testing for constructor and toString method 
        LibraryItem item = new LibraryItem("1", "Book Title", "Amanda Halley", "9780134685991", "John Doe", 3);

        System.out.println();
        System.out.println("Library Item Details:");
        System.out.println(item);
    
        //Testing valid book creating for book class
        try {
            Book valid = new Book("2", "Book 2", "Jane Smith", "9780134123948", "John Doe", 2, "Audio");
            System.out.println();
            System.out.println("Valid book created");
            System.out.println(valid);
        } catch (IllegalArgumentException e)  {
            System.out.println("Test failed: " + e.getMessage());
        }

        //Testing invalid creation for Periodical  class   
        try {
            Periodical invalid = new Periodical("3", "Book 3", "John Doe", "9780134123394", "Jane Smith", 4, "Digital");
            System.out.println();
            System.out.println("Valid periodical created");
            System.out.println(invalid);
        } catch (IllegalArgumentException e) {
            System.out.println("Test failed" + e.getMessage()); //should catch error s
        }

        //Testing addWrittenItem method from Author class
        Author author = new Author("Tyler Wall", "February 14, 1998");
        LibraryItem writtenItem = new LibraryItem("4", "BFG", "Tyler Wall", "1780134124494", "John Doe", 9);

        author.addWrittenItem(writtenItem);
        List<LibraryItem> writtenItems = author.getWrittenItems();

        System.out.println();
        System.out.println("Author's written items after adding one item:");
        System.out.println(writtenItems);

        // Testing Patron class
        Patron patron = new Patron("Ryan Tibbo", "123 Fourth Street", "234-5678");

        System.out.println();
        System.out.println("Patron Details:");
        System.out.println(patron);

        //Testing addItem method
        System.out.println();
        library.addItem(item);
        library.addItem(writtenItem);
        
        //Testing editItem method
        LibraryItem updatedItem = new LibraryItem("1", "Updated Title", "Amanda Halley", "9780134685991", "John Doe", 5);
        boolean editResult = library.editItem("1", updatedItem);
        System.out.println("Edit successful: " + editResult);

        //Testing deleteItem method 
        boolean deleteResult = library.deleteItem("1");
        System.out.println("Delete successful: " + deleteResult);
        
    };
};



    