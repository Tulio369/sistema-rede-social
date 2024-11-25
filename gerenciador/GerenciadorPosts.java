package gerenciador;

import modelo.Post;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPosts {
    private List<Post> posts = new ArrayList<>();
    private int proximoId = 1;

    public void criar(Post post) {
        post.setId(proximoId++);
        posts.add(post);
    }

    public List<Post> listarPorUsuario(int idUsuario) {
        List<Post> postsUsuario = new ArrayList<>();
        for (Post post : posts) {
            if (post.getAutor().getId().equals(idUsuario)) {
                postsUsuario.add(post);
            }
        }
        return postsUsuario;
    }
}

