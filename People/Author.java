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

    public String getDateOfBirth() {
        return birthday;
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
}