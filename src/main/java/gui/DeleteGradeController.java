package gui;

import controller.GradesControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteGradeController extends Menu implements Initializable {
    private final GradesControllerClass gradesControllerClass;
    private final NextWindow nextWindow;

    @FXML
    private TextField gradeId;

    public DeleteGradeController() {
        super();
        gradesControllerClass = new GradesControllerClass();
        nextWindow = new NextWindow();
    }

    @FXML
    public void deleteGrade(ActionEvent event){
       gradesControllerClass.deleteGrade(Integer.parseInt(gradeId.getText()));
        nextWindow.closeWindowAndOpenNext(event, "gui/gradesList.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
