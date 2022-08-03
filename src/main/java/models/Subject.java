package models;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Subject {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String subjectName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(ID, subject.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
