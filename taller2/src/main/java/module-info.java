module co.edu.uniquindio.taller2.taller2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    exports co.edu.uniquindio.taller2.taller2;
    opens co.edu.uniquindio.taller2.taller2 to javafx.fxml;

    exports co.edu.uniquindio.taller2.taller2.model.ViewController;
    opens co.edu.uniquindio.taller2.taller2.model.ViewController to javafx.fxml;

    exports co.edu.uniquindio.taller2.taller2.model;
    opens co.edu.uniquindio.taller2.taller2.model to javafx.base;
}