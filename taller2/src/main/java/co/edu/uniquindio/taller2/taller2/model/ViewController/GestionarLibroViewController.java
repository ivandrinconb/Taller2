package co.edu.uniquindio.taller2.taller2.model.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.taller2.taller2.model.ConfiguracionBiblioteca;
import co.edu.uniquindio.taller2.taller2.model.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionarLibroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGuardar;

    @FXML
    private CheckBox checkDisponible;

    @FXML
    private TableView<Libro> tableGestionLibros;

    @FXML
    private TableColumn<Libro, String> tcAutor;

    @FXML
    private TableColumn<Libro, String> tcCategoria;

    @FXML
    private TableColumn<Libro, String> tcCodigo;

    @FXML
    private TableColumn<Libro, String> tcDisponible;

    @FXML
    private TableColumn<Libro, String> tcTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtTitulo;

    @FXML
    private Button btnClonar;

    private ObservableList<Libro> listaLibros = ConfiguracionBiblioteca.getInstance().getListaLibros();

    @FXML
    void OnActionClonar(ActionEvent event) {
        Libro seleccionado = (Libro) tableGestionLibros.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Libro copia = seleccionado.clonar();
            copia.setCodigo(seleccionado.getCodigo() + "_copy");
            listaLibros.add(copia);
        }

    }

    @FXML
    void OnActionGuardar(ActionEvent event) {
        Libro nuevo = new Libro(
                txtCodigo.getText(),
                txtTitulo.getText(),
                txtAutor.getText(),
                txtCategoria.getText(),
                checkDisponible.isSelected()
        );

        listaLibros.add(nuevo);
        limpiarCampos();

    }
    private void limpiarCampos() {
        txtCodigo.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtCategoria.clear();
        checkDisponible.setSelected(false);
    }


    @FXML
    void initialize() {
        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tcAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        tcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tcDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));


        tableGestionLibros.setItems(listaLibros);


    }

}

