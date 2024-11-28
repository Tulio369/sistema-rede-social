package com.redesocial.ui;

import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.modelo.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuarioLogado = null;  // Variável para armazenar o usuário logado


    public void exibirMenu() {
        while (true) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    loginUsuario();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarUsuario() {
        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, username, email, senha);
        gerenciadorUsuarios.cadastrar(novoUsuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }
    private void loginUsuario() {
        System.out.println("=== Login ===");
        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();

        usuarioLogado = gerenciadorUsuarios.buscarPorUsername(username);
        if (usuarioLogado != null) {
            System.out.println("Login realizado com sucesso!");
            exibirMenuLogado();  // Chama o menu do usuário
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void exibirMenuLogado() {
        // Exibe o menu do usuário logado
        MenuUsuario menuUsuario = new MenuUsuario(usuarioLogado);
        menuUsuario.exibirMenu();
    }
}


