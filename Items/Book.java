package Items;
import Library.LibraryItem;

public class Book extends LibraryItem {
    public static String Printed= "Printed";
    public static String Audio = "Audio";
    public static String Electronic = "Electronic";
    private String format;

    //Constructor 
    public Book(String id, String title, String author, String isbn, String publisher, int copies, String format) {
        //Calling constructor of LibraryItem (superclass) and setting format of book
        super(id, title, author, isbn, publisher, copies);
        setFormat(format);
    }

    public String getFormat() {
        return format;
    }

    //set format wit validation
    public void setFormat(String format) {
        if (format == null) {
            throw new IllegalArgumentException("Format cannot be null");
        }
        if (format.equals(Printed) || format.equals(Audio) || format.equals(Electronic)) {
            this.format = format;
        } else {
            throw new IllegalArgumentException("Invalid book format: " + format);
        }};

    @Override
    public String toString() {
        return super.toString() + ", format = '" + format + '\''; 
    }};

