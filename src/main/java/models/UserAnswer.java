package models;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserAnswer {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private User user;
    private TestAnswer testAnswer;
    private String userAnswerName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAnswer that = (UserAnswer) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
