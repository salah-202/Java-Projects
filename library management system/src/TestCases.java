
public class TestCases {
    public static void main(String[] args) {
        Library l1 = new Library("MQ",1);

        User u1 = new User("Salah");
        User u2 = new User("Ahmed");
        User u3 = new User("Hassan");

        Book b1 = new Book("Hello","Mahmoud","3.1");
        Book b2 = new Book("Queue","Eslam","2.4");
        Book b3 = new Book("Algorithms","Omar","1.2");

        //test add new book using bookid
        l1.addNewBook(b1);

        //test remove book using book id
        l1.removeBook(b1);

        //test borrow book to specific user useong book id and user id
        l1.checkoutBook(1,1);
        l1.checkoutBook(10,10);

        //test return book object using book id
        l1.getBook(1);

        l1.getBook(10);

        //test display avaliable books
        l1.DisplayAvailableBooks();

        //test display borrowed books
        l1.DisplayBorrowedBooks();

        //test display specific book detils using it's id
        l1.displayBookDetails(1);

        l1.displayBookDetails(10);
    }

}