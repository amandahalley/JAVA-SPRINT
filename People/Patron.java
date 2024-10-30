package People;

import Library.LibraryItem;
import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<LibraryItem> getBorrowedItems() { return borrowedItems; }
  
  
    public void borrowItem(LibraryItem item) {
        if (item.getCopies() > 0) {
            borrowedItems.add(item);
            item.setCopies(item.getCopies() - 1);
            System.out.println(name + " borrowed " + item.getTitle());
        } else {
            System.out.println("Item is not available.");
        }
    }

    public void returnItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            item.setCopies(item.getCopies() + 1);
            System.out.println(name + " returned " + item.getTitle());
        } else {
            System.out.println("This item was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return "Patron: " + name + ", Address: " + address + ", Phone: " + phoneNumber + ", Items Borrowed: " + borrowedItems.size();
    }   
}