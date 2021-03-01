package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NextWindow {
    private Stage stage;
    private Scene scene;

    public void closeWindowAndOpenNext(ActionEvent actionEvent, String string){
        try {
            Node source = (Node) actionEvent.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            Parent root;
            scene = new Scene (FXMLLoader.load(getClass().getClassLoader().getResource(string)));
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
