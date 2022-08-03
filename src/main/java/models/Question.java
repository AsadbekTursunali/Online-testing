package models;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Question {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private Subject subject;
    private String questionName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(ID, question.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
