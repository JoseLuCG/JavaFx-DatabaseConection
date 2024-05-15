module com.app.javafxdatabaseconnection {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.app.javafxdatabaseconnection to javafx.fxml;
    exports com.app.javafxdatabaseconnection;
}