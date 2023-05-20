import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGui extends JFrame implements ActionListener {
    private Library library;

    private JButton addBookButton;
    private JButton removeBookButton;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton viewStatusButton;

    private String[] categories = {"Biology", "Maths", "History", "Chemistry", "Politics"};

    public LibraryGui(Library library) {
        this.library = library;

        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        addBookButton = new JButton("Add Book");
        removeBookButton = new JButton("Remove Book");
        borrowBookButton = new JButton("Borrow Book");
        returnBookButton = new JButton("Return Book");
        viewStatusButton = new JButton("View Library Status");

        addBookButton.addActionListener(this);
        removeBookButton.addActionListener(this);
        borrowBookButton.addActionListener(this);
        returnBookButton.addActionListener(this);
        viewStatusButton.addActionListener(this);

        panel.add(addBookButton);
        panel.add(removeBookButton);
        panel.add(borrowBookButton);
        panel.add(returnBookButton);
        panel.add(viewStatusButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton) {
            String bookId = JOptionPane.showInputDialog(this, "Enter Book ID:");
            String bookName = JOptionPane.showInputDialog(this, "Enter Book Name:");
            String category = (String) JOptionPane.showInputDialog(this, "Select Book Category:",
                    "Choose Category", JOptionPane.QUESTION_MESSAGE, null, categories, categories[0]);

            Book book = new Book(bookId, bookName, category);
            boolean added = library.addBook(book);

            if (added) {
                JOptionPane.showMessageDialog(this, "Book added successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add book.");
            }
        } else if (e.getSource() == removeBookButton) {
            String bookId = JOptionPane.showInputDialog(this, "Enter Book ID:");

            boolean removed = library.removeBook(bookId);

            if (removed) {
                JOptionPane.showMessageDialog(this, "Book removed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove book.");
            }
        } else if (e.getSource() == borrowBookButton) {
            String bookId = JOptionPane.showInputDialog(this, "Enter Book ID:");
            String borrowingPeriodStr = JOptionPane.showInputDialog(this, "Enter Borrowing Period (in days):");
            int borrowingPeriod = Integer.parseInt(borrowingPeriodStr);

            boolean borrowed = library.borrowBook(bookId, borrowingPeriod);

            if (borrowed) {
                JOptionPane.showMessageDialog(this, "Book borrowed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to borrow book.");
            }
        } else if (e.getSource() == returnBookButton) {
            String bookId = JOptionPane.showInputDialog(this, "Enter Book ID:");

            boolean returned = library.returnBook(bookId);

            if (returned) {
                JOptionPane.showMessageDialog(this, "Book returned successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to return book.");
            }
        } else if (e.getSource() == viewStatusButton) {
            String status = library.viewLibraryStatus();
            JOptionPane.showMessageDialog(this, status);
        }
    }

    public void displayLibraryGui() {
        setVisible(true);
    }

    public static void main(String[] args) {
        int libraryCapacity = 10; // Specify the desired library capacity
        Library library = new Library(libraryCapacity);
        LibraryGui libraryGui = new LibraryGui(library);
        libraryGui.displayLibraryGui();
    }
}
