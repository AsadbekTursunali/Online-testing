import controller.UserController;

import java.util.Scanner;

public class DemoApplication {

    public static void main(String[] args) {

        UserController userController = new UserController();
        userController.register();
    }
}
