package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    ObservableList<Student> list = FXCollections.observableArrayList(
            new Student(1, "Dmitri", "Tsornoi", "Address1"),
            new Student(2, "Mark", "Salumaa", "Address2"),
            new Student(3, "Indrek", "Kaul", "Address3"),
            new Student(4, "Izzet", "Ertopak", "Address4"),
            new Student(5, "Jamshid", "Luftllaev", "Address5")
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<Student,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Student,String>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));

        students.setItems(list);
    }
}
