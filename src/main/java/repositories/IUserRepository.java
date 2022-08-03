package repositories;

import models.Role;

public interface IUserRepository {
    void add(String username, Integer age, String email, String password, Role role);
}
