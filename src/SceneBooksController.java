import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class SceneBooksController {
    @FXML
    private TableView<Libro> tableView;
    @FXML
    private TableColumn<Libro, String> idtitlebook;
    @FXML
    private TableColumn<Libro, String> idautorbook;
    @FXML
    private TableColumn<Libro, Integer> idpagebook;
    @FXML
    private TableColumn<Libro, Integer> idcantbook;

    public void setBooks(List<Libro> libros) {
         // Configura las columnas para mostrar los datos relevantes
        idtitlebook.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        idautorbook.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        idpagebook.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumPaginas()).asObject());
        idcantbook.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCantidadDisp()).asObject());

        // Llena la TableView con los datos de libros
        tableView.getItems().setAll(libros);
    }
}
