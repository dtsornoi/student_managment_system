package gui;

import controller.CoursesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveNewStudentController implements Initializable {

    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField addressInput;

    public SaveNewStudentController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
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
    public void saveNewStudent(ActionEvent event){
        Person student = new Person(firstNameInput.getText(), lastNameInput.getText(), addressInput.getText(), false);
        personController.addNewPerson(student);
        personController.showStudentList(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
