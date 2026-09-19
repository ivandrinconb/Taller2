module co.edu.uniquindio.taller2.taller2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.taller2.taller2 to javafx.fxml;
    exports co.edu.uniquindio.taller2.taller2;
}