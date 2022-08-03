package services.impl;

import models.Role;
import models.User;
import services.IRoleService;

import java.util.LinkedList;
import java.util.List;

public class RoleServiceImpl implements IRoleService {

    List<User> newUser = new LinkedList<>();

    public void addNewUser(String username, Integer age, String email, String password, String roleName) {
        newUser.add(new User(username, age, email, password, new Role(roleName)));
    }

    @Override
    public void admin(User user) {

    }

    @Override
    public void teacher(User user) {

    }

    @Override
    public void student(User user) {

    }
}