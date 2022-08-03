package services.impl;


import controller.RoleController;
import models.Role;
import models.User;
import repositories.impl.RoleRepositoryImpl;
import repositories.impl.UserRepositoryImpl;
import services.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    List<User> users = UserRepositoryImpl.getUsers();
    List<Role> roles = RoleRepositoryImpl.getRoles();
    RoleController roleController = new RoleController();

    @Override
    public void signIn(String usernameOrEmail, String password) {
        boolean isExistUser = checkExistUser(usernameOrEmail, password);
        if (isExistUser) {
            for (User user : users) {
                if (usernameOrEmail.equalsIgnoreCase(user.getUsername())) {
                    roleController.homePage(user);
                }
            }
        }
        else {
            System.out.println("Username or password is wrong!");
        }
    }

    @Override
    public void signUp(String username, int age, String email, String password, String roleName) {
        boolean isExistRole = checkExistRole(roleName);
        if (isExistRole) {
            boolean isExistUser = checkExistUser(username, email, password);
            if (!isExistUser) {
                roleController.homePage(new User(username, age, email, password, new Role(roleName)));
            }
            else {
                System.out.println("A user by this name exist!");
            }
        }
        else {
            System.out.println("This role doesn't exist!");
        }
    }

    // Checking users
    private boolean checkExistUser(String username, String email, String password) {
        for (User user : users) {
            if (username.equalsIgnoreCase(user.getUsername())
                    || email.equalsIgnoreCase(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    // Checking users
    private boolean checkExistUser(String usernameOrEmail, String password) {
        for (User user : users) {
            if (usernameOrEmail.equalsIgnoreCase(user.getUsername())
                    || usernameOrEmail.equalsIgnoreCase(user.getEmail())
                    && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //Checking roles
    private boolean checkExistRole(String roleName) {
        for (Role role : roles) {
            if (roleName.equalsIgnoreCase(role.getName())) {
                return true;
            }
        }
        return false;
    }
}