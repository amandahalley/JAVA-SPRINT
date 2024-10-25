public class Periodical extends LibraryItem {
    private String Printed = "Printed";
    private String Electronic = "Electronic";
    private String format;

    //Constructor 
   public Periodical(String id, String title, String author, String isbn, String publisher, int copies, String format) {
    //Calling libraryItem constructor (superclass) and setting format
    super(id, title, author, isbn, publisher, copies);
    setFormat(format);

   }

   public String getFormat() {
    return format();
   }

}
