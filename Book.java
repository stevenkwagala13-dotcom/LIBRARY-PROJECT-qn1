
package steven.communitylibrarysystem;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    // Constructor 1
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = "Unknown";
        this.available = true;
    }

    // Constructor 2 (overloaded)
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return isbn + " - " + title + " by " + author +
                " | Available: " + available;
    }
}
