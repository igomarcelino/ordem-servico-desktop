package org.example.ordemservicodesktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView imageViewLogo;

    @FXML
    private Button btnSair;




    public void initialize(URL url, ResourceBundle resourceBundle) {
        String urlImageLogo = getClass().getResource("/images/ordem-servico.png").toExternalForm();

        Image image = new Image(urlImageLogo);
        ImageView imageView = new ImageView();
        imageView.setImage(image);

    }


    /**
     * FXML EVENTS
     *
     * ==========================================================================================================
     * */

    @FXML
    private void fecharAplicacao(ActionEvent event){
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }

}
