package gui;

import controller.LoginController;

import controller.PersonController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginControllerGui implements Initializable {
    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private final Alert alert = new Alert(Alert.AlertType.NONE);

    private final LoginController loginController;
    private final PersonController personController;

    public LoginControllerGui(){
        loginController = new LoginController();
        personController = new PersonController();
    }

    @FXML
    private void onSubmit(ActionEvent event){
        try {
            if (!alert.isShowing()) {
                if (checkUserInput()) {
                    personController.showTeacherList(event);
                }
            } else {
                usernameOrPasswordError("Wrong Username Or Password");
            }
        }catch (Exception e){
            usernameOrPasswordError("No Such User");
        }
    }

    private void usernameOrPasswordError(String message) {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    private boolean checkUserInput(){
        return loginController
                .checkUsername(usernameInput.getText())
                && loginController
                    .checkPassword(passwordInput.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
