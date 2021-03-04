package gui;

import controller.CoursesControllerClass;
import controller.StudentControllerClass;
import controller.TeacherControllerClass;
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
import model.Teacher;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    private NextWindow nextWindow;
    private StudentControllerClass studentControllerClass;
    private TeacherControllerClass teacherControllerClass;
    private CoursesControllerClass coursesControllerClass;

    public CourseController() {
        nextWindow = new NextWindow();
        studentControllerClass = new StudentControllerClass();
        teacherControllerClass = new TeacherControllerClass();
        coursesControllerClass = new CoursesControllerClass();
    }

    @FXML
    private TableView<Course> courses;

    @FXML
    private TableColumn<Course, Integer> courseId;

    @FXML
    private TableColumn<Course, String> courseName;

    @FXML
    private TableColumn<Grades, Integer> gradeId;

    @FXML
    private TableColumn<Teacher, Integer> teacherId;



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

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){
        courseId.setCellValueFactory(new PropertyValueFactory<Course, Integer>("courseId"));
        courseName.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        gradeId.setCellValueFactory(new PropertyValueFactory<Grades, Integer>("gradeId"));
        teacherId.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("teacherId"));

        ObservableList<Course> list = FXCollections.observableList(coursesControllerClass.listAllCourses());

        if(list.isEmpty()){
            list = FXCollections.emptyObservableList();
        } courses.setItems(list);
    }
}
