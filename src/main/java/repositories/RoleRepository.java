package repositories;

import models.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleRepository {

    public static List<Role> roles = new ArrayList<>();

    public void getAllRoles() {
        roles.add(new Role("Teacher"));
        roles.add(new Role("Student"));
    }
}
