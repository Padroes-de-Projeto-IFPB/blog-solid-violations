package br.edu.ifpb.padroes.modelo;

import java.util.Date;

public class PostagemResposta extends Postagem {

    private Date data;

    private Postagem postagem;

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
