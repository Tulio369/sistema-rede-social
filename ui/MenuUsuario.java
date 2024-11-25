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
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    criarPost();
                    break;
                case 2:
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
        Post novoPost = new Post(usuarioLogado, conteudo);
        gerenciadorPosts.criar(novoPost);
        System.out.println("Post publicado com sucesso!");
    }
}

