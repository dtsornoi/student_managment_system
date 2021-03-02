package gui;

import controller.StudentControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import model.Student;
import persistence.StudentRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveNewStudentController implements Initializable {

    private NextWindow nextWindow;

    private StudentControllerClass studentControllerClass;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField addressInput;

    public SaveNewStudentController(){
        studentControllerClass = new StudentControllerClass();
        nextWindow = new NextWindow();
    }

    @FXML
    public void showStudentList(ActionEvent event){
        studentControllerClass.showStudentList(event);
    }

    @FXML
    public void saveNewStudent(ActionEvent event){
        Student student = new Student(firstNameInput.getText(), lastNameInput.getText(), addressInput.getText());
        studentControllerClass.addNewStudent(student);
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}