package co.edu.uniquindio.taller2.taller2.model.ViewController;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import co.edu.uniquindio.taller2.taller2.model.ConfiguracionBiblioteca;
import co.edu.uniquindio.taller2.taller2.model.Prestamo;
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
    private List<Prestamo> listaPrestamos;
    private Map<String, Integer> prestamosPorLibro;
    private Map<String, Integer> prestamosPorCategoria;

    @FXML
    void OnActionConfiguracionSistema(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/taller2/taller2/ConfiguracionBibioteca.fxml")
            );
            Parent root = loader.load();
            ConfiguracionBibliotecaViewController controller = loader.getController();

            ConfiguracionBiblioteca biblioteca = ConfiguracionBiblioteca.getInstance();
            List<Prestamo> listaPrestamos = biblioteca.getListaPrestamos();

            Map<String, Integer> prestamosPorLibro = new HashMap<>();
            Map<String, Integer> prestamosPorCategoria = new HashMap<>();

            for (Prestamo p : listaPrestamos) {
                String titulo = p.getLibro().getTitulo();
                prestamosPorLibro.put(titulo, prestamosPorLibro.getOrDefault(titulo, 0) + 1);

                String categoria = p.getLibro().getCategoria();
                prestamosPorCategoria.put(categoria, prestamosPorCategoria.getOrDefault(categoria, 0) + 1);
            }
            controller.cargarReportes(listaPrestamos);
            controller.cargarBarChart(prestamosPorLibro);
            controller.cargarPieChart(prestamosPorCategoria);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Configuracion Biblioteca");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo abrir la ventana de Configuracion Biblioteca.");
            alert.showAndWait();
        }


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
