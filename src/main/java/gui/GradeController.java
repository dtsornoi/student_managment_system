package gui;

import controller.GradesControllerClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Grades;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class GradeController extends Menu implements Initializable {

    private final NextWindow nextWindow;
    private final GradesControllerClass gradesControllerClass;

    public GradeController() {
        super();
        nextWindow = new NextWindow();
        gradesControllerClass = new GradesControllerClass();
    }

    @FXML
    private TableView<Grades> grades;

    @FXML
    private TableColumn<Grades, Integer> gradeId;

    @FXML
    private TableColumn<Grades, String> grade;

    @FXML
    private TableColumn<Course, String> courseId;

    @FXML
    private TableColumn<Person, String> studentName;

    @FXML
    public void addGrade(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/saveNewGrade.fxml");
    }

    @FXML
    public void deleteGrade(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteGrade.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){
        gradeId.setCellValueFactory(new PropertyValueFactory<Grades, Integer>("gradeId"));
        grade.setCellValueFactory(new PropertyValueFactory<Grades, String>("grade"));
        courseId.setCellValueFactory(new PropertyValueFactory<>("course"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("student"));

        ObservableList<Grades> list = FXCollections.observableList(gradesControllerClass.listAllGrades());

        if(list.isEmpty()){
            list = FXCollections.emptyObservableList();
        }

        grades.setItems(list);
    }
}
