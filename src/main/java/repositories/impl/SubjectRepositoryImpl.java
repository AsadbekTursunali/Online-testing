package repositories.impl;

import models.Subject;
import repositories.SubjectRepository;

import java.util.LinkedList;
import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository {

    public static List<Subject> subjects = new LinkedList<>();

    public static void save() {
        subjects.add(new Subject("Matematika"));
        subjects.add(new Subject("Geografiya"));
        subjects.add(new Subject("Informatika"));
    }

    @Override
    public void add(String subjectName) {
        subjects.add(new Subject(subjectName));
    }

    public static Subject getSubjectById(Long subjectId) {
        for (Subject subject : subjects) {
            if (subjectId.equals(subject.getID())) {
                return subject;
            }
        }
        return null;
    }

    public static List<Subject> getSubjects() {
        return subjects;
    }
}