package gui;

import controller.CoursesControllerClass;
import controller.GradesControllerClass;
import controller.PersonController;
import javafx.event.ActionEvent;

public class Menu{
    private final PersonController personController;
    private final CoursesControllerClass coursesControllerClass;
    private final GradesControllerClass gradesControllerClass;

    public Menu(){
        personController = new PersonController();
        coursesControllerClass = new CoursesControllerClass();
        gradesControllerClass = new GradesControllerClass();
    }

    public void showStudentList(ActionEvent event) {
        personController.showStudentList(event);
    }

    public void showTeacherList(ActionEvent event) {
        personController.showTeacherList(event);
    }

    public void showAllCourses(ActionEvent event){
        coursesControllerClass.showAllCourses(event);
    }

    public void showAllGrades(ActionEvent event){
        gradesControllerClass.showAllGrades(event);
    }
}
