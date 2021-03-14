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

public class CourseController implements Initializable {

    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass coursesControllerClass;
    private GradesControllerClass gradesControllerClass;

    public CourseController() {
        nextWindow = new NextWindow();
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
    }

    @FXML
    private TableView<Course> courses;

    @FXML
    private TableColumn<Course, Integer> courseId;

    @FXML
    private TableColumn<Course, String> courseName;

    @FXML
    private TableColumn<Person, String> teacherName;


    @FXML
    public void addCourse(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/saveNewCourse.fxml");
    }

    @FXML
    public void deleteCourse(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteCourse.fxml");
    }


    @FXML
    void showAllCourses(ActionEvent event) {
        coursesControllerClass.showAllCourses(event);
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
        courseId.setCellValueFactory(new PropertyValueFactory<Course, Integer>("courseId"));
        courseName.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        teacherName.setCellValueFactory(new PropertyValueFactory<>("teacher"));

        ObservableList<Course> list = FXCollections.observableList(coursesControllerClass.listAllCourses());

        if(list.isEmpty()){
            list = FXCollections.emptyObservableList();
        }

        courses.setItems(list);
    }


}
