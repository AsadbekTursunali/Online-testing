package controller;

import models.User;
import services.AdminService;
import services.StudentService;
import services.TeacherService;
import services.impl.AdminServiceImpl;
import services.impl.StudentServiceImpl;
import services.impl.TeacherServiceImpl;

public class RoleController {
    AdminService adminService = new AdminServiceImpl();
    TeacherService teacherService = new TeacherServiceImpl();
    StudentService studentService = new StudentServiceImpl();

    public void signIn(User user) {
        if (user.getRole().getName().equalsIgnoreCase("admin")) {
            adminService.admin(user);
        } else if (user.getRole().getName().equalsIgnoreCase("teacher")) {
            teacherService.teacher(user);
        } else if (user.getRole().getName().equalsIgnoreCase("student")) {
            studentService.student(user);
        } else {
            System.out.println("This role doesn't exist!\n");
        }
    }

    public void signUp(User user) {
        if (user.getRole().getName().equalsIgnoreCase("admin")) {
            AdminServiceImpl.waitingRoom(user);
        } else if (user.getRole().getName().equalsIgnoreCase("teacher")) {
            AdminServiceImpl.waitingRoom(user);
        } else if (user.getRole().getName().equalsIgnoreCase("student")) {
            studentService.student(user);
        }else {
            System.out.println("This role doesn't exist!\n");
        }
    }
}
