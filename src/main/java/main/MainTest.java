package main;

import model.Student;
import model.Teacher;
import persistence.StudentRepository;
import persistence.TeacherRepository;

public class MainTest {
    public static void main(String[] args) {
//        StudentRepository studentRepo = new StudentRepository();
//        Student student = new Student();
//        student.setFirstName("Uku");
//        student.setLastName("Kasepuu");
//        student.setAddress("Tuukri 15");

//        studentRepo.save(student);

        TeacherRepository teacherRepo = new TeacherRepository();
        Teacher teacher = new Teacher();

        teacherRepo.save(teacher);

    }
}
