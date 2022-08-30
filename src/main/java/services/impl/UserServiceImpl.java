package services.impl;


import controller.RoleController;
import models.Role;
import models.User;
import repositories.impl.UserRepositoryImpl;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users = UserRepositoryImpl.getUsers();
    RoleController roleController = new RoleController();

    @Override
    public void signIn(String usernameOrEmail, String password) {
        boolean isExistUser = checkExistUser(usernameOrEmail, password);
        if (isExistUser) {
            for (User user : users) {
                if (user.getUsername().equalsIgnoreCase(usernameOrEmail)) {
                    roleController.signIn(user);
                    return;
                }
            }
        } else {
            System.out.println("Username or password is wrong!");
        }
    }

    @Override
    public void signUp(String username, int age, String email, String password, String roleName) {
        boolean isAbsentUser = checkAbsentUser(username, email);
        if (isAbsentUser) {
            roleController.signUp(new User(username, age, email, password, new Role(roleName)));
        }
    }

    // This method checks for existing users
    private boolean checkExistUser(String usernameOrEmail, String password) {
        for (User userItems : users) {
            if ((userItems.getUsername().equalsIgnoreCase(usernameOrEmail)
                    || userItems.getEmail().equalsIgnoreCase(usernameOrEmail))
                    && userItems.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // This method checks for non-existent users
    private boolean checkAbsentUser(String username, String email) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)
                    || user.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }
}