package br.edu.ifpb.padroes.repository.usuario;

import br.edu.ifpb.padroes.factory.DBConnectionFactory;
import br.edu.ifpb.padroes.factory.SQLiteConnectionFactory;
import br.edu.ifpb.padroes.modelo.Usuario;
import br.edu.ifpb.padroes.repository.usuario.UsuarioDAO;
import br.edu.ifpb.padroes.service.usuario.UsuarioServiceImpl;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class UsuarioDAOSqlite implements UsuarioDAO {

    private String arquivoBanco;
    public UsuarioDAOSqlite(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
    }

    private Connection connect() {
        DBConnectionFactory factory = new SQLiteConnectionFactory();
        factory.connect(arquivoBanco);
        return null;
    }

    public void trataExcecao(Exception ex) {
        Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
    }

    @Override
    public void add(Usuario usuario) {
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

    @Override
    public void update(Usuario object) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public void delete(Usuario object) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public List<Usuario> list() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    @Override
    public Usuario get(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }
}
