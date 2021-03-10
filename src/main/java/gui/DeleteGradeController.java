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

public class DeleteGradeController implements Initializable {
    private PersonController personController;
    private CoursesControllerClass courseControllerClass;
    private GradesControllerClass gradesControllerClass;
    private NextWindow nextWindow;

    @FXML
    private TextField gradeId;

    public DeleteGradeController() {
        personController = new PersonController();
        courseControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
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
        courseControllerClass.showAllCourses(event);
    }

    @FXML
    void showAllGrades(ActionEvent event){
        // TODO
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
