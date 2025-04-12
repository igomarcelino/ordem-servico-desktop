package org.example.ordemservicodesktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.ordemservicodesktop.DAO.FuncionarioDAO;
import org.example.ordemservicodesktop.data.Conexao;
import org.example.ordemservicodesktop.model.Funcionario;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView imageViewLogo;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtSenha;




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

    @FXML
    private void logar(ActionEvent event){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(Conexao.conexaoSQL());
        boolean autenticado = funcionarioDAO.autentica(txtUsuario.getText(),txtSenha.getText());
        if (autenticado){
            JOptionPane.showMessageDialog(null,"Bem vindo " + txtUsuario.getText());
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/ordemservicodesktopfxmls/tela-principal.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                ((Stage)(((Node) event.getSource()).getScene().getWindow())).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            JOptionPane.showMessageDialog(null,"Usuario ou Senha Incorreto");
        }
    }


}
