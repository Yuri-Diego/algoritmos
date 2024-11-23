package br.com.unifacisa.binaryTrees;

public class Matrix {
    private Node[] tree;
    private int size;
    private final int max_Size;

    public Matrix(int max_Size) {
        this.tree = new Node[max_Size];
        this.max_Size = max_Size;
        this.size = 0;
    }

    public void insert(int value) {
        if (size == 0) {
            tree[0] = new Node(value); // Raiz na posição 0
            System.out.println("Inserindo " + value + " na raiz.");
            size++;
        } else {
            insert(0, value);
        }
    }

    private void insert(int index, int value) {
        if (tree[index] == null) return;

        if (value < tree[index].getValue()) {
            int leftIndex = 2 * index + 1;
            if (tree[leftIndex] == null) {
                tree[leftIndex] = new Node(value);
                System.out.println("Inserindo " + value + " a esquerda de " + tree[index].getValue());
                size++;
            } else {
                insert(leftIndex, value);
            }
        } else if (value > tree[index].getValue()) {
            int rightIndex = 2 * index + 2;
            if (tree[rightIndex] == null) {
                tree[rightIndex] = new Node(value);
                System.out.println("Inserindo " + value + " a direita de " + tree[index].getValue());
                size++;
            } else {
                insert(rightIndex, value);
            }
        }
    }

    public void remove(int value) {
        int index = find(0, value);
        if (index == -1) {
            System.out.println("Valor não encontrado na árvore.");
            return;
        }
        removeAt(index);
    }

    private int find(int index, int value) {
        if (index >= max_Size || tree[index] == null) {
            return -1;
        }
        if (tree[index].getValue() == value) {
            return index;
        }
        int leftResult = find(2 * index + 1, value);
        return leftResult != -1 ? leftResult : find(2 * index + 2, value);
    }

    private void removeAt(int index) {
        if (index >= max_Size || tree[index] == null) return;

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (tree[leftIndex] == null && tree[rightIndex] == null) {
            // Caso 1: Nó folha
            tree[index] = null;
        } else if (tree[leftIndex] != null && tree[rightIndex] == null) {
            // Caso 2: Apenas filho esquerdo
            tree[index] = tree[leftIndex];
            tree[leftIndex] = null;
        } else if (tree[rightIndex] != null && tree[leftIndex] == null) {
            // Caso 2: Apenas filho direito
            tree[index] = tree[rightIndex];
            tree[rightIndex] = null;
        } else {
            // Caso 3: Dois filhos - substitui pelo sucessor
            int successorIndex = findMin(rightIndex);
            tree[index].setValue(tree[successorIndex].getValue());
            removeAt(successorIndex);
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void inOrder(int index) {
        if (index >= max_Size || tree[index] == null) return;

        inOrder(2 * index + 1);
        System.out.print(tree[index].getValue() + " ");
        inOrder(2 * index + 2);
    }

    public void preOrder(int index) {
        if (index >= max_Size || tree[index] == null) return;

        System.out.print(tree[index].getValue() + " ");
        preOrder(2 * index + 1);
        preOrder(2 * index + 2);
    }

    public void postOrder(int index) {
        if (index >= max_Size || tree[index] == null) return;

        postOrder(2 * index + 1);
        postOrder(2 * index + 2);
        System.out.print(tree[index].getValue() + " ");
    }

    public void showTree() {
        System.out.println("Ind\tVal\tLef\tRig");
        for (int i = 0; i < max_Size; i++) {
            if (tree[i] != null) {
                int leftIndex = 2 * i + 1 < max_Size && tree[2 * i + 1] != null ? 2 * i + 1 : -1;
                int rightIndex = 2 * i + 2 < max_Size && tree[2 * i + 2] != null ? 2 * i + 2 : -1;
                System.out.println(i + "\t" + tree[i].getValue() + "\t" + leftIndex + "\t" + rightIndex);
            }
        }
    }

    public void showRoot() {
        if (isEmpty()) {
            System.out.println("A árvore está vazia!");
        } else {
            System.out.println("Raiz: " + tree[0].getValue());
        }
    }

    private int findMin(int index) {
        while (2 * index + 1 < max_Size && tree[2 * index + 1] != null) {
            index = 2 * index + 1;
        }
        return index;
    }
}
