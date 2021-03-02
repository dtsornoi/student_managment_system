package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Student;
import persistence.StudentRepository;

import java.util.List;

public class StudentControllerClass {

    private StudentRepository studentRepository;
    private NextWindow nextWindow;

    public StudentControllerClass(){
        studentRepository = new StudentRepository();
        nextWindow = new NextWindow();
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

    public void showStudentList(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

}
