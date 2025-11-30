package com.projeto;

import javax.swing.*;
import java.awt.*;

public class TelaListagem extends JFrame {
    private JList<Tarefa> jList;
    private DefaultListModel<Tarefa> listModel;

    public TelaListagem() {
        setTitle("Minhas Tarefas");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        atualizarLista();

        jList = new JList<>(listModel);
        add(new JScrollPane(jList), BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();
        JButton btnNova = new JButton("Nova Tarefa");
        JButton btnVer = new JButton("Ver/Editar");
        JButton btnStats = new JButton("Estatísticas");

        panelBotoes.add(btnNova);
        panelBotoes.add(btnVer);
        panelBotoes.add(btnStats);
        add(panelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnNova.addActionListener(e -> {
            new TelaCadastro(this).setVisible(true);
        });

        btnVer.addActionListener(e -> {
            Tarefa selecionada = jList.getSelectedValue();
            if (selecionada != null) {
                new TelaDetalhes(this, selecionada).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma tarefa!");
            }
        });

        btnStats.addActionListener(e -> {
            new TelaEstatisticas().setVisible(true);
        });
    }

    public void atualizarLista() {
        listModel.clear();
        for (Tarefa t : GerenciadorDados.getInstance().getTarefas()) {
            listModel.addElement(t);
        }
    }
}
