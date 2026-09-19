package co.edu.uniquindio.taller2.taller2.model.ViewController;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import co.edu.uniquindio.taller2.taller2.model.Prestamo;
import co.edu.uniquindio.taller2.taller2.model.ReporteUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConfiguracionBibliotecaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> BarLibrosPrestados;

    @FXML
    private TableView<ReporteUsuario> TableReportes;

    @FXML
    private Button btnGuardar;

    @FXML
    private CheckBox checkRenovaciones;

    @FXML
    private CheckBox checkReservas;

    @FXML
    private PieChart pieCategoria;

    @FXML
    private Spinner<Integer> spinnerDiasPermitidos;

    @FXML
    private Spinner<Integer> spinnerPrestamosUsuario;

    @FXML
    private TableColumn<ReporteUsuario, Integer> tcLibros;

    @FXML
    private TableColumn<ReporteUsuario, Integer> tcPrestamos;

    @FXML
    private TableColumn<ReporteUsuario, Integer> tcRetrasos;

    @FXML
    private TableColumn<ReporteUsuario, String> tcUsuario;
    @FXML
    private TextArea txtInfo;

    @FXML
    void OnActionGuardar(ActionEvent event) {
        int maxPrestamos = (int) spinnerPrestamosUsuario.getValue();
        int diasPrestamo = (int) spinnerDiasPermitidos.getValue();
        boolean permitirReservas = checkReservas.isSelected();
        boolean permitirRenovaciones = checkRenovaciones.isSelected();

        String configuracion = "Configuración actual:\n" +
                "Máx. préstamos: " + maxPrestamos + "\n" +
                "Días préstamo: " + diasPrestamo + "\n" +
                "Reservas: " + (permitirReservas ? "Sí" : "No") + "\n" +
                "Renovaciones: " + (permitirRenovaciones ? "Sí" : "No");

        txtInfo.setText(configuracion);
    }

    @FXML
    void initialize() {
        spinnerPrestamosUsuario.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinnerDiasPermitidos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));

        checkReservas.setSelected(true);
        checkRenovaciones.setSelected(false);

        tcUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tcPrestamos.setCellValueFactory(new PropertyValueFactory<>("prestamos"));
        tcLibros.setCellValueFactory(new PropertyValueFactory<>("libros"));
        tcRetrasos.setCellValueFactory(new PropertyValueFactory<>("retrasos"));

        TableReportes.setItems(FXCollections.observableArrayList());

        BarLibrosPrestados.getData().clear();
        pieCategoria.getData().clear();
    }

    public void cargarReportes(List<Prestamo> prestamos) {
        if (prestamos == null) {
            TableReportes.setItems(FXCollections.observableArrayList());
            return;
        }
        ObservableList<ReporteUsuario> listaReportes = FXCollections.observableArrayList();
        for (Prestamo p : prestamos) {
            listaReportes.add(new ReporteUsuario(
                    p.getUsuario().getNombre(),
                    1,
                    1,
                    p.isRetrasado() ? 1 : 0
            ));
        }
        TableReportes.setItems(listaReportes);
    }
    public void cargarBarChart(Map<String, Integer> prestamosPorLibro) {
        BarLibrosPrestados.getData().clear();
        if (prestamosPorLibro == null || prestamosPorLibro.isEmpty()) {
            return; // no hay datos, gráfico vacío
        }

        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName("Libros más prestados");

        for (Map.Entry<String, Integer> entry : prestamosPorLibro.entrySet()) {
            serie.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        BarLibrosPrestados.getData().setAll(serie);
    }

    public void cargarPieChart(Map<String, Integer> prestamosPorCategoria) {
        pieCategoria.getData().clear();
        if (prestamosPorCategoria == null || prestamosPorCategoria.isEmpty()) {
            return; // no hay datos, gráfico vacío
        }

        for (Map.Entry<String, Integer> entry : prestamosPorCategoria.entrySet()) {
            pieCategoria.getData().add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
    }
}
