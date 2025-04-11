package org.example.ordemservicodesktop.DAO;

import org.example.ordemservicodesktop.data.Conexao;

import java.sql.Connection;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(Connection connection){
        this.connection = connection;
    }

    private String selectAll = "select *from tbl_funcionario";



    private boolean autenticado(String username,
                                String password){

        return true;
    }
}
