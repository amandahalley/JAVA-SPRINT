package Library;
//Creating class for library items
public class LibraryItem {
 private String id;
 private String title;
 private String author;
 private String isbn;
 private String publisher;
 private int copies;

 //Constructor 
 public LibraryItem(String id, String title, String author, String isbn, String publisher, int copies) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publisher = publisher;
    this.copies = copies;
 }

 //Getters and Setters

 //ID
 public String getID() {
    return id;
 }

 public void setID(String id) {
    this.id = id;
 }

 //Title
 public String getTitle() {
    return title;
 }

 public void setTitle(String title) {
    this.title = title;
 }

 //Author
 public String getAuthor() {
    return author;
 }

 public void setAuthor(String author) {
    this.author = author;
 }

 //ISBN
 public String getISBN() {
    return isbn;
 }

 public void setISBN(String isbn) {
    this.isbn = isbn;
 }

 //Publisher
 public String getPublisher() {
    return publisher;
 }

 public void setPublisher(String publisher) {
    this.publisher = publisher;
 }

//Copies
public int getCopies() {
    return copies;
}

public void setCopies(int copies) {
    this.copies = copies;
}

 //Print format for Library items details
 public String toString() {
    return      "ID ='" + id + '\'' +
                ", title ='" + title + '\'' +
                ", author ='" + author + '\'' +
                ", ISBN ='" + isbn + '\'' +
                ", publisher ='" + publisher + '\'' +
                ", numberOfCopies =" + copies;
 }
}