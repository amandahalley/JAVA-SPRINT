public class Book extends LibraryItem {
    private String Printed= "Printed";
    private String Audio = "Audio";
    private String Electronic = "Electronic";
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
        if (!format.equals(Printed) && !format.equals(Electronic) && !format.equals(Audio)) {
            throw new IllegalArgumentException("Invalid format - Must be Printed, Electronic, or Audio.");
        }
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", format = '" + format + '\''; 
    }
};

