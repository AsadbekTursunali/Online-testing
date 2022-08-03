package repositories;

import models.Question;

public interface ITestAnswerRepository {

    void add(Question questionById, String testAnswer);
}

