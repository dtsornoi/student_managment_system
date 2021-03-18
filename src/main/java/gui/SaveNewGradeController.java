package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Course;
import model.Grades;
import model.Person;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SaveNewGradeController extends Menu implements Initializable {
    private final NextWindow nextWindow;
    private final PersonController personController;
    private final CoursesControllerClass courseControllerClass;
    private final GradesControllerClass gradesControllerClass;

    public SaveNewGradeController() {
        super();
        nextWindow = new NextWindow();
        personController = new PersonController();
        courseControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
    }

    @FXML
    private TextField gradeInput;

    @FXML
    private TextField studentNameInput;

    @FXML
    private ComboBox<String> coursesList;

    @FXML
    public void saveNewGrade(ActionEvent event){
        Course course = courseControllerClass
                .findCourseByName(coursesList
                        .getSelectionModel()
                        .getSelectedItem());
        Person student = personController.findStudentByNameAndCourse(studentNameInput.getText(), course);
        Grades grades = new Grades(gradeInput.getText(), student , course);
        gradesControllerClass.addGrade(grades);
        nextWindow.closeWindowAndOpenNext(event, "gui/gradesList.fxml");
    }

    @FXML
    void selectCourseFromMenu(ActionEvent event) {
        String courseName = coursesList.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Course> courses = courseControllerClass.listAllCourses();
        List<String> coursesName = courses.stream()
                .map(Course::getCourseName)
                .collect(Collectors.toList());
        ObservableList<String> list = FXCollections.observableArrayList(coursesName);

        coursesList.setItems(list);
    }
}
