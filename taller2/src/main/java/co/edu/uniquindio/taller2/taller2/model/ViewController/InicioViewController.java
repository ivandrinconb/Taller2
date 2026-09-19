package co.edu.uniquindio.taller2.taller2.model.ViewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnConfiguracionSistema;

    @FXML
    private Button btnGestionLibro;

    @FXML
    private Button btnGestionarPrestamo;

    @FXML
    private Button btnGestionarUsuario;

    @FXML
    void OnActionConfiguracionSistema(ActionEvent event) {

    }

    @FXML
    void OnActionGestionarLibro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/taller2/taller2/GestionarLibro.fxml")
            );
            Parent root = loader.load();
            GestionarLibroViewController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de libros");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo abrir la ventana de gestión de libros.");
            alert.showAndWait();
        }

    }

    @FXML
    void OnActionGestionarPrestamo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/taller2/taller2/GestionarPrestamo.fxml")
            );
            Parent root = loader.load();
            GestionarPrestamoViewController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Prestamos");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo abrir la ventana de gestión de Prestamos.");
            alert.showAndWait();
        }

    }

    @FXML
    void OnActionGestionarUsuario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/taller2/taller2/GestionarUsuario.fxml")
            );
            Parent root = loader.load();
            GestionarUsuarioViewController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Usuarios");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo abrir la ventana de gestión de usuarios.");
            alert.showAndWait();
        }

    }

    @FXML
    void initialize() {


    }

}
