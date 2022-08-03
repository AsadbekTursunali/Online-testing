package models;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestAnswer {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private Question question;
    private String testAnswerName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestAnswer that = (TestAnswer) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
