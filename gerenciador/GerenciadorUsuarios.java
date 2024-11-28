package gerenciador;

import modelo.Usuario;
import exception.UsuarioException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    // Método para cadastrar um novo usuário
    public void cadastrar(Usuario usuario) {
        if (usuario == null) throw new UsuarioException("Usuário inválido");
        usuario.setId(proximoId++);
        usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso! ID: " + usuario.getId());

    }

    // Método para buscar um usuário por ID
    public Usuario buscarPorId(int id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    // Método para buscar um usuário por nome de usuário (username)
    public Usuario buscarPorUsername(String username) {
        return usuarios.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    // Método para buscar usuários pelo nome
    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    // Método para atualizar informações de um usuário
    public boolean atualizar(Usuario usuario) {
        Optional<Usuario> uOptional = usuarios.stream()
                .filter(u -> u.getId().equals(usuario.getId()))
                .findFirst();
        if (uOptional.isPresent()) {
            Usuario existente = uOptional.get();

            // Atualiza os dados do usuário
            existente.setNome(usuario.getNome());
            existente.setEmail(usuario.getEmail());

            // Atualiza a senha somente se uma nova senha for definida (verifica se não está vazia ou nula)
            if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
                // Aqui, o método setSenha é chamado para atualizar a senha
                existente.setSenha(usuario.getSenha());  // Atualiza a senha usando setSenha
            }

            return true;
        }
        return false;
    }

    // Método para deletar um usuário por ID
    public boolean deletar(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    // Método para adicionar amizade entre dois usuários pelo ID
    public boolean adicionarAmizade(int idUsuario1, int idUsuario2) {
        Usuario usuario1 = buscarPorId(idUsuario1);
        Usuario usuario2 = buscarPorId(idUsuario2);

        // Verifica se ambos os usuários existem e se ainda não são amigos
        if (usuario1 != null && usuario2 != null && !usuario1.getAmigos().contains(usuario2)) {
            usuario1.adicionarAmigo(usuario2);
            usuario2.adicionarAmigo(usuario1); // Adiciona mutuamente
            return true;
        }
        return false;
    }

    // Método para listar todos os usuários cadastrados
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}

