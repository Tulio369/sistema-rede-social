package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private Integer id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private List<Usuario> amigos = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public Usuario(String nome, String username, String email, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters, setters, toString(), equals() e hashCode()

    public void adicionarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    public void removerAmigo(Usuario amigo) {
        amigos.remove(amigo);
    }

    public void adicionarPost(Post post) {
        posts.add(post);
    }
}

