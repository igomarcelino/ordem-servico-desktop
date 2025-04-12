package org.example.ordemservicodesktop.DAO;

import org.example.ordemservicodesktop.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(Connection connection){
        this.connection = connection;
    }

    private String selectAll = "select *from funcionario";



    public boolean autentica(String username,
                              String password){
        List<Funcionario> funcionarioList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAll)){
            ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(resultSet.getString("nome"));
                    funcionario.setUsuarioLogin(resultSet.getString("usuario_login"));
                    funcionario.setSenhaLogin(resultSet.getString("senha_login"));
                    funcionarioList.add(funcionario);
                }
                 Optional<Funcionario> userLogin = funcionarioList.stream().
                        filter( f -> f.getUsuarioLogin().equalsIgnoreCase(username)).
                        findFirst();
                if (userLogin.isPresent()){
                    return userLogin.get().getSenhaLogin().equalsIgnoreCase(password);
                }else {
                    return false;
                }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
