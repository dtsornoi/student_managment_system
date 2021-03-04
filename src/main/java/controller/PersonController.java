package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Person;
import persistence.PersonRepository;

import java.util.List;

public class PersonController {
    private PersonRepository personRepository;
    private NextWindow nextWindow;

    public PersonController (){
        personRepository = new PersonRepository();
        nextWindow = new NextWindow();
    }

    public void addNewPerson(Person person){
        personRepository.save(person);
    }

    public void deletePerson(int id){
        Person person = new Person();
        person.setId(id);
        personRepository.delete(person);
    }

    public List<Person> listAllStudents(){
        return personRepository.allStudents();
    }

    public List<Person> listAllTeachers(){
        return personRepository.allTeachers();
    }

    public void showStudentList(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

    public void showTeacherList(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/teachersList.fxml");
    }

    public Person findTeacherByName(String name){
        Person teacher = new Person();
        teacher.setFirstName(name);
        return personRepository.findTeacherByName(teacher);
    }
}
