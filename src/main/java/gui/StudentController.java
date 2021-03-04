package gui;

import controller.CoursesControllerClass;
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

    public StudentController(){
        nextWindow = new NextWindow();

        coursesControllerClass = new CoursesControllerClass();
    }

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

    @FXML
    public void showStudentList(ActionEvent event){
        personController.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event) {
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
    public void addStudent(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/saveNewStudent.fxml");
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteStudent.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<Person,Integer>("studentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Person,String>("address"));

        ObservableList<Person> list = FXCollections.observableList(personController.listAllStudents());

        if (list.isEmpty()) {
            list = FXCollections.emptyObservableList();
        }
        students.setItems(list);
    }


}
