public class Book {
    private String bookTitle;
    private String authorName;
    private int bookID;
    private String bookVersion;
    private boolean bookAvailability;
    //this attribute to count books and set bookID automatic when creating a new book object
    private static int booksCount = 0;

    Book(String bookTitle,String authorName,String bookVersion){
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        booksCount++;
        this.bookID = booksCount;
        this.bookVersion = bookVersion;

    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookVersion() {
        return bookVersion;
    }

    public boolean getBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(boolean bookAvailability) {
        this.bookAvailability = bookAvailability;
    }
}
