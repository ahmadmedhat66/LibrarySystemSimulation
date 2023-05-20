import java.time.LocalDate;

public class Book {
    private String id;
    private String name;
    private String category;
    private boolean borrowed;
    private LocalDate borrowingDate;
    private LocalDate returnDate;

    public Book(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.borrowed = false;
        this.borrowingDate = null;
        this.returnDate = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void borrowBook(LocalDate returnDate) {
        this.borrowed = true;
        this.borrowingDate = LocalDate.now();
        this.returnDate = returnDate;
    }

    public void returnBook() {
        this.borrowed = false;
        this.borrowingDate = null;
        this.returnDate = null;
    }
}
