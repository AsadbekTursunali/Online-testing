package models;

import lombok.*;

@AllArgsConstructor
@Data
public class User {
    private final Long ID = (long) ((Math.random() * 9999) + 1);
    private String username;
    private Integer age;
    private String email;
    private String password;
    private Role role;
}
