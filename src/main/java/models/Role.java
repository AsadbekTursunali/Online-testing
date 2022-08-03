package models;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(ID, role.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
