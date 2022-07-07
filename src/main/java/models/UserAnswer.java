package models;

import lombok.*;

@Data
public class UserAnswer {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String userAnswer;
    private TestAnswer testAnswer;
}
