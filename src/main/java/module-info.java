module com.app.javafxdatabaseconnection {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.base;

    opens com.app.javafxdatabaseconnection to javafx.fxml;
    opens com.dependences.Database to java.base;
    //opens com.dependences.Models to java.base;
    opens com.dependences.Models to javafx.base;
    opens com.dependences.Tools to java.base;
    exports com.app.javafxdatabaseconnection;
}