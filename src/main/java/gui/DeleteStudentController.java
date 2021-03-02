package gui;

import controller.StudentControllerClass;
import controller.TeacherControllerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteStudentController implements Initializable {

    private TeacherControllerClass teacherControllerClass;
    private StudentControllerClass studentControllerClass;
    private NextWindow nextWindow;

    @FXML
    private TextField studentId;

    public DeleteStudentController(){
        teacherControllerClass = new TeacherControllerClass();
        studentControllerClass = new StudentControllerClass();
        nextWindow = new NextWindow();

    }

    @FXML
    public void showStudentList(ActionEvent event){
        studentControllerClass.showStudentList(event);
    }

    @FXML
    public void showTeacherList(ActionEvent event){
        teacherControllerClass.showTeacherList(event);
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        studentControllerClass.deleteStudent(Integer.parseInt(studentId.getText()));
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
