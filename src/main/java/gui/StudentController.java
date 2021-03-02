package gui;

import controller.StudentControllerClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    private Course course;
    private NextWindow nextWindow;
    private StudentControllerClass studentControllerClass;

    public StudentController(){
        nextWindow = new NextWindow();
        studentControllerClass = new StudentControllerClass();
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
    public void addStudent(ActionEvent event){
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
