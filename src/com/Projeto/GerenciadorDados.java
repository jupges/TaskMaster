package com.projeto;

import java.util.ArrayList;
import java.util.List;

// Singleton para gerenciar os dados na memória
public class GerenciadorDados {
    private static GerenciadorDados instance;
    private List<Tarefa> listaTarefas;

    private GerenciadorDados() {
        listaTarefas = new ArrayList<>();
        // Adiciona dados fictícios para teste
        listaTarefas.add(new Tarefa("Entregar Projeto", "Finalizar código Java"));
        listaTarefas.add(new Tarefa("Estudar Prova", "Revisar capítulo 4"));
    }

    public static GerenciadorDados getInstance() {
        if (instance == null) {
            instance = new GerenciadorDados();
        }
        return instance;
    }

    public List<Tarefa> getTarefas() {
        return listaTarefas;
    }

    public void adicionarTarefa(Tarefa t) {
        listaTarefas.add(t);
    }

    public void removerTarefa(Tarefa t) {
        listaTarefas.remove(t);
    }

    // Método para análise de performance (Critério E2)
    public long getUsoMemoria() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}
