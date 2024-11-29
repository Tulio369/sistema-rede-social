package com.redesocial.Main;

import com.redesocial.ui.MenuPrincipal;
import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.gerenciador.GerenciadorPosts;


public class Main {
    public static void main(String[] args) {
        GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
        GerenciadorPosts gerenciadorPosts = new GerenciadorPosts();

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.exibirMenu();
    }
}
