package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Course;
import model.Grades;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class SaveNewGradeController implements Initializable {
    private NextWindow nextWindow;
    private PersonController personController;
    private CoursesControllerClass courseControllerClass;
    private GradesControllerClass gradesControllerClass;

    public SaveNewGradeController() {
        nextWindow = new NextWindow();
        personController = new PersonController();
        courseControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
    }

    @FXML
    private TextField gradeInput;

    @FXML
    private TextField studentNameInput;

    @FXML
    public void showStudentList(ActionEvent event){
        personController.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event){
        personController.showTeacherList(event);
    }

    @FXML
    void showAllCourses(ActionEvent event){
        courseControllerClass.showAllCourses(event);
    }

    @FXML
    void showAllGrades(ActionEvent event){
        gradesControllerClass.showAllGrades(event);
    }

    @FXML
    public void saveNewGrade(ActionEvent event){
        Person student = personController.findStudentByName(studentNameInput.getText());
        Grades grades = new Grades(gradeInput.getText(), student);
        gradesControllerClass.addNewGrade(grades);
        nextWindow.closeWindowAndOpenNext(event, "gui/gradesList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
