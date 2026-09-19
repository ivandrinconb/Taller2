package co.edu.uniquindio.taller2.taller2.model.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.taller2.taller2.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionarUsuarioViewController {

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
    private TableView<Usuario> tableUsuarios;

    @FXML
    private TableColumn<Usuario, String> tcId;

    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    void OnActionAgregar(ActionEvent event) {
        Usuario nuevo = new Usuario(txtId.getText(), txtNombre.getText());
        listaUsuarios.add(nuevo);
        limpiarCampos();

    }

    @FXML
    void OnActionEditar(ActionEvent event) {
        Usuario seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setId(txtId.getText());
            seleccionado.setNombre(txtNombre.getText());
            tableUsuarios.refresh();
            limpiarCampos();
        }

    }

    @FXML
    void OnActionEliminar(ActionEvent event) {
        Usuario seleccionado = tableUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaUsuarios.remove(seleccionado);
            limpiarCampos();
        }

    }
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        tableUsuarios.setItems(listaUsuarios);

        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtId.setText(newSelection.getId());
                txtNombre.setText(newSelection.getNombre());
            }
        });

    }
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        tableUsuarios.getSelectionModel().clearSelection();
    }

}
