package gui;

import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteTeacherController extends Menu implements Initializable {
    private final PersonController personController;

    @FXML
    private TextField studentId;

    public DeleteTeacherController(){
        super();
        personController = new PersonController();
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
