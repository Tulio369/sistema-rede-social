package gerenciador;

import modelo.Post;
import modelo.Usuario;

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
    public void curtir(int idPost, int idusuario) {
        Post post = buscarPorId(idPost);
        Usuario usuario = new  GerenciadorUsuarios().buscarPorId(idusuario);
        if(post != null && usuario != null) {
            post.adicinarCurtida(usuario);
        }
    }

}

