package org.example.ordemservicodesktop.DAO;

import org.example.ordemservicodesktop.model.Funcionario;
import org.mindrot.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }

    private String selectAll = "select *from funcionario where LOWER(usuario_login) = LOWER(?);" ;


    public Optional<Funcionario> autentica(String username, String password) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(resultSet.getString("nome"));
                    funcionario.setUsuarioLogin(resultSet.getString("usuario_login"));
                    funcionario.setSenhaLogin(resultSet.getString("senha_login"));

                    if (BCrypt.checkpw(password, funcionario.getSenhaLogin())){
                        return Optional.of(funcionario);
                    }
                }
                return Optional.empty();
            // verifica se possui usuar
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
