package com.projeto;

import javax.swing.*;
import java.awt.*;

public class TelaDetalhes extends JFrame {
    public TelaDetalhes(TelaListagem parent, Tarefa tarefa) {
        setTitle("Detalhes");
        setSize(300, 250);
        setLayout(new GridLayout(5, 1));
        setLocationRelativeTo(null);

        add(new JLabel("Título: " + tarefa.getTitulo()));
        add(new JLabel("Descrição: " + tarefa.getDescricao()));

        JCheckBox chkFeita = new JCheckBox("Concluída", tarefa.isConcluida());
        add(chkFeita);

        JButton btnSalvar = new JButton("Salvar Alterações");
        JButton btnExcluir = new JButton("Excluir Tarefa");

        // Estilização simples para ficar vermelho
        btnExcluir.setForeground(Color.RED);

        add(btnSalvar);
        add(btnExcluir);

        btnSalvar.addActionListener(e -> {
            tarefa.setConcluida(chkFeita.isSelected());
            parent.atualizarLista();
            dispose();
        });

        btnExcluir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza?", "Excluir", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                GerenciadorDados.getInstance().removerTarefa(tarefa);
                parent.atualizarLista();
                dispose();
            }
        });
    }
}
