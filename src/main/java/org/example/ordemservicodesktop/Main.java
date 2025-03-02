package org.example.ordemservicodesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {



        try {
            URL fxmlLocation = getClass().getResource("/org/example/ordemservicodesktopfxmls/login.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setTitle("Login - Ordem de Serviço");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    }

