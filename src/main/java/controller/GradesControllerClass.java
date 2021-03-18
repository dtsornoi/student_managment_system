package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Course;
import model.Grades;
import persistence.CourseRepository;
import persistence.GradesRepository;

import java.util.List;

public class GradesControllerClass {
    private GradesRepository gradesRepository;
    private NextWindow nextWindow;
    private CourseRepository courseRepository;

    public GradesControllerClass() {
        gradesRepository = new GradesRepository();
        courseRepository = new CourseRepository();
        nextWindow = new NextWindow();
    }

    public void addGrade (Grades grades){
        gradesRepository.save(grades);
    }

    public void deleteGrade (int id){
        Grades grades = new Grades();
        grades.setGradeId(id);

        gradesRepository.delete(grades);
    }

    public List<Grades> listAllGrades(){
        return gradesRepository.allGrades();
    }

    public void showAllGrades(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/gradesList.fxml");
    }

    public Course findCourseByName(String name){
        Course course = new Course();
        course.setCourseName(name);
        return courseRepository.findCourseByName(course);
    }
}
