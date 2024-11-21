package br.com.unifacisa.binaryTrees;

public class Matrix {

    private int[][] matrix;
    private int size;

    public Matrix(Binary binaryTree) {
        this.matrix = new int[10][3];   // inicializa com 10 linhas e 3 colunas
        this.size = 0;
        buildMatrix(binaryTree.getRoot());
    }

    private void buildMatrix(Node node) {
        buildMatrix(node, 0); // Starta da raiz com índice 0
    }

    private int buildMatrix(Node node, int currentIndex) {
        if (node == null) {
            return -1; // Indice inválido para nós nulos
        }

        // Adiciona o nó atual na matriz
        addNode(node.getValue(), -1, -1);

        // Salva o indice atual
        int leftIndex = buildMatrix(node.getLeft(), size); // Indice do filho esquerdo
        int rightIndex = buildMatrix(node.getRight(), size); // Indice do filho direito

        // Atualiza os indices esquerdo e direito do nó atual
        matrix[currentIndex][1] = leftIndex;
        matrix[currentIndex][2] = rightIndex;

        return currentIndex;
    }


    private void addNode(int value, int leftIndex, int rightIndex) {
        if (size == matrix.length) {
            resizeMatrix();
        }
        matrix[size][0] = value;       // Valor do nó
        matrix[size][1] = leftIndex;  // Índice do filho esquerdo
        matrix[size][2] = rightIndex; // Índice do filho direito
        size++;
    }

    private void resizeMatrix() {
        int[][] newMatrix = new int[matrix.length * 2][3];
        System.arraycopy(matrix, 0, newMatrix, 0, matrix.length);
        matrix = newMatrix;
    }

    public void printMatrixWithIndex() {
        System.out.println("ind\tVal\tLef\tRig");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d\t%d\t%d\t%d\n",
                    i,                // Índice do nó
                    matrix[i][0],     // Valor do nó
                    matrix[i][1],     // Índice do filho esquerdo
                    matrix[i][2]);    // Índice do filho direito
        }
    }
}
