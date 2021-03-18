package gui;

import controller.CoursesControllerClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseController extends Menu implements Initializable {

    private final NextWindow nextWindow;
    private final CoursesControllerClass coursesControllerClass;

    @FXML
    private TableView<Course> courses;
    @FXML
    private TableColumn<Course, Integer> courseId;
    @FXML
    private TableColumn<Course, String> courseName;
    @FXML
    private TableColumn<Person, String> teacherName;

    public CourseController() {
        super();
        nextWindow = new NextWindow();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    public void addCourse(ActionEvent event) {
        nextWindow.closeWindowAndOpenNext(event, "gui/saveNewCourse.fxml");
    }

    @FXML
    public void deleteCourse(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/deleteCourse.fxml");
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
