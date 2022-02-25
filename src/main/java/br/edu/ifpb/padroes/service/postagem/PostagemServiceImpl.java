package br.edu.ifpb.padroes.service.postagem;

import br.edu.ifpb.padroes.factory.PostagemDAOFactory;
import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemResposta;
import br.edu.ifpb.padroes.repository.postagem.PostagemDAO;

import java.util.Date;

public class PostagemServiceImpl implements PostagemService {

    private PostagemDAO postagemDAO = PostagemDAOFactory.create();

    @Override
    public void adicionarPostagem(Postagem postagem) {
        if (postagem.getPostagemTipo().equals(Postagem.PostagemTipo.PUBLICA)) {
            this.postagemDAO.addPostagemPublica(postagem);
        } else if (postagem.getPostagemTipo().equals(Postagem.PostagemTipo.PRIVADA)) {
            this.postagemDAO.addPostagemPrivada(postagem);
        }
    }

    @Override
    public void adicionarResposta(Postagem postagem, Postagem resposta) {
        PostagemResposta postagemResposta = new PostagemResposta();
        postagemResposta.setPostagem(postagem);
        postagemResposta.setUsuario(resposta.getUsuario());
        postagemResposta.setData(new Date());
        this.postagemDAO.addPostagemResposta(postagemResposta);
    }

    @Override
    public void removerPostagem(Postagem postagem) {
        this.postagemDAO.delete(postagem);
    }

    @Override
    public void atualizarPostagem(Postagem postagem) {
        this.postagemDAO.update(postagem);
    }



}
