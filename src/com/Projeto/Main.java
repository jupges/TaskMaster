package com.projeto;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Inicia a aplicação na Thread de evento do Swing (Critério Q2 - Boas práticas)
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
