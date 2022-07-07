package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignIn {
    private String usernameOrEmail;
    private String password;
}
