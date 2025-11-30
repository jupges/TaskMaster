package com.projeto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Tela "Extra" para cumprir requisito de 5 telas
public class TelaEstatisticas extends JFrame {
    public TelaEstatisticas() {
        setTitle("Estatísticas do Sistema");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);

        List<Tarefa> lista = GerenciadorDados.getInstance().getTarefas();
        long total = lista.size();
        long concluidas = lista.stream().filter(Tarefa::isConcluida).count();
        long pendentes = total - concluidas;

        add(new JLabel("Total de Tarefas: " + total));
        add(new JLabel("Concluídas: " + concluidas));
        add(new JLabel("Pendentes: " + pendentes));

        // Dados de "Performance" (Critério E2)
        add(new JLabel("Memória usada: " + (GerenciadorDados.getInstance().getUsoMemoria() / 1024) + " KB"));
    }
}
