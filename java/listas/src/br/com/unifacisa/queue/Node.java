package br.com.unifacisa.queue;

class Node<T> {
    T value;          // Valor armazenado no nó
    Node<T> next;     // Ponteiro para o próximo nó

    // Construtor
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}