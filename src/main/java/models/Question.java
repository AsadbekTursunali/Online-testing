package models;

import lombok.*;

@Data
public class Question {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String question;
    private Subject subject;
}
