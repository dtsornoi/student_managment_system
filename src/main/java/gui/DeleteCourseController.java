package gui;

import controller.CoursesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCourseController implements Initializable {
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private NextWindow nextWindow;

    @FXML
    private TextField courseId;

    public DeleteCourseController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
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
        coursesControllerClass.showAllCourses(event);
    }

    @FXML
    void showAllGrades(ActionEvent event){
        // TODO
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
