import java.util.ArrayList;

public class Library {
    private String libraryName;
    private int libraryCode;
    private ArrayList<Book> booksList = new ArrayList<>();


    Library(String libraryName, int libraryCode) {
        this.libraryName = libraryName;
        this.libraryCode = libraryCode;
    }

    //add new book to library system
    public void addNewBook(Book book) {
        boolean found = false;
        //loop through books if found the book return error message if not found add it
        for (Book bookList : booksList) {
            if (bookList.getBookID() == book.getBookID()) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Error..This book in library");
        } else {
            booksList.add(book);
            System.out.println("The "+book.getBookTitle()+" added successfully to library");
            //set bookAvailability so users can borrow it
            book.setBookAvailability(true);
        }
    }

    //remove book from library system
    public void removeBook(Book book) {
        boolean found = false;
        //loop through books if found the book remove it if not found return error message
        for (Book bookList : booksList) {
            if (bookList.getBookID() == book.getBookID()) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The "+book.getBookTitle()+" removed successfully from library");
            booksList.remove(book);
        } else {
            System.out.println("Error..This book not in library");
        }
    }

    //this method checkout book to user from library system
    public void checkoutBook(int bookId,int userId) {
        //first Check if there is user with ID
        if(User.getCountUsers() <= userId){
            //loop through books to check if there is a book with this ID
            for (Book bookList : booksList) {
                if (bookList.getBookID() == bookId) {
                    //check if this book is available to be borrowed
                    if(bookList.getBookAvailability()){
                        bookList.setBookAvailability(false);
                        System.out.println("The "+bookList.getBookTitle()+" is borrowed successfully");
                    }else {
                        System.out.println("This Book is not valid to borrowed now");
                    }

                    break;

                }else {
                    System.out.println("Invalid Book ID");
                }
            }

        }else {
            System.out.println("Invalid User ID");
        }
      }

    //this method return book from books list giving it's id

    public Book getBook(int bookId) {

        for (Book bookList : booksList) {
            if (bookList.getBookID() == bookId) {
                return bookList;
            }
        }
        return null;
    }

    //this method return the books available in library system
    public void DisplayAvailableBooks() {
        for (Book book:this.booksList) {
            if(book.getBookAvailability()){
                System.out.println("Book ID: "+ book.getBookID());
                System.out.println("Book Title: "+ book.getBookTitle());
                System.out.println("___________________________________");
            }
        }
    }

    //this method return the books borrowed from library system
    public void DisplayBorrowedBooks() {
        for (Book book:this.booksList) {
            if(!book.getBookAvailability()){
                System.out.println("Book ID: "+ book.getBookID());
                System.out.println("Book Title: "+ book.getBookTitle());
                System.out.println("___________________________________");
            }
        }
    }

    //this method return book book details giving its ID
    public void displayBookDetails(int bookId){
        boolean found = false;
        for (Book bookList : booksList) {
            if (bookList.getBookID() == bookId) {
                System.out.println("Book ID: "+ bookId);
                System.out.println("Book Title: "+ bookList.getBookTitle());
                System.out.println("Book author name: "+ bookList.getAuthorName());
                System.out.println("Book version: "+ bookList.getBookVersion());
                System.out.println("Is Book available ?: "+ bookList.getBookAvailability());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("There's no book with this ID .. please Enter a valid ID");
        }
    }


}