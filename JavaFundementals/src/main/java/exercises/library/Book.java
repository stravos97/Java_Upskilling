//package exercises.library;
//
//public class Book {
//    private String title;
//    private String author;
//    private String isbn;
//    private int publicationYear;
//
//
//    // TODO: Implement constructor
//    // HINT: Initialize all fields. Set isAvailable to true by default.
//
//    public Book(String title, String author, int publicationYear) throws IllegalArgumentException
//    {
//        this(title, author, "", publicationYear);
//        BookStatus bookStatus = new BookStatus(true);
//    }
//
//    public Book(String title, String author, String isbn, int publicationYear) throws IllegalArgumentException {
//        setTitle(title);
//        setAuthor(author);
//        BookStatus bookStatus = new BookStatus(true);
//        this.isbn = isbn;
//        this.publicationYear = publicationYear;
//    }
//
//
//    public boolean findByIsbn(String isbn)
//    {
//
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        if (title == null || title.trim().isEmpty())
//        {
//            throw new IllegalArgumentException("Title must not be null or empty");
//        }
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        if (author == null || author.trim().isEmpty())
//        {
//            throw new IllegalArgumentException("Title must not be null or empty");
//        }
//        this.author = author;
//    }
//
//    public int getPublicationYear() {
//        return publicationYear;
//    }
//
//    public void setPublicationYear(int publicationYear) {
//        this.publicationYear = publicationYear;
//    }
//
//
//    // TODO: Implement getFormattedBookDetails() method
//    // HINT: Return a string in the format: "Title by Author (Year)"
//    public String getFormattedBookDetails() {
//        // Your code here
//        return getTitle() + " by " + getAuthor() + " (" + getPublicationYear() + ")";
//    }
//
//
//}
//
