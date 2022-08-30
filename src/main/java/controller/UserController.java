package controller;

import repositories.impl.RoleRepositoryImpl;
import repositories.impl.UserRepositoryImpl;
import services.UserService;
import services.impl.UserServiceImpl;

import java.util.Scanner;

public class UserController {

    UserService userService = new UserServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void register() {
        UserRepositoryImpl.save();
        RoleRepositoryImpl.save();

        while (true) {
            System.out.println("1 -> Login\n2 -> Sign up\n0 -> Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Username or email: ");
                    String usernameOrEmail = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();
                    userService.signIn(usernameOrEmail, password);
                }
                case 2 -> {
                    System.out.print("Username: ");
                    String username = scanner.next();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();
                    System.out.print("Roles=(Teacher or Student)\nSelect one of the roles: ");
                    String roleName = scanner.next();
                    userService.signUp(username, age, email, password, roleName);
                }
                case 0 -> {
                    return;
                }
            }
        }
    }
}