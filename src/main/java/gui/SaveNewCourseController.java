package gui;

import controller.CoursesControllerClass;
import controller.StudentControllerClass;
import controller.TeacherControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Course;


import java.net.URL;
import java.util.ResourceBundle;


public class SaveNewCourseController implements Initializable {
    private NextWindow nextWindow;
    private StudentControllerClass studentControllerClass;
    private TeacherControllerClass teacherControllerClass;
    private CoursesControllerClass coursesControllerClass;

    public SaveNewCourseController() {
        nextWindow = new NextWindow();
        studentControllerClass = new StudentControllerClass();
        teacherControllerClass = new TeacherControllerClass();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    private TextField courseNameInput;

    @FXML
    private TextField teacherNameInput;

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
    public void saveNewCourse(ActionEvent event){
        Course course = new Course(courseNameInput.getText(), teacherNameInput.getText());
        coursesControllerClass.addNewCourse(course);
        nextWindow.closeWindowAndOpenNext(event, "gui/coursesList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
