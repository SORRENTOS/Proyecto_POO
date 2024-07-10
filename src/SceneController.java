import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    public void closeWindow(ActionEvent event)throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void closeApp(ActionEvent event) {
    Platform.exit();
    }

    public void Add_Book(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_AddBook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void confirmAdd_Book(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void Add_Doc(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_AddDoc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    
    public void confirmAdd_Doc(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void Add_Mag(ActionEvent event )throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_AddDoc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    
    public void confirmAdd_Mag(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }


}
