package modelo;

import java.time.LocalDateTime;

public class Post {
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataPublicacao;

    public Post(Usuario autor, String conteudo) {
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataPublicacao = LocalDateTime.now();
    }

    // Getters, setters e toString()
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id; // Definir o ID do post
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", autor=" + autor.getUsername() +
                ", conteudo='" + conteudo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}


