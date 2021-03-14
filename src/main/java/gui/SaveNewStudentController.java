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
import model.Person;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SaveNewStudentController implements Initializable {

    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private GradesControllerClass gradesControllerClass;
    private String courseName;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField addressInput;

    @FXML
    private ComboBox coursesList;

    public SaveNewStudentController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
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
        gradesControllerClass.showAllGrades(event);
    }

    @FXML
    public void saveNewStudent(ActionEvent event){
        Person student = new Person(firstNameInput.getText(), lastNameInput.getText(), addressInput.getText(), false);
        Course course = coursesControllerClass
                .findCourseByName(coursesList
                        .getSelectionModel()
                        .getSelectedItem()
                        .toString());
        student.setCourse(course);
        personController.addNewPerson(student);
        personController.showStudentList(event);
    }

    @FXML
    void selectCourseFromMenu(ActionEvent event) {
        courseName = coursesList.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Course> courses = coursesControllerClass.listAllCourses();
        List<String> coursesName = courses.stream()
                .map(course -> course.getCourseName())
                .collect(Collectors.toList());
        ObservableList<String> list = FXCollections.observableArrayList(coursesName);

        coursesList.setItems(list);
    }


}
