package br.com.unifacisa.coffeeShop;

public class Heap {
    private Order[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new Order[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Order order) {
        if (size >= heap.length) {
            throw new RuntimeException("Heap is full!");
        }
        heap[size] = order;
        bubbleUp(size);
        size++;
    }

    public Order remove() {
        if (isEmpty()) {
            return null;
        }
        Order root = heap[0];
        heap[0] = heap[--size];
        bubbleDown(0);
        return root;
    }

    public Order[] viewAll() {
        Order[] copy = new Order[size];
        System.arraycopy(heap, 0, copy, 0, size);
        return copy;
    }

    public void updatePriority(int orderId, boolean vip) {
        for (int i = 0; i < size; i++) {
            if (heap[i].getOrderId() == orderId) {
                heap[i].setPriority(vip);
                adjust(i);
                return;
            }
        }
        throw new RuntimeException("Order with ID " + orderId + " not found.");
    }

    public void removeById(int orderId) {
        for (int i = 0; i < size; i++) {
            if (heap[i].getOrderId() == orderId) {
                heap[i] = heap[--size];
                adjust(i);
                return;
            }
        }
        throw new RuntimeException("Order with ID " + orderId + " not found.");
    }

    private void adjust(int position) {
        bubbleUp(position);
        bubbleDown(position);
    }

    private void bubbleUp(int position) {
        while (position > 0) {
            int parent = (position - 1) / 2;
            if (heap[position].getPriority() >= heap[parent].getPriority()) {
                break;
            }
            swap(position, parent);
            position = parent;
        }
    }

    private void bubbleDown(int position) {
        while (true) {
            int left = 2 * position + 1;
            int right = 2 * position + 2;
            int smallest = position;

            if (left < size && heap[left].getPriority() < heap[smallest].getPriority()) {
                smallest = left;
            }
            if (right < size && heap[right].getPriority() < heap[smallest].getPriority()) {
                smallest = right;
            }
            if (smallest == position) {
                break;
            }
            swap(position, smallest);
            position = smallest;
        }
    }

    private void swap(int i, int j) {
        Order temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
