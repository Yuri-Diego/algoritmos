package br.com.unifacisa.queue;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Criação da fila
        Queue<Integer> queue = new Queue<>();

        // Menu interativo
        while (true) {
            String[] options = {
                    "Adicionar elemento (enqueue)",
                    "Remover elemento (dequeue)",
                    "Consultar o início da fila (peek)",
                    "Imprimir fila",
                    "Sair"
            };

            // Exibe o menu e recebe a escolha do usuário
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Selecione uma opção:",
                    "Menu da Fila Dinâmica",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == -1 || choice == 4) { // Usuário clicou em "Sair" ou fechou a janela
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                break;
            }

            switch (choice) {
                case 0: // Adicionar elemento (enqueue)
                    String input = JOptionPane.showInputDialog("Digite o valor a ser adicionado:");
                    if (input != null) {
                        try {
                            int value = Integer.parseInt(input);
                            queue.enqueue(value);
                            JOptionPane.showMessageDialog(null, "Elemento " + value + " adicionado com sucesso!");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valor inválido! Por favor, insira um número.");
                        }
                    }
                    break;

                case 1: // Remover elemento (dequeue)
                    try {
                        int removed = queue.dequeue();
                        JOptionPane.showMessageDialog(null, "Elemento " + removed + " removido com sucesso!");
                    } catch (IllegalStateException e) {
                        JOptionPane.showMessageDialog(null, "A fila está vazia. Não é possível remover elementos.");
                    }
                    break;

                case 2: // Consultar o início da fila (peek)
                    try {
                        int peek = queue.peek();
                        JOptionPane.showMessageDialog(null, "Elemento no início da fila: " + peek);
                    } catch (IllegalStateException e) {
                        JOptionPane.showMessageDialog(null, "A fila está vazia.");
                    }
                    break;

                case 3: // Imprimir fila
                    if (queue.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "A fila está vazia.");
                    } else {
                        StringBuilder output = new StringBuilder("Fila atual: ");
                        Queue<Integer> dynamicQueue = (Queue<Integer>) queue;
                        dynamicQueue.printQueue();
                        output.append("null");
                        JOptionPane.showMessageDialog(null, output.toString());
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }
}
