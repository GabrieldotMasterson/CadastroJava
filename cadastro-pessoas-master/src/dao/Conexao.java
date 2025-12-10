package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro";
    private static final String USER = "root"; //usuario worbanch
    private static final String PASSWORD = "@22gabriel22";//senha worbanch

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
} 