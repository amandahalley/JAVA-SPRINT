import Items.Book;
import Items.Periodical;
import Library.LibraryItem;

public class TestLibrary {
    public static void main(String[] args) {
        
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

    };
};



    