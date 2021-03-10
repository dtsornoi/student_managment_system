package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteTeacherController implements Initializable {
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private GradesControllerClass gradesControllerClass;

    @FXML
    private TextField studentId;

    public DeleteTeacherController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
    }

    @FXML
    public void showStudentList(ActionEvent event){
        personController.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event){
        personController.showTeacherList(event);
    }

    @FXML
    void showAllCourses(ActionEvent event){
        coursesControllerClass.showAllCourses(event);
    }

    @FXML
    void showAllGrades(ActionEvent event){
        gradesControllerClass.showAllGrades(event);
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        personController.deletePerson(Integer.parseInt(studentId.getText()));
        personController.showTeacherList(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
