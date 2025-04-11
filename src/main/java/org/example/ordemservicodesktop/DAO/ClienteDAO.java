package org.example.ordemservicodesktop.DAO;

import java.sql.Connection;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection){
        this.connection = connection;
    }

    private static String selectAll = "select *from tbl_cliente";

}
