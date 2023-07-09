import java.util.ArrayList;

public class User {
    private String userName;
    private int userID;
    private ArrayList <Book> borrowedBooks;
    private static int countUsers = 0;

    User(String userName){
        this.userName = userName;
        countUsers++;
        this.userID = countUsers;
    }


    //to use it to check if there is a userid in this range or not in Library class
    public static int getCountUsers() {
        return countUsers;
    }
}

