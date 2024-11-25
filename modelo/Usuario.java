package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Integer id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private List<Usuario> amigos = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    // Construtor
    public Usuario(String nome, String username, String email, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }

    // Métodos para adicionar e gerenciar posts
    public void adicionarPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    // Métodos para gerenciar amigos
    public void adicionarAmigo(Usuario amigo) {
        if (!amigos.contains(amigo) && !amigo.equals(this)) {
            amigos.add(amigo);
            amigo.getAmigos().add(this);  // Amizade mútua
        }
    }

    public void removerAmigo(Usuario amigo) {
        if (amigos.contains(amigo)) {
            amigos.remove(amigo);
            amigo.getAmigos().remove(this);  // Remover a amizade do outro lado
        }
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Não há um getter público para senha, apenas um setter
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Validação de senha
    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // Método toString para exibir informações do usuário
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

    // Métodos equals e hashCode para comparar usuários e trabalhar com coleções
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id != null && id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
