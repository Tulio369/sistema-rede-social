package gerenciador;

import modelo.Usuario;
import exception.UsuarioException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrar(Usuario usuario) {
        // Validação
        if (usuario == null) throw new UsuarioException("Usuário inválido");
        usuario.setId(proximoId++);
        usuarios.add(usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public Usuario buscarPorUsername(String username) {
        return usuarios.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    public boolean atualizar(Usuario usuario) {
        Optional<Usuario> uOptional = usuarios.stream()
                .filter(u -> u.getId().equals(usuario.getId()))
                .findFirst();
        if (uOptional.isPresent()) {
            uOptional.get().setNome(usuario.getNome());
            uOptional.get().setEmail(usuario.getEmail());
            uOptional.get().setSenha(usuario.getSenha());
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
}

