module com.espol.proyecto2_estructuras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.proyecto2_estructuras to javafx.fxml;
    exports com.espol.proyecto2_estructuras;
}
