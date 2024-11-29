package com.redesocial.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa um usuário da rede social.
 */
public class Usuario {
    private Integer id;
    private String nome;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private List<Usuario> amigos;
    private List<Post> posts;   // Lista de posts deve ser inicializada

    /**
     * Construtor da classe Usuario.
     * @param nome Nome do usuário.
     * @param username Nome de usuário (username) único.
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     */
    public Usuario(String nome, String username, String email, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
        this.amigos = new ArrayList<>();  // Inicializando a lista de amigos
        this.posts = new ArrayList<>();   // Inicializando a lista de posts
    }

    // Métodos para adicionar e gerenciar posts
    public void adicionarPost(Post post) {
        posts.add(post);
    }

    public <Post> List<Post> getPosts() {
        return (List<Post>) posts;
    }

    // Métodos para gerenciar amigos
    /**
     * Adiciona um amigo à lista de amigos do usuário.
     * @param amigo O usuário a ser adicionado como amigo.
     */
    public void adicionarAmigo(Usuario amigo) {
        if (!amigos.contains(amigo)){
            amigos.add(amigo);
            amigo.getAmigos().add(this);  // Amizade mútua
        }
    }
    /**
     * Remove um amigo da lista de amigos do usuário.
     * @param amigo O usuário a ser removido da lista de amigos.
     */
    public void removerAmigo(Usuario amigo) {
        if (amigos.contains(amigo)) {
            amigos.remove(amigo);
            amigo.getAmigos().remove(this);  // Remover a amizade
        }
    }

    // Getters e Setters
    public List<Usuario> getAmigos() {
        return amigos;
    }
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
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public List<Post> getPosts() {
        return posts;
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
        return Objects.equals(id,usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getSenha() {
        return senha;
    }
}
