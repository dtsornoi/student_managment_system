package gui;

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

public class TeacherController extends Menu implements Initializable {

    private final NextWindow nextWindow;
    private final PersonController personController;

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
        super();
        nextWindow = new NextWindow();
        personController = new PersonController();
    }

    @FXML
    public void addTeacher(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/addNewTeacher.fxml");
    }

    @FXML
    public void deleteTeacher(ActionEvent event){
       nextWindow.closeWindowAndOpenNext(event, "gui/deleteTeacher.fxml");
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
