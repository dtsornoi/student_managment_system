package gui;

import controller.CoursesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteStudentController implements Initializable {

    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private NextWindow nextWindow;

    @FXML
    private TextField studentId;

    public DeleteStudentController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        nextWindow = new NextWindow();

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
        // TODO
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        personController.deletePerson(Integer.parseInt(studentId.getText()));
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
