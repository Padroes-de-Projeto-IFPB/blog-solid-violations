package br.edu.ifpb.padroes.factory;

import br.edu.ifpb.padroes.repository.postagem.PostagemDAO;
import br.edu.ifpb.padroes.repository.postagem.PostagemDAOMongo;
import br.edu.ifpb.padroes.repository.postagem.PostagemDAOSqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnectionFactory implements DBConnectionFactory {

    @Override
    public void connect(String arquivoBanco) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:"+arquivoBanco)) {
            Statement statement = connection.createStatement();

            //Criando tabela de usuários
            statement.execute("CREATE TABLE IF NOT EXISTS POSTAGEM( ID INTEGER, TITULO VARCHAR, USUARIO_ID VARCHAR, MENSAGEM VARCHAR, TIPO VARCHAR )");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
