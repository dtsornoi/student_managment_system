package gui;

import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteStudentController extends Menu implements Initializable {

    private final PersonController personController;
    private final NextWindow nextWindow;

    @FXML
    private TextField studentId;

    public DeleteStudentController(){
        super();
        personController = new PersonController();
        nextWindow = new NextWindow();
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
