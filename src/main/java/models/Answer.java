package models;

import lombok.*;

@Data
public class Answer {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String answer;
    private TestAnswer testAnswer;
}
