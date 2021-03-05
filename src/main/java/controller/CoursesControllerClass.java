package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Course;
import persistence.CourseRepository;


import java.util.ArrayList;
import java.util.List;

public class CoursesControllerClass {
    private CourseRepository courseRepository;
    private NextWindow nextWindow;

    public CoursesControllerClass() {
        courseRepository = new CourseRepository();
        nextWindow = new NextWindow();
    }

    public void addNewCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse(int id){
        Course course = new Course();
        course.setCourseId(id);

       courseRepository.delete(course);
    }

    public List<Course> listAllCourses(){
        return courseRepository.allCourses();
    }

    public void showAllCourses(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event,"gui/coursesList.fxml");
    }
}
