package ui;

import gerenciador.GerenciadorUsuarios;
import modelo.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
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
}

