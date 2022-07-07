package models;

import lombok.*;

@Data
public class TestAnswer {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String testAnswer;
    private Question question;
}
