package gui;

import controller.CoursesControllerClass;
import controller.StudentControllerClass;
import controller.TeacherControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCourseController implements Initializable {
    private TeacherControllerClass teacherControllerClass;
    private StudentControllerClass studentControllerClass;
    private CoursesControllerClass coursesControllerClass;
    private NextWindow nextWindow;

    @FXML
    private TextField courseId;

    public DeleteCourseController(){
        teacherControllerClass = new TeacherControllerClass();
        studentControllerClass = new StudentControllerClass();
        coursesControllerClass = new CoursesControllerClass();
        nextWindow = new NextWindow();

    }

    @FXML
    public void showStudentList(ActionEvent event){
        studentControllerClass.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event){
        teacherControllerClass.showTeacherList(event);
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
