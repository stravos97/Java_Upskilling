package exercises.library;

/**
 * Because the library is just handling burrowing and returning books, this makes is a service. e.g. performing an action
 * As we are performing an action on it, we can think of it as a can do relationship. e.g. a SOMETHING can do use a library service to
 * burrow or return a book
 * therefore we make this an interface
 * Interfaces hanve public final fields so it doesn't make sense for it to have an isAvailable field
 * The book itself is responsible for changing its own details. e.g. name isbn etc, we still need to burrow it though and to check if available
 * to check if available we need to use another class responsible for this
 *
 * LibraryService changes only if borrowing rules change
 * a bo
 */
public interface LibraryService {


    boolean borrowBook(String title, String isbn);
    boolean returnBook(String isbn);
    boolean isAvailable(String isbn);


//    private boolean isAvailable;
//
//    public LibraryService() {
//        isAvailable = true;
//    }
//
//    // TODO: Implement borrowBook() method
//    // HINT: If the book is available, set it to unavailable and return true.
//    // If it's not available, return false.
//    public boolean borrowBook() {
//        // Your code here
//        if (isAvailable()) {
//            setAvailable(false);
//            return true;
//        }
//        return false;
//    }
//
//    // TODO: Implement returnBook() method
//    // HINT: Set the book's availability to true
//    public void returnBook() {
//        setAvailable(true);
//    }
//
//    public boolean isAvailable() {
//        return isAvailable;
//    }
//
//    public void setAvailable(boolean available) {
//        isAvailable = available;
//    }


}
