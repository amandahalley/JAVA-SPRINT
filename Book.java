public class Book extends LibraryItem {
    private String Printed= "Printed";
    private String Audio = "Audio";
    private String Electronic = "Electronic";

    private String format;

    //Constructor 
    public Book(String ID, String title, String author, String isbn, String publisher, int copies, String format) {
        //Calling constructor of LibraryItem (superclass) and setting format of book
        super(ID, title, author, isbn, publisher, copies);
        setFormat(format);
    }

    public String getFormat() {
        return format;
    }


    //set format wit validation
    public void setFormat(String format) {
        if (format.equals(Printed) || format.equals(Audio) || format.equals(Electronic)) {
            this.format = format;
        } else {
            throw new IllegalArgumentException("Invalid format, must be Printed, Audio or Electronic. ");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", format='" + format; 
    }


}

