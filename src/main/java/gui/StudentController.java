package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    private Course course;
    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private GradesControllerClass gradesControllerClass;

    @FXML
    private TableView<Person> students;

    @FXML
    private TableColumn<Person, Integer> studentId;

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private TableColumn<Person, String> address;

    public StudentController(){
        nextWindow = new NextWindow();
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
    }

    @FXML
    public void showStudentList(ActionEvent event){
        personController.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event) {
        personController.showTeacherList(event);
    }

    @FXML
    public void showAllCourses(ActionEvent event){
        coursesControllerClass.showAllCourses(event);
    }

    @FXML
    public void showAllGrades(ActionEvent event){
        gradesControllerClass.showAllGrades(event);
    }

    @FXML
    public void addStudent(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/saveNewStudent.fxml");
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteStudent.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<Person> list = FXCollections.observableList(personController.listAllStudents());

        if (list.isEmpty()) {
            list = FXCollections.emptyObservableList();
        }

        students.setItems(list);
    }


}
