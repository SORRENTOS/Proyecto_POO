import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Documento> TablaDocumentos;
    @FXML
    private TableColumn<Documento, String> TituloDocs;
    @FXML
    private TableColumn<Documento, String> PublisherDocs;
    @FXML
    private TableColumn<Documento, Integer> PagDocs;
    @FXML
    private TableColumn<Documento, Integer> CantDocs; 
    
    @FXML
    private TableView<Libro> TablaBook;
    @FXML
    private TableColumn<Libro, String> TituloBook;
    @FXML
    private TableColumn<Libro, String> AuthorBook;
    @FXML
    private TableColumn<Libro, Integer> PagBook;
    @FXML
    private TableColumn<Libro, Integer> CantBook;

    @FXML
    private TableView<Revista> TablaMag;
    @FXML
    private TableColumn<Revista, String> TituloMag;
    @FXML
    private TableColumn<Revista, Integer> PagMag;
    @FXML
    private TableColumn<Revista, Integer> CantMag;
    @FXML
    private TableColumn<Revista, Integer> DescMag;

    private Database database = new Database();

    public void switchToScene_Init(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_StartUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_Books(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene_Books.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        SceneController controller = loader.getController();
        controller.initializeBookScene();;
    }

    public void switchToScene_Docs(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene_Docs.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        SceneController controller = loader.getController();
        controller.initializeDocsScene();
    }

    public void switchToScene_Magazines(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene_Magazines.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        SceneController controller = loader.getController();
        controller.initializeMagScene();
    }
    public void closeWindow(ActionEvent event)throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void closeApp(ActionEvent event) {
    Platform.exit();
    }

    public void Add_Book(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_AddBook.fxml"));
        Stage popupStage = new Stage();
        scene = new Scene(root);
        popupStage.setScene(scene);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        popupStage.showAndWait();
    }

    public void confirmAdd_Book(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void Add_Doc(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_AddDoc.fxml"));
        Stage popupStage = new Stage();
        scene = new Scene(root);
        popupStage.setScene(scene);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        popupStage.showAndWait();
    }
    
    public void confirmAdd_Doc(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void Add_Mag(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene_AddMag.fxml")); 
        Stage popupStage = new Stage();
        scene = new Scene(root);
        popupStage.setScene(scene);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        popupStage.showAndWait();
    }
    
    public void confirmAdd_Mag(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void initializeDocsScene() {
        TituloDocs.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        PublisherDocs.setCellValueFactory(new PropertyValueFactory<>("publicador"));
        PagDocs.setCellValueFactory(new PropertyValueFactory<>("numPaginas"));
        CantDocs.setCellValueFactory(new PropertyValueFactory<>("cantidadDisp"));

        ObservableList<Documento> documentos = FXCollections.observableArrayList(database.getAllDocumentos());
        TablaDocumentos.setItems(documentos);
    }
    private void initializeBookScene() {
        TituloBook.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        AuthorBook.setCellValueFactory(new PropertyValueFactory<>("autor"));
        PagBook.setCellValueFactory(new PropertyValueFactory<>("numPaginas"));
        CantBook.setCellValueFactory(new PropertyValueFactory<>("cantidadDisp"));

        ObservableList<Libro> libros = FXCollections.observableArrayList(database.getAllLibros());
        TablaBook.setItems(libros);;
    }
    private void initializeMagScene() {
        TituloMag.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        PagMag.setCellValueFactory(new PropertyValueFactory<>("numPaginas"));
        CantMag.setCellValueFactory(new PropertyValueFactory<>("cantidadDisp"));
        DescMag.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        ObservableList<Revista> revistas = FXCollections.observableArrayList(database.getAllRevistas());
        TablaMag.setItems(revistas);
    }

}
