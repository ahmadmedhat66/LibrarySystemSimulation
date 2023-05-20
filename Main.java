public class Main {
    public static void main(String[] args) {
        Library library = new Library(10);
        LibraryGui libraryGui = new LibraryGui(library);
        libraryGui.setVisible(true);
    }
}
