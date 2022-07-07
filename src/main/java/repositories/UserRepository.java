package repositories;

import models.Role;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> users = new ArrayList<>();
    public static List<Role> roles = new ArrayList<>();
    public static void getAllUsers() {
        users.add(new User(
                "AsadbekTursunali",
                22,
                "AsadbekTursunali@gmail.com",
                "password",
                roles.get(1)
        ));
    }
}
