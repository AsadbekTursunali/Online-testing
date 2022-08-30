package repositories.impl;

import models.Question;
import models.Subject;
import repositories.QuestionRepository;

import java.util.LinkedList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

    public static List<Question> questions = new LinkedList<>();
    public static List<Subject> subjects = SubjectRepositoryImpl.getSubjects();

    public static void save() {
        for (Subject subject : subjects) {
            if ("matematika".equalsIgnoreCase(subject.getSubjectName())) {
                questions.add(new Question(
                        SubjectRepositoryImpl.getSubjectById(subject.getID()),
                        "Sinfda 30 ta o'quvchi bor, ulardan 20 tasi rus tilini biladi. " +
                                "18 tasi esa ingliz tilini biladi. Savol: o'quvchilardan nechtasi har ikkala tilni ham biladi? "));

                questions.add(new Question(
                        SubjectRepositoryImpl.getSubjectById(subject.getID()),
                        "Men bir son o'yladim. O'ylagan sonimning yarimiga choragini qo'shsam, " +
                                "18 hosil bo'ladi. Savol: Men qaysi sonni o'yladim? "
                ));

                questions.add(new Question(
                        SubjectRepositoryImpl.getSubjectById(subject.getID()),
                        "5 xonali sonlardan iborat parol qo'yilgan. " +
                                "Parol ochilishi uchun necha xil variantda son kiritish kerak? "
                ));
            }

            if ("geografiya".equalsIgnoreCase(subject.getSubjectName())) {
                questions.add(new Question(
                        SubjectRepositoryImpl.getSubjectById(subject.getID()),
                        "Avstraliyada yashovchi mutlaqo suv ichmaydigan sut emizuvchi hayvon qaysi? "));

                questions.add(new Question(
                        SubjectRepositoryImpl.getSubjectById(subject.getID()),
                        "Dunyodagi qaysi dengiz eng iliq dengiz deb tan olingan? "
                ));

                questions.add(new Question(
                        SubjectRepositoryImpl.getSubjectById(subject.getID()),
                        "Qaysi davlat poytaxti dunyodagi eng sovuq poytaxt hisoblanadi? "
                ));
            }
        }
    }

    @Override
    public void add(Subject subject, String questionName) {
    }

    public static Question getQuestionById(Long questionId) {
        for (Question question : questions) {
            if (questionId.equals(question.getID())) {
                return question;
            }
        }
        return null;
    }

    public static List<Question> getQuestions() {
        return questions;
    }
}