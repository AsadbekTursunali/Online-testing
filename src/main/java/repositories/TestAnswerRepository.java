package repositories;

import models.Question;

public interface TestAnswerRepository {

    void add(Question questionById, String testAnswer);
}

