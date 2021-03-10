package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Grades;
import persistence.GradesRepository;

import java.util.List;

public class GradesControllerClass {
    private GradesRepository gradesRepository;
    private NextWindow nextWindow;

    public GradesControllerClass() {
        gradesRepository = new GradesRepository();
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
}
