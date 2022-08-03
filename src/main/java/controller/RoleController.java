package controller;

import models.User;
import repositories.impl.UserRepositoryImpl;
import services.impl.RoleServiceImpl;

import java.util.List;
import java.util.Scanner;

public class RoleController {

    List<User> users = UserRepositoryImpl.getUsers();
    RoleServiceImpl roleService = new RoleServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void homePage(User user) {
        boolean isExistUser = checkExistUser(user);
        while (true) {
            if (user.getRole().getName().equalsIgnoreCase("admin")) {
                if (isExistUser) {
                    System.out.println("1. All");
                    System.out.println("2. ADD");
                    System.out.println("3. EDIT");
                    System.out.println("4. DELETE");
                    System.out.println("0. EXIT");

                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            users.forEach(System.out::println);
                        }
                        case 2 -> {
                            System.out.println("B");
                        }
                        case 3 -> {
                            System.out.println("D");
                        }
                        case 4 -> {
                            System.out.println("E");
                        }
                        case 0 -> {
                            return;
                        }
                        default -> {
                            System.out.println("You entered wrong number!");
                        }
                    }
                }
                else {
                    roleService.addNewUser(
                            user.getUsername(),
                            user.getAge(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getRole().getName()
                    );
                    System.out.println("Wait! Your request has been sent to admin.");
                    return;
                }
            }
            else if (user.getRole().getName().equalsIgnoreCase("teacher")) {
                if (isExistUser) {
                    System.out.println("1. CREATE");
                    System.out.println("2. EDIT");
                    System.out.println("3. DELETE");
                    System.out.println("0. EXIT");

                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("A");
                        }
                        case 2 -> {
                            System.out.println("B");
                        }
                        case 3 -> {
                            System.out.println("D");
                        }
                        case 0 -> {
                            return;
                        }
                        default -> {
                            System.out.println("You entered wrong number!");
                        }
                    }
                }
                else {
                    roleService.addNewUser(
                            user.getUsername(),
                            user.getAge(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getRole().getName()
                    );
                    System.out.println("Wait! Your request has been sent to admin.");
                    return;
                }
            }
            else if (user.getRole().getName().equalsIgnoreCase("student")) {
                System.out.println("1, TEST");
                System.out.println("2. RESULT");
                System.out.println("0. EXIT");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("A");
                    }
                    case 2 -> {
                        System.out.println("B");
                    }
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println("You entered wrong number!");
                    }
                }
            }
        }
    }

    // Check exist user
    private boolean checkExistUser(User user) {
        for (User usersItem : users) {
            if (user.equals(usersItem)) {
                return true;
            }
        }
        return false;
    }
}
