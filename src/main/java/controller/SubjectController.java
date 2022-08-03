package controller;

import models.Subject;
import models.User;
import repositories.impl.SubjectRepositoryImpl;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SubjectController {

    static List<Subject> subjects = SubjectRepositoryImpl.getSubjects();
    static Scanner scanner = new Scanner(System.in);

    public static void make(User user) {
        subjects
                .stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        System.out.print("Test topshirmoqchi bo'lgan faninggizni kiriting: ");
        String choice = scanner.next();
        for (Subject subject : subjects) {
            if (choice.equalsIgnoreCase(subject.getSubjectName())) {
                QuestionController.make(choice);
            }
        }
    }
}
