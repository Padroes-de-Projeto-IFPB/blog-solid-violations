package br.edu.ifpb.padroes.service.usuario;

import br.edu.ifpb.padroes.modelo.Usuario;
import br.edu.ifpb.padroes.repository.usuario.UsuarioDAO;
import br.edu.ifpb.padroes.repository.usuario.UsuarioDAOSqlite;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAOSqlite("banco.db");

    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioDAO.add(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios(Usuario usuario) {
        return usuarioDAO.list();
    }

    @Override
    public Usuario recuperarUsuario(Long id) {
        return usuarioDAO.get(id);
    }

}
