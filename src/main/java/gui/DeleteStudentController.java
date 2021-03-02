package gui;

import controller.StudentControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteStudentController implements Initializable {

    private StudentControllerClass studentControllerClass;
    private NextWindow nextWindow;

    @FXML
    private TextField studentId;

    public DeleteStudentController(){
        studentControllerClass = new StudentControllerClass();
        nextWindow = new NextWindow();
    }
    
    @FXML
    public void deleteStudent(ActionEvent event){
        studentControllerClass.deleteStudent(Integer.parseInt(studentId.getText()));
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
