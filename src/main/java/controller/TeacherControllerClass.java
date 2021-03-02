package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Student;
import model.Teacher;
import persistence.TeacherRepository;

import java.util.List;

public class TeacherControllerClass {

    private TeacherRepository teacherRepository;
    private NextWindow nextWindow;

    public TeacherControllerClass() {
        teacherRepository = new TeacherRepository();
        nextWindow = new NextWindow();
    }

    void login(){

    }

    void modifyMarksSheet(){

    }

    void modifyAttendance(){

    }

    void displayAllTeachers(){

    }

    void addNewTeacher(){

    }

    public List<Teacher> listAllTeachers(){
        return teacherRepository.allTeachers();
    }

    void deleteTeacher(){

    }

    public void showTeacherList(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/teachersList.fxml");
    }
}
