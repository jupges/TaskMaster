package com.projeto;

public class TesteUnitario {
    public static void main(String[] args) {
        System.out.println("Iniciando Testes Unitários...");

        // Teste 1: Adicionar Tarefa
        Tarefa t = new Tarefa("Teste 1", "Desc");
        GerenciadorDados.getInstance().adicionarTarefa(t);

        if (GerenciadorDados.getInstance().getTarefas().contains(t)) {
            System.out.println("[PASS] Tarefa adicionada com sucesso.");
        } else {
            System.err.println("[FAIL] Falha ao adicionar tarefa.");
        }

        // Teste 2: Integridade dos dados
        if (t.getTitulo().equals("Teste 1")) {
            System.out.println("[PASS] Dados da tarefa corretos.");
        } else {
            System.err.println("[FAIL] Dados incorretos.");
        }

        // Limpeza
        GerenciadorDados.getInstance().removerTarefa(t);
        System.out.println("Testes finalizados.");
    }
}
