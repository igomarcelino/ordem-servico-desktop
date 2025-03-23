package org.example.ordemservicodesktop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView logoEntidades;
    @FXML
    private ImageView logoOrdens;
    @FXML
    private ImageView logoRelatorios;
    @FXML
    private ImageView logoSair;
    @FXML
    private VBox box;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String logoCLiente = getClass().getResource("/images/921347.png").toExternalForm();
        Image imagemCliente = new Image(logoCLiente);
        logoEntidades = new ImageView();
        logoEntidades.setImage(imagemCliente);
    }

}
