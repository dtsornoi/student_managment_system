package controller;

import model.Student;
import persistence.StudentRepository;

import java.util.List;

public class StudentControllerClass {

    private StudentRepository studentRepository;

    public StudentControllerClass(){
        studentRepository = new StudentRepository();
    }

    void login(){

    }

    void showAttendance(){

    }

    void showMarksSheet(){

    }

    void showCourses(){

    }

    public void addNewStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> listAllStudents(){
        return studentRepository.allStudents();
    }

    public void deleteStudent(int id){
        Student student = new Student();
        student.setStudentId(id);

        studentRepository.delete(student);
    }
}
