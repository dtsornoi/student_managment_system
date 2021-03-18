package gui;

import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveNewTeacherController extends Menu implements Initializable {

    private final PersonController personController;

    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField addressInput;

    public SaveNewTeacherController(){
        super();
        personController = new PersonController();
    }

    public void saveNewTeacher(ActionEvent event) {
        Person teacher = new Person(firstNameInput.getText(),
                lastNameInput.getText(),
                addressInput.getText(),
                true);
        personController.addNewPerson(teacher);
        personController.showTeacherList(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
