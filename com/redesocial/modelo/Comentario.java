package com.redesocial.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Comentario {
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataComentario;
    private List<Post> post;

    public Comentario(Integer id, Usuario autor, String conteudo,
                      LocalDateTime dataComentario, List<Post> post) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataComentario = LocalDateTime.now();
        this.post = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDateTime dataComentario) {
        this.dataComentario = dataComentario;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", autor=" + autor +
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
        return Objects.equals(id, that.id) && Objects.equals(autor, that.autor) && Objects.equals(conteudo, that.conteudo) && Objects.equals(dataComentario, that.dataComentario) && Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, conteudo, dataComentario, post);
    }
}
