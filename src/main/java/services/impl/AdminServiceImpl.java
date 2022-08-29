package services.impl;

import models.User;
import repositories.IUserRepository;
import repositories.impl.UserRepositoryImpl;
import services.AdminService;

import java.util.*;

public class AdminServiceImpl implements AdminService {

    public static List<User> newUsers = new LinkedList<>();
    static List<User> users = UserRepositoryImpl.getUsers();
    static Scanner scanner = new Scanner(System.in);
    IUserRepository userRepository = new UserRepositoryImpl();

    // Waiting room for new admins
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
                case 1 -> users
                        .stream()
                        .sorted(Comparator.comparing(item -> item.getRole().getName()))
                        .forEach(System.out::println);
                case 2 -> addNewUsers();
                case 3 -> editUsers(user);
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
        if (user.getRole().getName().equalsIgnoreCase("Admin")
                || user.getRole().getName().equalsIgnoreCase("Asadbektursunali")) {
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
                        item.getRole().setName("teacher");
                    }
                });
            } else if (role == 3) {
                users.forEach(item -> {
                    if (item.getID() == id) {
                        item.getRole().setName("Student");
                    }
                });
            } else {
                return;
            }
        } else {
            users
                    .stream()
                    .filter(item -> item.getRole().getName().equalsIgnoreCase("teacher"))
                    .filter(item -> item.getRole().getName().equalsIgnoreCase("student"))
                    .sorted(Comparator.comparing(item -> item.getRole().getName()))
                    .forEach(System.out::println);

            System.out.print("Id: ");
            long id = scanner.nextInt();
            System.out.println();
            users
                    .stream()
                    .filter(item -> item.getID() == id)
                    .forEach(System.out::println);
            System.out.println("1.Teacher, 2.Student, 0.Exit");
            int role = scanner.nextInt();
            if (role == 1) {
                users.forEach(item -> {
                    if (item.getID() == id) {
                        item.getRole().setName("teacher");
                    }
                });
            } else if (role == 2) {
                users.forEach(item -> {
                    if (item.getID() == id) {
                        item.getRole().setName("student");
                    }
                });
            } else {
                return;
            }
        }
    }

}
