module org.example.ordemservicodesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.ordemservicodesktop to javafx.fxml;
    exports org.example.ordemservicodesktop;
    exports org.example.ordemservicodesktop.controllers;
    opens org.example.ordemservicodesktop.controllers to javafx.fxml;
}