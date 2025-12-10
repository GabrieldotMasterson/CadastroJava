package dao;

import java.sql.*;
import java.util.*;
import model.Pessoa;

public class PessoaDAO {

    // Inserir uma nova pessoa no banco de dados
    public void inserir(Pessoa p) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.executeUpdate();
        conn.close();
    }

    // Listar todas as pessoas do banco de dados
    public List<Pessoa> listar() throws SQLException {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        Connection conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Pessoa p = new Pessoa(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email")
            );
            lista.add(p);
        }
        conn.close();
        return lista;
    }

    // Atualizar os dados de uma pessoa
    public void atualizar(Pessoa p) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.setInt(3, p.getId());
        stmt.executeUpdate();
        conn.close();
    }

    // Excluir uma pessoa pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }
}