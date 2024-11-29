package com.redesocial.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private static int contadorId = 1;  // Gerador de IDs único para todos os posts
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private List<Usuario> curtidas = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();
    private LocalDateTime dataPublicacao;

    // Construtor
    public Post(Usuario autor, String conteudo) {
        if (conteudo == null || conteudo.trim().isEmpty()) {
            throw new IllegalArgumentException("Conteúdo do post não pode ser vazio.");
        }

        if (conteudo.length() > 500) {
            throw new IllegalArgumentException("Conteúdo do post não pode ter mais de 100 caracteres.");
        }
        this.id = contadorId++;  // Atribui o próximo ID disponível
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataPublicacao = LocalDateTime.now();  // Define a data de publicação como o momento atual
        this.curtidas = new ArrayList<>();  // Inicializa a lista de curtidas
        this.comentarios = new ArrayList<>();   // Inicializa a lista de comentários
    }


    // Getters, setters e toString()
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContadorId() {
        return contadorId;
    }

    public void setContadorId(int contadorId) {
        Post.contadorId = contadorId;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        if (conteudo == null || conteudo.trim().isEmpty()) {
            throw new IllegalArgumentException("Conteúdo do post não pode ser vazio.");
        }

        if (conteudo.length() > 500) {
            throw new IllegalArgumentException("Conteúdo do post não pode ter mais de 500 caracteres.");
        }

        this.conteudo = conteudo;
    }
    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }
    public List<Usuario> getCurtidas() {
        return curtidas;
    }
    public List<Comentario> getComentarios() {
        return comentarios;
    }
    // Método para exibir informações básicas do post
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", autor=" + autor.getUsername() +
                ", conteudo='" + conteudo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }

    // Método para adicionar uma curtida ao post
    public void adicionarCurtida(Usuario usuario) {
        if (!curtidas.contains(usuario)) {
            curtidas.add(usuario);
            System.out.println(usuario.getNome() + " curtiu o post.");
        } else {
            System.out.println(usuario.getNome() + " já curtiu este post.");
        }
    }
    public void removerCurtida(Usuario usuario) {
        curtidas.remove(usuario);
    }
    

    // Método para adicionar um comentário ao post
    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
        System.out.println("Comentário adicionado: " + comentario.getConteudo());
    }
    
    public void removerComentario(Comentario comentario) {
        comentarios.remove(comentario);
    }
}



