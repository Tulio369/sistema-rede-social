package ui;

import gerenciador.GerenciadorUsuarios;
import modelo.Post;
import modelo.Usuario;

import java.util.Scanner;

public class MenuUsuario {
    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuarioLogado;

    public MenuUsuario(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        this.gerenciadorUsuarios = gerenciadorUsuarios;
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
        while (true) {
            System.out.println("=== Gerenciar Amizades ===");
            System.out.println("1. Adicionar Amigo");
            System.out.println("2. Ver Meus Amigos");
            System.out.println("3. Remover Amigo");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarAmigo();
                    break;
                case 2:
                    verAmigos();
                    break;
                case 3:
                    removerAmigo();
                    break;
                case 4:
                    return;  // Voltar para o menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarAmigo() {
        System.out.print("Digite o ID do usuário que deseja adicionar como amigo: ");
        int idAmigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Verifica se o ID fornecido é válido
        if (idAmigo == usuarioLogado.getId()) {
            System.out.println("Você não pode adicionar a si mesmo como amigo.");
            return;
        }

        // Busca o usuário pelo ID
        Usuario amigo = gerenciadorUsuarios.buscarPorId(idAmigo);

        // Verifica se o amigo existe
        if (amigo != null) {
            if (!usuarioLogado.getAmigos().contains(amigo)) {
                usuarioLogado.adicionarAmigo(amigo);  // Adiciona a amizade
                amigo.adicionarAmigo(usuarioLogado);  // Adiciona a amizade no amigo também
                System.out.println("Amigo adicionado com sucesso!");
            } else {
                System.out.println("Você já é amigo deste usuário.");
            }
        } else {
            System.out.println("Usuário não encontrado. IDs disponíveis: ");
            // Exibe todos os usuários com seus IDs
            for (Usuario u : gerenciadorUsuarios.listarUsuarios()) {
                System.out.println("ID: " + u.getId() + " - Nome: " + u.getNome());
            }
        }
    }

    private void verAmigos() {
        System.out.println("=== Meus Amigos ===");
        if (usuarioLogado.getAmigos().isEmpty()) {
            System.out.println("Você não tem amigos.");
        } else {
            for (Usuario amigo : usuarioLogado.getAmigos()) {
                System.out.println("ID: " + amigo.getId() + " - Nome: " + amigo.getNome());
            }
        }
    }

    private void removerAmigo() {
        System.out.print("Digite o ID do amigo que deseja remover: ");
        int idAmigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Busca o usuário pelo ID
        Usuario amigo = gerenciadorUsuarios.buscarPorId(idAmigo);

        // Verifica se o amigo existe e se está na lista de amigos
        if (amigo != null && usuarioLogado.getAmigos().contains(amigo)) {
            usuarioLogado.removerAmigo(amigo);  // Remove a amizade
            System.out.println("Amigo removido com sucesso!");
        } else {
            System.out.println("Amigo não encontrado ou você não é amigo deste usuário.");
        }
    }
}

