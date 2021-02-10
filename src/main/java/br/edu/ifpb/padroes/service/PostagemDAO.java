package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemResposta;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class PostagemDAO {

    private String arquivoBanco;

    public PostagemDAO(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
    }

    private Connection connect() {
        // TODO candidato para inversão de dependência criar classe Abstrata AbstractDAO<T>
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:"+this.arquivoBanco)) {
            Statement statement = connection.createStatement();

            //Criando tabela de usuários
            statement.execute("CREATE TABLE IF NOT EXISTS POSTAGEM( ID INTEGER, TITULO VARCHAR, USUARIO_ID VARCHAR, MENSAGEM VARCHAR, TIPO VARCHAR )");

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void addPostagemPublica(Postagem postagem) {
        Connection conexao = connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO POSTAGEM( ID, TITULO, USUARIO_ID, MENSAGEM, TIPO) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setLong(1, postagem.getId());
            stmt.setString(2, postagem.getTitulo());
            stmt.setLong(3, postagem.getUsuario().getId());
            stmt.setString(4, postagem.getMensagem());
            stmt.setString(5, Postagem.PostagemTipo.PUBLICA.toString());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    public void addPostagemPrivada(Postagem postagem) {
        Connection conexao = connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO POSTAGEM( ID, TITULO, USUARIO_ID, MENSAGEM, TIPO) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setLong(1, postagem.getId());
            stmt.setString(2, postagem.getTitulo());
            stmt.setLong(3, postagem.getUsuario().getId());
            stmt.setString(4, postagem.getMensagem());
            stmt.setString(5, Postagem.PostagemTipo.PRIVADA.toString());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    public void addPostagemResposta(PostagemResposta postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public void updatePostagem(Postagem postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public void deletePostagem(Postagem postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public List<Postagem> listPostagens() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public Postagem getPostagem(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public void trataExcecao(Exception ex) {
        Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
    }


}
