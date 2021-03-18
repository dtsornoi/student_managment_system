package controller;

import gui.NextWindow;
import javafx.event.ActionEvent;
import model.Login;
import model.Person;
import persistence.LoginRepository;

public class LoginController {

    private LoginRepository loginRepository;
    private NextWindow nextWindow;

    public LoginController(){
        loginRepository = new LoginRepository();
        nextWindow = new NextWindow();
    }

    public boolean checkUsername(String username){
        if (loginRepository.findByUsername(username).getUsername().equals(username)){
            return true;
        }

        return false;
    }

    public boolean checkPassword(String password){
        if (loginRepository.findByPassword(password).getPassword().equals(password)){
            return true;
        }

        return false;
    }

    public void showStudentList(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/studentsList.fxml");
    }

    public void showLoginScreen(ActionEvent event){
        nextWindow.closeWindowAndOpenNext(event, "gui/login.fxml");
    }

}
