package com.projeto;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private TelaListagem parent;

    public TelaCadastro(TelaListagem parent) {
        this.parent = parent;
        setTitle("Nova Tarefa");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);

        add(new JLabel("Título:"));
        JTextField txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Descrição:"));
        JTextField txtDesc = new JTextField();
        add(txtDesc);

        JButton btnSalvar = new JButton("Salvar");
        add(new JLabel(""));
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            if(txtTitulo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Título obrigatório!");
                return;
            }
            Tarefa t = new Tarefa(txtTitulo.getText(), txtDesc.getText());
            GerenciadorDados.getInstance().adicionarTarefa(t);
            parent.atualizarLista();
            dispose();
        });
    }
}
