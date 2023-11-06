package src.main;
import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> users = new ArrayList<>();

    public static void addTestUser() {
        User testUser = new User("test", "test", "test", "test", "test");
        users.add(testUser);
        System.out.println("Added test user");
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
