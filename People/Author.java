// Midterm Sprint - 2024
// Authors - Ryan Tibbo, Tyler Wall, Amanda Halley
package People;

import Library.LibraryItem;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String birthday;
    private List<LibraryItem> items;

    public Author(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return birthday;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.birthday = dateOfBirth;
    }

    public List<LibraryItem> getWrittenItems() {
        return items;
    }

    public void addWrittenItem(LibraryItem item) {
        items.add(item);
    }

    public void removeWrittenItem(LibraryItem item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder itemsList = new StringBuilder();
        for (LibraryItem item : items) {
            itemsList.append(item.toString()).append(", ");
        }
        
        if (itemsList.length() > 0) {
            itemsList.setLength(itemsList.length() - 2);
        }

        return "Author{" +
               "name='" + name + '\'' +
               ", birthday='" + birthday + '\'' +
               ", writtenItems=[" + itemsList.toString() + "]" +
               '}';
    }
}