package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Course;
import model.Person;


import java.net.URL;
import java.util.ResourceBundle;


public class SaveNewCourseController extends Menu implements Initializable{
    private final NextWindow nextWindow;
    private final PersonController personController;
    private final CoursesControllerClass coursesControllerClass;

    public SaveNewCourseController() {
        super();
        nextWindow = new NextWindow();
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    private TextField courseNameInput;

    @FXML
    private TextField teacherNameInput;


    @FXML
    public void saveNewCourse(ActionEvent event){
        Person teacher = personController.findTeacherByName(teacherNameInput.getText());
        Course course = new Course(courseNameInput.getText(), teacher);
        coursesControllerClass.addNewCourse(course);
        nextWindow.closeWindowAndOpenNext(event, "gui/coursesList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
