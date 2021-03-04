package gui;

import controller.CoursesControllerClass;
import controller.StudentControllerClass;
import controller.TeacherControllerClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Teacher;
import persistence.TeacherRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    private NextWindow nextWindow;
    private TeacherControllerClass teacherControllerClass;
    private StudentControllerClass studentControllerClass;
    private CoursesControllerClass coursesControllerClass;

    public TeacherController() {
        nextWindow = new NextWindow();
        teacherControllerClass = new TeacherControllerClass();
        studentControllerClass = new StudentControllerClass();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    private TableView<Teacher> teachers;

    @FXML
    private TableColumn<Teacher, Integer> teacherId;

    @FXML
    private TableColumn<Teacher, String> teacherFirstName;

    @FXML
    private TableColumn<Teacher, String> teacherLastName;

    @FXML
    private TableColumn<Teacher, String> address;


    @FXML
    public void addTeacher(ActionEvent event) {
        // TODO
    }

    @FXML
    public void deleteTeacher(ActionEvent event){
       // TODO
    }


    @FXML
    void showStudentList(ActionEvent event) {
        studentControllerClass.showStudentList(event);
    }

    @FXML
    void showTeacherList(ActionEvent event) {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherId.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("teacherId"));
        teacherFirstName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherFirstName"));
        teacherLastName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherLastName"));
        address.setCellValueFactory(new PropertyValueFactory<Teacher, String>("address"));

        ObservableList<Teacher> list = FXCollections.observableList(teacherControllerClass.listAllTeachers());

        if(list.isEmpty()){
            list = FXCollections.emptyObservableList();
        } teachers.setItems(list);
    }
}
