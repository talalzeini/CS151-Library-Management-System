package src.main;
import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
