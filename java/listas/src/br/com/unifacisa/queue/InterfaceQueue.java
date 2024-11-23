package br.com.unifacisa.queue;

// Interface que define os métodos básicos de uma fila
public interface InterfaceQueue<T> {
    void enqueue(T value); // Adiciona um elemento ao final da fila
    T dequeue();           // Remove e retorna o elemento no início da fila
    T peek();              // Retorna o elemento no início sem removê-lo
    boolean isEmpty();     // Verifica se a fila está vazia
    int getSize();         // Retorna o tamanho da fila
}