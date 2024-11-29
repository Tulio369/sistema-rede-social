package com.redesocial.ui;

import com.redesocial.gerenciador.GerenciadorPosts;
import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.modelo.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    private final GerenciadorUsuarios gerenciadorUsuarios;
    private final GerenciadorPosts gerenciadorPosts;
    private final Scanner scanner;

    public MenuPrincipal(GerenciadorUsuarios gerenciadorUsuarios, GerenciadorPosts gerenciadorPosts) {
        this.gerenciadorUsuarios = gerenciadorUsuarios;
        this.gerenciadorPosts = gerenciadorPosts;
        this.scanner = new Scanner(System.in);
    }

    // Mostrar o menu principal para o usuário
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Fazer Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> fazerLogin();
                case 2 -> cadastrarUsuario();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // Função que permite que o usuário faça login, pedindo username e senha
    private void fazerLogin() {
        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();

        Usuario usuario = gerenciadorUsuarios.buscarPorUsername(username);
        if (usuario != null) {
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            if (usuario.getSenha().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.getNome());
                exibirMenuLogado(usuario);
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        } else {
            System.out.println("Usuário não encontrado. Verifique o username ou cadastre-se.");
        }
    }

    // Cadastra um novo usuário no sistema com validação do email e senha mínima de 6 caracteres
    private void cadastrarUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();

        // Validação do email
        String email = "";
        while (true) {
            System.out.print("Digite seu email: ");
            email = scanner.nextLine();

            if (email.contains("@")) {
                System.out.println("Email válido.");
                break; // Se o email contiver "@", sai do loop
            } else {
                System.out.println("Email inválido. O email deve conter '@'. Tente novamente.");
            }
        }

        // Validação da senha (mínimo de 6 caracteres)
        String senha = "";
        while (true) {
            System.out.print("Digite sua senha (mínimo 6 caracteres): ");
            senha = scanner.nextLine();

            if (senha.length() >= 6) {
                System.out.println("Senha válida.");
                break; // Se a senha tiver 6 ou mais caracteres, sai do loop
            } else {
                System.out.println("A senha deve ter no mínimo 6 caracteres. Tente novamente.");
            }
        }

        // Criação e cadastro do novo usuário
        Usuario novoUsuario = new Usuario(nome, username, email, senha);
        gerenciadorUsuarios.cadastrar(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Exibe o menu logado utilizando MenuUsuario
    private void exibirMenuLogado(Usuario usuario) {
        MenuUsuario menuUsuario = new MenuUsuario(usuario, gerenciadorUsuarios, gerenciadorPosts);
        menuUsuario.exibirMenu();
    }
}