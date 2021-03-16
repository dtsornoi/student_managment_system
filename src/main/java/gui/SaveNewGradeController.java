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

public class SaveNewGradeController implements Initializable {
    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass courseControllerClass;
    private GradesControllerClass gradesControllerClass;
    private String courseName;

    public SaveNewGradeController() {
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
    private ComboBox coursesList;

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
        gradesControllerClass.showAllGrades(event);
    }

    @FXML
    public void saveNewGrade(ActionEvent event){
        Course course = courseControllerClass
                .findCourseByName(coursesList
                        .getSelectionModel()
                        .getSelectedItem()
                        .toString());
        Person student = personController.findStudentByNameAndCourse(studentNameInput.getText(), course);
        Grades grades = new Grades(gradeInput.getText(), student , course);
        gradesControllerClass.addGrade(grades);
        nextWindow.closeWindowAndOpenNext(event, "gui/gradesList.fxml");
    }

    @FXML
    void selectCourseFromMenu(ActionEvent event) {
       courseName = coursesList.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Course> courses = courseControllerClass.listAllCourses();
        List<String> coursesName = courses.stream()
                .map(course -> course.getCourseName())
                .collect(Collectors.toList());
        ObservableList<String> list = FXCollections.observableArrayList(coursesName);

        coursesList.setItems(list);
    }
}
