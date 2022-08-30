package repositories.impl;

import models.Role;
import repositories.RoleRepository;

import java.util.LinkedList;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {
    public static List<Role> roles = new LinkedList<>();

    public static void save() {
        roles.add(new Role("Admin"));
        roles.add(new Role("Teacher"));
        roles.add(new Role("Student"));
    }
    public static List<Role> getRoles() {
        return roles;
    }
}