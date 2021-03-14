package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.LoginController;
import controller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private GradesControllerClass gradesControllerClass;
    private LoginController loginController;

    @FXML
    private TableView<Person> teachers;

    @FXML
    private TableColumn<Person, Integer> teacherId;

    @FXML
    private TableColumn<Person, String> teacherFirstName;

    @FXML
    private TableColumn<Person, String> teacherLastName;

    @FXML
    private TableColumn<Person, String> address;


    public TeacherController() {
        nextWindow = new NextWindow();
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
        loginController = new LoginController();
    }

    @FXML
    public void addTeacher(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/addNewTeacher.fxml");
    }

    @FXML
    public void deleteTeacher(ActionEvent event){
       nextWindow.closeWindowAndOpenNext(event, "gui/deleteTeacher.fxml");
    }


    @FXML
    void showStudentList(ActionEvent event) {
        personController.showStudentList(event);
    }

    @FXML
    void showTeacherList(ActionEvent event) {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherId.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        teacherFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        teacherLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));

        ObservableList<Person> list = FXCollections.observableList(personController.listAllTeachers());

        if(list.isEmpty()){
            list = FXCollections.emptyObservableList();
        }
        teachers.setItems(list);
    }
}
