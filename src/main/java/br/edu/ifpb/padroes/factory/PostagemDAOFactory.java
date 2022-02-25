package br.edu.ifpb.padroes.factory;

import br.edu.ifpb.padroes.repository.postagem.PostagemDAO;
import br.edu.ifpb.padroes.repository.postagem.PostagemDAOMongo;
import br.edu.ifpb.padroes.repository.postagem.PostagemDAOSqlite;

public class PostagemDAOFactory {

    public enum TipoBanco { MONGODB, SQLITE }

    public static PostagemDAO create() {
        return new PostagemDAOMongo("mongo.db");
    }

    public static PostagemDAO create(TipoBanco tipo) {
        if (tipo == TipoBanco.MONGODB) {
            return new PostagemDAOMongo("mongo.db");
        } else if (tipo == TipoBanco.SQLITE ){
            return new PostagemDAOSqlite("arquivo.db");
        }
        return null;
    }

}
