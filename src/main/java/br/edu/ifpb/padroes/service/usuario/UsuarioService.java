package br.edu.ifpb.padroes.service.usuario;

import br.edu.ifpb.padroes.modelo.Usuario;

import java.util.List;

public interface UsuarioService {
    void criarUsuario(Usuario usuario);
    void atualizarUsuario(Usuario usuario);
    void removerUsuario(Usuario usuario);
    List<Usuario> listarUsuarios(Usuario usuario);
    Usuario recuperarUsuario(Long id);
}
