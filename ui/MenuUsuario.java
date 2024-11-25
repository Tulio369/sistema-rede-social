package ui;

import gerenciador.GerenciadorPosts;
import modelo.Post;
import modelo.Usuario;

import java.util.Scanner;

public class MenuUsuario {
    private GerenciadorPosts gerenciadorPosts = new GerenciadorPosts();
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuarioLogado;

    public MenuUsuario(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("=== Menu do Usuário ===");
            System.out.println("1. Criar Post");
            System.out.println("2. Ver Meu Perfil");
            System.out.println("3. Gerenciar Amizades");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    criarPost();
                    break;
                case 2:
                    verPerfil();
                    break;
                case 3:
                    gerenciarAmizades();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void criarPost() {
        System.out.println("=== Novo Post ===");
        System.out.print("Digite seu post: ");
        String conteudo = scanner.nextLine();

        // Cria o novo post
        Post novoPost = new Post(usuarioLogado, conteudo);

        // Adiciona o post à lista de posts do usuário logado
        usuarioLogado.adicionarPost(novoPost);

        System.out.println("Post publicado com sucesso!");
    }

    private void verPerfil() {
        System.out.println("=== Perfil de " + usuarioLogado.getUsername() + " ===");
        System.out.println("Nome: " + usuarioLogado.getNome());
        System.out.println("Email: " + usuarioLogado.getEmail());
        System.out.println("Data de Cadastro: " + usuarioLogado.getDataCadastro());
        System.out.println("Número de posts: " + usuarioLogado.getPosts().size());
        System.out.println("Número de amigos: " + usuarioLogado.getAmigos().size());
    }

    private void gerenciarAmizades() {
        // Aqui você pode implementar a adição e remoção de amigos.
        System.out.println("Gerenciar Amizades");
    }
}

