import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene_Books(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_Books.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_Docs(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_Docs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_Magazines(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_Magazines.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
