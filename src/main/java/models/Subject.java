package models;

import lombok.*;

@Data
public class Subject {
    private final Long ID = (long) (Math.random() * 9999) + 1;
    private String subject;
    private User user;
}
