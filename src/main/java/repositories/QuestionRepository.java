package repositories;

import models.Subject;

public interface QuestionRepository {
    void add(Subject subject, String questionName);
}
