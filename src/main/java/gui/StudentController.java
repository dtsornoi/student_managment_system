package gui;

import controller.CoursesControllerClass;
import controller.StudentControllerClass;
import controller.TeacherControllerClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Course;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    private Course course;
    private NextWindow nextWindow;
    private StudentControllerClass studentControllerClass;
    private TeacherControllerClass teacherControllerClass;
    private CoursesControllerClass coursesControllerClass;

    public StudentController(){
        nextWindow = new NextWindow();
        studentControllerClass = new StudentControllerClass();
        teacherControllerClass = new TeacherControllerClass();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    private TableView<Student> students;

    @FXML
    private TableColumn<Student, Integer> studentId;

    @FXML
    private TableColumn<Student, String> firstName;

    @FXML
    private TableColumn<Student, String> lastName;

    @FXML
    private TableColumn<Student, String> address;

    @FXML
    public void showStudentList(ActionEvent event){
        studentControllerClass.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event) {
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
    public void addStudent(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/saveNewStudent.fxml");
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteStudent.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));

        ObservableList<Student> list = FXCollections.observableList(studentControllerClass.listAllStudents());

        if (list.isEmpty()) {
            list = FXCollections.emptyObservableList();
        }
        students.setItems(list);
    }


}
