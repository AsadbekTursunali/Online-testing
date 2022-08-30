package repositories.impl;

import models.Role;
import models.User;
import repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public static List<User> users = new LinkedList<>();

    public static void save() {
        users.add(new User(
                "Admin",
                18,
                "Admin@gmail.com",
                "password",
                new Role("admin")));

        users.add(new User(
                "AsadbekTursunali",
                22,
                "AsadbekTursunali@gmail.com",
                "Password",
                new Role("student"))
        );

    }

    @Override
    public void add(String username, Integer age, String email, String password, Role role) {
        users.add(new User(username, age, email, password, role));
    }

    public static List<User> getUsers() {
        return users;
    }
}