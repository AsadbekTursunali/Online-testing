package services.impl;

import models.User;
import repositories.UserRepository;
import repositories.impl.UserRepositoryImpl;
import services.AdminService;

import java.util.*;

public class AdminServiceImpl implements AdminService {

    public static List<User> newUsers = new LinkedList<>();
    static List<User> users = UserRepositoryImpl.getUsers();
    static Scanner scanner = new Scanner(System.in);
    UserRepository userRepository = new UserRepositoryImpl();

    // Waiting room for new users
    public static void waitingRoom(User user) {
        newUsers.add(new User(user.getUsername(), user.getAge(), user.getEmail(), user.getPassword(), user.getRole()));
        System.out.println("Wait! Your request has been sent to admin.");
    }

    @Override
    public void admin(User user) {
        while (true) {
            System.out.println("1. All");
            System.out.println("2. ADD");
            System.out.println("3. EDIT");
            System.out.println("4. DELETE");
            System.out.println("0. EXIT");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    users
                            .stream()
                            .sorted(Comparator.comparing(item -> item.getRole().getName()))
                            .forEach(System.out::println);
                    System.out.println();
                }
                case 2 -> addNewUsers();
                case 3 -> editUsers(user);
                case 4 -> deleteUsers(user);
                case 0 -> {
                    return;
                }
                default -> System.out.println("You entered wrong number!\n");
            }
        }
    }

    // case 2 -> This method adds in waiting room to the database
    private void addNewUsers() {
        while (true) {
            if (!newUsers.isEmpty()) {
                newUsers
                        .stream()
                        .sorted(Comparator.comparing(item -> item.getRole().getName()))
                        .forEach(System.out::println);

                System.out.println("\n1.Add all, 2.Add one, 0.Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        for (User newUser : newUsers) {
                            userRepository.add(
                                    newUser.getUsername(),
                                    newUser.getAge(),
                                    newUser.getEmail(),
                                    newUser.getPassword(),
                                    newUser.getRole());

                            newUsers.remove(newUser);
                        }
                        System.out.println("Added all!\n");
                        return;
                    }
                    case 2 -> {
                        System.out.print("Id: ");
                        long id = scanner.nextInt();

                        for (User newUser : newUsers) {
                            if (newUser.getID() == id) {
                                userRepository.add(
                                        newUser.getUsername(),
                                        newUser.getAge(),
                                        newUser.getEmail(),
                                        newUser.getPassword(),
                                        newUser.getRole()
                                );
                                newUsers.remove(newUser);
                            }
                        }
                        System.out.println("Added!\n");
                        return;
                    }
                    case 0 -> {
                        return;
                    }
                }
            } else {
                System.out.println("Empty...\n");
                return;
            }
        }
    }

    // case 3 -> This method enables editing all users
    private void editUsers(User user) {
        users
                .stream()
                .sorted(Comparator.comparing(item -> item.getRole().getName()))
                .forEach(System.out::println);

        System.out.print("Id: ");
        long id = scanner.nextInt();
        System.out.println();
        users
                .stream()
                .filter(item -> item.getID() == id)
                .forEach(System.out::println);

        System.out.println("Role: 1.Admin, 2.Teacher, 3.Student, 0.Exit");
        int role = scanner.nextInt();

        if (role == 1) {
            users.forEach(item -> {
                if (item.getID() == id) {
                    item.getRole().setName("admin");
                }
            });
        } else if (role == 2) {
            users.forEach(item -> {
                if (item.getID() == id) {
                    if (item.getRole().getName().equalsIgnoreCase("admin")) {
                        if (user.getUsername().equalsIgnoreCase("admin")
                                || user.getUsername().equalsIgnoreCase("AsadbekTursunali")) {
                            item.getRole().setName("teacher");
                            System.out.println("Edited!\n");
                        } else {
                            System.out.println("You can't edit admins");
                        }
                    } else {
                        item.getRole().setName("teacher");
                        System.out.println("Edited!\n");
                    }
                }
            });
        } else if (role == 3) {
            users.forEach(item -> {
                if (item.getID() == id) {
                    if (item.getRole().getName().equalsIgnoreCase("admin")) {
                        if (user.getUsername().equalsIgnoreCase("admin")
                                || user.getUsername().equalsIgnoreCase("AsadbekTursunali")) {
                            item.getRole().setName("student");
                        } else {
                            System.out.println("You can't edit admins");
                        }
                    } else {
                        item.getRole().setName("student");
                    }
                }
            });
        } else {
            System.out.println();
        }
    }

    // case 4 -> This method enables deleting some users
    private void deleteUsers(User user) {
        users
                .stream()
                .sorted(Comparator.comparing(item -> item.getRole().getName()))
                .forEach(System.out::println);

        System.out.print("Id: ");
        long id = scanner.nextInt();
        System.out.println();
        users
                .stream()
                .filter(item -> item.getID() == id)
                .forEach(System.out::println);

        System.out.println("Delete: 1.Yes, 0.No");
        int role = scanner.nextInt();

        if (role == 1) {
            users.forEach(item -> {
                if (item.getID() == id) {
                    if (item.getRole().getName().equalsIgnoreCase("admin")) {
                        if (user.getUsername().equalsIgnoreCase("admin")
                                || user.getUsername().equalsIgnoreCase("AsadbekTursunali")) {
                            users.remove(item);
                            System.out.println("Deleted!\n");
                        } else {
                            System.out.println("You can't delete admins\n");
                        }
                    } else {
                        users.remove(item);
                        System.out.println("Deleted!\n");
                    }
                }
            });
        } else {
            System.out.println();
        }
    }
}
