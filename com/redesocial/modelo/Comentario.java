package com.redesocial.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Comentario {
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataComentario;
    private List<Post> post;

    public Comentario(Integer id, Usuario autor, String conteudo,
                      List<Post> post) {
        // Construtor
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataComentario = LocalDateTime.now();
        this.post = (post != null) ? post : List.of(); // Lista vazia se for nula
    }
    public Comentario(Usuario autor, String conteudo, Post post) {
        this(null, autor, conteudo, List.of(post));
    }
    // Getters e Setters
    public Integer getId() {return id;}

    public Usuario getAutor() {
        return autor;
    }
    public String getConteudo() {
        return conteudo;
    }
    public LocalDateTime getDataComentario() {
        return dataComentario;
    }
    public List<Post> getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", autor=" + (autor != null ? autor.getUsername() : "N/A") +
                ", conteudo='" + conteudo + '\'' +
                ", dataComentario=" + dataComentario +
                ", post=" + post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(autor, that.autor) &&
                Objects.equals(conteudo, that.conteudo) &&
                Objects.equals(dataComentario, that.dataComentario) &&
                Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, conteudo, dataComentario, post);
    }
}
