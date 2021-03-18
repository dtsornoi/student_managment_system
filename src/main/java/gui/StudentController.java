package gui;

import controller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController extends Menu implements Initializable {

    private final NextWindow nextWindow;
    private final PersonController personController;

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
    private TableColumn<Person, String> courseInTable;
    @FXML
    private ObservableList<Person> list;

    public StudentController(){
        super();
        nextWindow = new NextWindow();
        personController = new PersonController();
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

        list = FXCollections.observableList(personController.listAllStudents());

        if (list.isEmpty()) {
            list = FXCollections.emptyObservableList();
        }else{
            courseInTable.setCellValueFactory(new PropertyValueFactory<>("course"));
        }

        students.setItems(list);
    }


}
