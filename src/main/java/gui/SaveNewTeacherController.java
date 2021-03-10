package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveNewTeacherController implements Initializable {

    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private GradesControllerClass gradesControllerClass;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField addressInput;

    public SaveNewTeacherController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        nextWindow = new NextWindow();
    }

    public void showStudentList(ActionEvent event) {
        personController.showStudentList(event);
    }

    public void showTeacherList(ActionEvent event) {
        personController.showTeacherList(event);
    }

    public void showAllCourses(ActionEvent event) {
        coursesControllerClass.showAllCourses(event);
    }

    public void showAllGrades(ActionEvent event) {
        gradesControllerClass.showAllGrades(event);
    }

    public void saveNewTeacher(ActionEvent event) {
        Person teacher = new Person(firstNameInput.getText(), lastNameInput.getText(), addressInput.getText(), true);
        personController.addNewPerson(teacher);
        personController.showTeacherList(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
