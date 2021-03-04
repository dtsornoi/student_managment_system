package gui;

import controller.CoursesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Course;


import java.net.URL;
import java.util.ResourceBundle;


public class SaveNewCourseController implements Initializable {
    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;

    public SaveNewCourseController() {
        nextWindow = new NextWindow();
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    private TextField courseNameInput;

    @FXML
    private TextField teacherNameInput;

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
    public void saveNewCourse(ActionEvent event){
        Course course = new Course(courseNameInput.getText(), teacherNameInput.getText());
        coursesControllerClass.addNewCourse(course);
        nextWindow.closeWindowAndOpenNext(event, "gui/coursesList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
