package gui;

import controller.CoursesControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCourseController extends Menu implements Initializable {
    private final CoursesControllerClass coursesControllerClass;
    private final NextWindow nextWindow;

    @FXML
    private TextField courseId;

    public DeleteCourseController(){
        super();
        coursesControllerClass = new CoursesControllerClass();
        nextWindow = new NextWindow();

    }

    @FXML
    public void deleteCourse(ActionEvent event){
        coursesControllerClass.deleteCourse(Integer.parseInt(courseId.getText()));
        nextWindow.closeWindowAndOpenNext(event, "gui/coursesList.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
