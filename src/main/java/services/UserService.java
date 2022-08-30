package services;

import models.User;

public interface UserService {
    void signIn(String usernameOrEmail, String password);

    void signUp(String username, int age, String email, String password, String roleName);
}
