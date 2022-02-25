package br.edu.ifpb.padroes.repository.postagem;

import br.edu.ifpb.padroes.factory.DBConnectionFactory;
import br.edu.ifpb.padroes.factory.MongoDBConnectionFactory;
import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.service.usuario.UsuarioServiceImpl;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class PostagemDAOMongo implements PostagemDAO {

    private String arquivoBanco;
    public PostagemDAOMongo(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
    }

    private Connection connect() {
        DBConnectionFactory factory = new MongoDBConnectionFactory();
        factory.connect(arquivoBanco);
        return null;
    }

    @Override
    public void addPostagemPublica(Postagem postagem) {
        postagem.setPostagemTipo(Postagem.PostagemTipo.PUBLICA);
        addPostagem(postagem);
    }

    private void addPostagem(Postagem postagem) {
        Connection conexao = connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO POSTAGEM( ID, TITULO, USUARIO_ID, MENSAGEM, TIPO) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setLong(1, postagem.getId());
            stmt.setString(2, postagem.getTitulo());
            stmt.setLong(3, postagem.getUsuario().getId());
            stmt.setString(4, postagem.getMensagem());
            stmt.setString(5, postagem.getPostagemTipo().toString());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    @Override
    public void addPostagemPrivada(Postagem postagem) {
        postagem.setPostagemTipo(Postagem.PostagemTipo.PRIVADA);
        addPostagem(postagem);
    }

    @Override
    public void addPostagemResposta(Postagem postagem) {
    }

    public void trataExcecao(Exception ex) {
        Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
    }

    @Override
    public void add(Postagem object) {

    }

    @Override
    public void update(Postagem object) {

    }

    @Override
    public void delete(Postagem object) {

    }

    @Override
    public List<Postagem> list() {
        return null;
    }

    @Override
    public Postagem get(Long id) {
        return null;
    }
}
