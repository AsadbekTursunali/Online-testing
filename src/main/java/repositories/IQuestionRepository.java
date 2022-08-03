package repositories;

import models.Subject;

public interface IQuestionRepository {
    void add(Subject subject, String questionName);
}
