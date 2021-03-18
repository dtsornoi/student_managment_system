package gui;

import controller.CoursesControllerClass;
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

public class SaveNewStudentController extends Menu implements Initializable {

    private final PersonController personController;
    private final CoursesControllerClass coursesControllerClass;

    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField addressInput;
    @FXML
    private ComboBox<String> coursesList;

    public SaveNewStudentController(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    public void saveNewStudent(ActionEvent event){
        Person student = new Person(firstNameInput.getText(),
                lastNameInput.getText(),
                addressInput.getText(),
                false);
        Course course = coursesControllerClass
                .findCourseByName(coursesList
                        .getSelectionModel()
                        .getSelectedItem());
        student.setCourse(course);
        personController.addNewPerson(student);
        personController.showStudentList(event);
    }

    @FXML
    public void selectCourseFromMenu(ActionEvent event) {
        String courseName = coursesList
                .getSelectionModel()
                .getSelectedItem();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Course> courses = coursesControllerClass.listAllCourses();

        List<String> coursesName = courses.stream()
                .map(Course::getCourseName)
                .collect(Collectors.toList());
        ObservableList<String> list = FXCollections.observableArrayList(coursesName);

        coursesList.setItems(list);
    }


}
