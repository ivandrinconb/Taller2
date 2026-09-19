package co.edu.uniquindio.taller2.taller2.model.ViewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.taller2.taller2.model.ConfiguracionBiblioteca;
import co.edu.uniquindio.taller2.taller2.model.Libro;
import co.edu.uniquindio.taller2.taller2.model.Prestamo;
import co.edu.uniquindio.taller2.taller2.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionarPrestamoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEliminar;

    @FXML
    private ChoiceBox<Libro> cbLibro;

    @FXML
    private ChoiceBox<Usuario> cbUsuario;

    @FXML
    private DatePicker dateFechaDevolucion;

    @FXML
    private DatePicker dateFechaPrestamo;

    @FXML
    private TableView<Prestamo> tablePrestamo;

    @FXML
    private TableColumn<Prestamo, Boolean> tcDisponible;

    @FXML
    private TableColumn<Prestamo, DatePicker> tcFechaDevolucion;

    @FXML
    private TableColumn<Prestamo, DatePicker> tcFechaPrestamo;

    @FXML
    private TableColumn<Prestamo, Libro> tcLibro;

    @FXML
    private TableColumn<Prestamo, Usuario> tcUsuario;

    private ObservableList<Prestamo> listaPrestamos = ConfiguracionBiblioteca.getInstance().getListaPrestamos();
    @FXML
    void OnActionAgregar(ActionEvent event) {
        Usuario usuario = cbUsuario.getValue();
        Libro libro = cbLibro.getValue();
        LocalDate fechaPrestamo = dateFechaPrestamo.getValue();
        LocalDate fechaDevolucion = dateFechaDevolucion.getValue();

        if (usuario != null && libro != null && fechaPrestamo != null && fechaDevolucion != null && libro.isDisponible()) {
            Prestamo nuevo = new Prestamo(usuario, libro, fechaPrestamo, fechaDevolucion, true);
            ConfiguracionBiblioteca.getInstance().getListaPrestamos().add(nuevo);
            libro.setDisponible(false);
            limpiarCampos();
        }

    }

    @FXML
    void OnActionEditar(ActionEvent event) {
        Prestamo seleccionado = tablePrestamo.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setUsuario(cbUsuario.getValue());
            seleccionado.setLibro(cbLibro.getValue());
            seleccionado.setFechaPrestamo(dateFechaPrestamo.getValue());
            seleccionado.setFechaDevolucion(dateFechaDevolucion.getValue());
            tablePrestamo.refresh();
            limpiarCampos();
        }

    }

    @FXML
    void OnActionEliminar(ActionEvent event) {
        Prestamo seleccionado = tablePrestamo.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.getLibro().setDisponible(true);
            ConfiguracionBiblioteca.getInstance().getListaPrestamos().remove(seleccionado);
            limpiarCampos();
        }

    }

    @FXML
    void initialize() {
        tcUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tcLibro.setCellValueFactory(new PropertyValueFactory<>("libro"));
        tcFechaPrestamo.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        tcFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        tcDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        tablePrestamo.setItems(ConfiguracionBiblioteca.getInstance().getListaPrestamos());
        cbUsuario.setItems(ConfiguracionBiblioteca.getInstance().getListaUsuarios());
        cbLibro.setItems(ConfiguracionBiblioteca.getInstance().getListaLibros());

        tablePrestamo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                cbUsuario.setValue(newSelection.getUsuario());
                cbLibro.setValue(newSelection.getLibro());
                dateFechaPrestamo.setValue(newSelection.getFechaPrestamo());
                dateFechaDevolucion.setValue(newSelection.getFechaDevolucion());
            }
        });

    }
    private void limpiarCampos() {
        cbUsuario.setValue(null);
        cbLibro.setValue(null);
        dateFechaPrestamo.setValue(null);
        dateFechaDevolucion.setValue(null);
        tablePrestamo.getSelectionModel().clearSelection();
    }

}
