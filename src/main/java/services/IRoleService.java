package services;

import models.User;

public interface IRoleService {
    void admin(User user);

    void teacher(User user);

    void student(User user);
}