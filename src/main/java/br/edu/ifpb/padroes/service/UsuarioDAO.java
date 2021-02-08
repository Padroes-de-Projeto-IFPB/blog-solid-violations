package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.modelo.Usuario;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class UsuarioDAO {

    private String arquivoBanco;
    public UsuarioDAO(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
    }

    private Connection connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:"+this.arquivoBanco)) {
            Statement statement = connection.createStatement();

            //Criando tabela de usuários
            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO( ID INTEGER, NOME VARCHAR, LOGIN VARCHAR, SENHA VARCHAR )");
            statement.execute("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (1, 'admin', 'admin', '123')");

            //Criando tabela de produtos
            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO( ID INTEGER, NOME VARCHAR, LOGIN VARCHAR, SENHA VARCHAR )");
            statement.execute("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (1, 'admin', 'admin', '123')");

            PreparedStatement stmt = connection.prepareStatement("select * from USUARIO");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");

                System.out.println( id + " - " + nome);
            }

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void addUsuario(Usuario usuario) {
        Connection conexao = connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (?, ?, ?, ?)")) {
            stmt.setLong(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    public void updateUsuario(Usuario usuario) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public void deleteUsuario(Usuario usuario) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public List<Usuario> listUsuarios() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public Usuario getUsuario(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public void trataExcecao(Exception ex) {
        Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
    }


}
