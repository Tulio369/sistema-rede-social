package com.redesocial.ui;

import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.modelo.Comentario;
import com.redesocial.gerenciador.GerenciadorPosts;
import com.redesocial.modelo.Post;
import com.redesocial.modelo.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuUsuario {
    private final Usuario usuario;
    private final GerenciadorUsuarios gerenciadorUsuarios;
    private final GerenciadorPosts gerenciadorPosts;
    private final Scanner scanner;

    public MenuUsuario(Usuario usuario, GerenciadorUsuarios gerenciadorUsuarios, GerenciadorPosts gerenciadorPosts) {
        this.usuario = usuario;
        this.gerenciadorUsuarios = gerenciadorUsuarios;
        this.gerenciadorPosts = gerenciadorPosts;
        this.scanner = new Scanner(System.in);
    }
    public void exibirMenu() {
        while (true) {
            System.out.println("=== Menu do Usuário ===");
            System.out.println("1. Criar Post");
            System.out.println("2. Ver Meu Perfil");
            System.out.println("3. Buscar Usuários");
            System.out.println("4. Gerenciar Amizades");
            System.out.println("5. Ver Feed de Notícias");
            System.out.println("6. Editar Perfil");
            System.out.println("0. Sair");
            System.out.print("Escolha uma das opções: ");
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
                    buscarUsuarios();
                    break;
                case 4:
                    gerenciarAmizades();
                    break;
                case 5:
                    verFeedNoticias();
                    break;
                case 6:
                    editarPerfil();
                    break;
                case 0:
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
        try {
            Post post = new Post(usuario, conteudo);
            gerenciadorPosts.criar(post);
            System.out.println("Post criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar post: " + e.getMessage());
        }
    }

    private void verPerfil() {
        System.out.println("=== Perfil de " + usuario.getUsername() + " ===");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Data de Cadastro: " + usuario.getDataCadastro());
        System.out.println("Número de posts: " + usuario.getPosts().size());
        System.out.println("Número de amigos: " + usuario.getAmigos().size());
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
    private void editarPerfil() {
        System.out.println("=== Editar Perfil ===");
        System.out.println("Escolha o campo que deseja editar:");
        System.out.println("1. Nome");
        System.out.println("2. Username");
        System.out.println("3. Email");
        System.out.println("4. Senha");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a linha restante

        switch (opcao) {
            case 1:
                editarNome();
                break;
            case 2:
                editarUsername();
                break;
            case 3:
                editarEmail();
                break;
            case 4:
                editarSenha();
                break;
            case 0:
                System.out.println("Voltando ao menu...");
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }
    private void editarNome() {
        System.out.print("Digite o novo nome: ");
        String novoNome = scanner.nextLine();
        if (novoNome.trim().isEmpty()) {
            System.out.println("O nome não pode ser vazio.");
        } else if (novoNome.equals(usuario.getNome())) {
            System.out.println("O nome não pode ser igual ao anterior.");
        } else {
            usuario.setNome(novoNome);
            System.out.println("Nome atualizado com sucesso!");
        }
    }
    private void editarUsername() {
        System.out.print("Digite o novo username: ");
        String novoUsername = scanner.nextLine();
        if (novoUsername.equals(usuario.getUsername())) {
            System.out.println("O username não pode ser igual ao anterior.");
        } else {
            usuario.setUsername(novoUsername);
            System.out.println("Username atualizado com sucesso!");
        }
    }
    private void editarEmail() {
        String novoEmail;
        while (true) {
            System.out.print("Digite o novo email: ");
            novoEmail = scanner.nextLine();

            if (novoEmail.equals(usuario.getEmail())) {
                System.out.println("O email não pode ser igual ao anterior.");
            } else if (!novoEmail.contains("@")) {
                System.out.println("Email inválido. O email deve conter '@'. Tente novamente.");
            } else {
                usuario.setEmail(novoEmail);
                System.out.println("Email atualizado com sucesso!");
                break;
            }
        }
    }
    private void editarSenha() {
        System.out.print("Digite a nova senha: ");
        String novaSenha = scanner.nextLine();

        if (novaSenha.equals(usuario.getSenha())) {
            System.out.println("A nova senha não pode ser igual à senha anterior.");
        } else if (novaSenha.length() < 6) {
            System.out.println("A senha deve ter no mínimo 6 caracteres.");
        } else {
            usuario.setSenha(novaSenha);
            System.out.println("Senha atualizada com sucesso!");
        }
    }

    private void adicionarAmigo() {
        System.out.print("Digite o ID do usuário que deseja adicionar como amigo: ");
        int idAmigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Verifica se o ID fornecido é válido
        if (idAmigo == usuario.getId()) {
            System.out.println("Você não pode adicionar a si mesmo como amigo.");
            return;
        }

        // Busca o usuário pelo ID
        Usuario amigo = gerenciadorUsuarios.buscarPorId(idAmigo);

        // Verifica se o amigo existe
        if (amigo != null) {
            if (!usuario.getAmigos().contains(amigo)) {
                usuario.adicionarAmigo(amigo);  // Adiciona a amizade
                amigo.adicionarAmigo(usuario);  // Adiciona a amizade no amigo também
                System.out.println("Amigo adicionado com sucesso!" + amigo.getNome());
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

