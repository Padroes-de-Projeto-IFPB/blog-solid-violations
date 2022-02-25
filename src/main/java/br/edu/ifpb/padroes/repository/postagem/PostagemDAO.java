package br.edu.ifpb.padroes.repository.postagem;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.repository.DAO;

public interface PostagemDAO extends DAO<Postagem, Long> {
    void addPostagemPublica(Postagem postagem);
    void addPostagemPrivada(Postagem postagem);
    void addPostagemResposta(Postagem postagem);
}
