import java.util.ArrayList;
import java.util.List;



public class Library {
    private int capacity;
    private List<Book> books;

    public Library(int capacity) {
        this.capacity = capacity;
        this.books = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            System.out.println("Error: Invalid book object.");
            return false;
        }
        if (books.size() >= capacity) {
            System.out.println("Error: The library is full, cannot add more books.");
            return false;
        }
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                System.out.println("Error: A book with the same ID already exists in the library.");
                return false;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
        return true;
    }

    public boolean removeBook(String bookId) {
        if (bookId == null || bookId.isEmpty()) {
            System.out.println("Error: Invalid book ID.");
            return false;
        }
        for (Book b : books) {
            if (b.getId().equals(bookId)) {
                if (b.isBorrowed()) {
                    System.out.println("Error: The book is currently borrowed, cannot remove it.");
                    return false;
                } else {
                    books.remove(b);
                    System.out.println("Book removed successfully.");
                    return true;
                }
            }
        }
        System.out.println("Error: Book with the given ID not found in the library.");
        return false;
    }

public boolean borrowBook(String bookID, int borrowingPeriod) {
    if (bookID == null || bookID.isEmpty()) {
        System.out.println("Error: Invalid book ID.");
        return false;
    }
    if (borrowingPeriod <= 0) {
        System.out.println("Error: Invalid borrowing period.");
        return false;
    }
    // Borrow a book if it is not currently borrowed
    for (Book b : books) {
        if (b.getId().equals(bookID)) {
            // The book is in the library
            if (b.isBorrowed()) {
                // The book is currently borrowed, cannot borrow
                System.out.println("Error: The book is currently borrowed, cannot borrow it.");
                return false;
            } else {
                // The book is not currently borrowed, borrow it
                b.borrowBook(null);
                System.out.println("Book borrowed successfully.");
                return true;
            }
        }
    }
    System.out.println("Error: Book with the given ID not found in the library.");
    return false; // Book with the given ID not found in the library
}


    public boolean returnBook(String bookId) {
        if (bookId == null || bookId.isEmpty()) {
            System.out.println("Error: Invalid book ID.");
            return false;
        }
        for (Book b : books) {
            if (b.getId().equals(bookId)) {
                if (b.isBorrowed()) {
                    b.returnBook();
                    System.out.println("Book returned successfully.");
                    return true;
                } else {
                    System.out.println("Error: The book is not currently borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Error: Book with the given ID not found in the library.");
        return false;
    }

   public String viewLibraryStatus() {
    StringBuilder status = new StringBuilder();
    if (books.isEmpty()) {
        status.append("The library is empty.");
    } else {
        status.append("Library Status:\n");
        for (Book b : books) {
            status.append("Book ID: ").append(b.getId()).append("\n");
            status.append("Book Name: ").append(b.getName()).append("\n");
            status.append("Category: ").append(b.getCategory()).append("\n");
            status.append("Borrowed: ").append(b.isBorrowed() ? "Yes" : "No").append("\n");
            if (b.isBorrowed()) {
                status.append("Borrowing Date: ").append(b.getBorrowingDate()).append("\n");
                status.append("Return Date: ").append(b.getReturnDate()).append("\n");
            }
            status.append("------\n");
        }

        // Count book categories and borrowed books
        int totalBorrowedBooks = 0;
        int biologyCount = 0;
        int mathsCount = 0;
        int historyCount = 0;
        int chemistryCount = 0;
        int politicsCount = 0;

        for (Book b : books) {
            if (b.isBorrowed()) {
                totalBorrowedBooks++;
            }

            switch (b.getCategory()) {
                case "Biology":
                    biologyCount++;
                    break;
                case "Maths":
                    mathsCount++;
                    break;
                case "History":
                    historyCount++;
                    break;
                case "Chemistry":
                    chemistryCount++;
                    break;
                case "Politics":
                    politicsCount++;
                    break;
            }
        }

        status.append("Total Borrowed Books: ").append(totalBorrowedBooks).append("\n");
        status.append("Biology Books Count: ").append(biologyCount).append("\n");
        status.append("Maths Books Count: ").append(mathsCount).append("\n");
        status.append("History Books Count: ").append(historyCount).append("\n");
        status.append("Chemistry Books Count: ").append(chemistryCount).append("\n");
        status.append("Politics Books Count: ").append(politicsCount).append("\n");
    }
    return status.toString();

 }

public boolean borrowBook(String bookId) {
    return false;
}
}
