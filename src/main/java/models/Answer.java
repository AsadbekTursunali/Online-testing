package models;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Answer {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String answer;
    private TestAnswer testAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(ID, answer.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
