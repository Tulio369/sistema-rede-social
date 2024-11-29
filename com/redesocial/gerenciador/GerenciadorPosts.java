package com.redesocial.gerenciador;

import com.redesocial.modelo.Post;
import com.redesocial.modelo.Usuario;
import com.redesocial.modelo.Comentario;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorPosts {
    private List<Post> posts = new ArrayList<>();
    private int proximoId = 1;

    // Método para criar um novo post
    public void criar(Post post) {
        post.setId(proximoId++);
        posts.add(post);
        System.out.println("Post criado com sucesso: " + post.getConteudo());

    }

    // Método para listar posts de um usuário específico
    public List<Post> listarPorUsuario(int idUsuario) {
        // Utiliza stream para filtrar os posts do usuário de forma mais eficiente
        return posts.stream()
                .filter(post -> post.getAutor().getId().equals(idUsuario))
                .collect(Collectors.toList());
    }

    // Método para buscar um post por ID
    public Post buscarPorId(int idPost) {
        return posts.stream()
                .filter(post -> post.getId().equals(idPost))
                .findFirst()
                .orElse(null);
    }

    // Método para curtir um post
    public void curtir(int idPost, int idUsuario) {
        Post post = buscarPorId(idPost);  // Busca o post pelo ID
        Usuario usuario = new GerenciadorUsuarios().buscarPorId(idUsuario);  // Busca o usuário pelo ID

        if (post != null && usuario != null) {
            post.adicionarCurtida(usuario);  // Adiciona a curtida ao post
            System.out.println("Post curtido com sucesso por " + usuario.getNome());
        } else {
            System.out.println("Post ou usuário não encontrado.");
        }
    }
    // Método para adicionar um comentário ao post
    public void comentar(int idPost, Comentario comentario) {
        Post post = buscarPorId(idPost);
        if (post != null) {
            post.adicionarComentario(comentario);
            System.out.println("Comentário adicionado: " + comentario.getConteudo());
        } else {
            System.out.println("Post não encontrado.");
        }
    }

    // Método para listar todos os posts
    public List<Post> listarTodos() {
        return posts;
    }
}

