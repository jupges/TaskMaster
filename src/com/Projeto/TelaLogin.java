package com.projeto;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login - TaskMaster");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));
        setLocationRelativeTo(null);

        add(new JLabel("Usuário:"));
        JTextField txtUser = new JTextField();
        add(txtUser);

        add(new JLabel("Senha:"));
        JPasswordField txtPass = new JPasswordField();
        add(txtPass);

        JButton btnLogin = new JButton("Entrar");
        add(new JLabel("")); // Espaço vazio
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            // Validação simples (Critério F3 - Robustez)
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            } else if (user.equals("admin") && pass.equals("1234")) {
                new TelaListagem().setVisible(true);
                dispose(); // Fecha login
            } else {
                JOptionPane.showMessageDialog(this, "Dados inválidos!");
            }
        });
    }
}
