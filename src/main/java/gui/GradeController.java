package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
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

public class GradeController implements Initializable {

    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass courseControllerClass;
    private GradesControllerClass gradesControllerClass;

    public GradeController() {
        nextWindow = new NextWindow();
        personController = new PersonController();
        courseControllerClass = new CoursesControllerClass();
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
        nextWindow.closeWindowAndOpenNext(event, "saveNewGrade.fxml");
    }

    @FXML
    public void deleteGrade(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteGrade.fxml");
    }

   @FXML
    void showAllCourses(ActionEvent event) {
        courseControllerClass.showAllCourses(event);
    }

    @FXML
    void showAllGrades(ActionEvent event) {
        gradesControllerClass.showAllGrades(event);
    }

   @FXML
    void showStudentList(ActionEvent event) {
        personController.showStudentList(event);
    }

   @FXML
    void showTeacherList(ActionEvent event) {
        personController.showTeacherList(event);
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
