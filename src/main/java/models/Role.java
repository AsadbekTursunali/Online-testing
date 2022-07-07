package models;

import lombok.*;

@AllArgsConstructor
@Data
public class Role {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String name;
}
