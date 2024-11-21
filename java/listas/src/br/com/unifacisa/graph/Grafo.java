package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

	private int numVertices;
	private List<List<Integer>> adjacencyList;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new ArrayList<>(numVertices);

		for (int i = 0; i < numVertices; i++) {
			this.adjacencyList.add(new LinkedList<>());
		}
	}

	public void addEdge(int v, int w) {
		/*
		 * v = origem
		 * w = destino
		 */
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v); // Como é um grafo não direcionado, adicionamos a ligação inversa também
	}

	public void buscaEmLargura(int verticeInicial) {
		// Array para marcar os vértices visitados
		boolean[] visitados = new boolean[numVertices];

		// Fila para gerenciar os vértices a serem visitados
		Queue<Integer> fila = new LinkedList<>();

		// Começar pelo vértice inicial
		visitados[verticeInicial] = true;
		fila.add(verticeInicial);

		System.out.println("Busca em largura a partir do vértice " + verticeInicial + ":");

		while (!fila.isEmpty()) {
			// Pega o próximo vértice na fila
			int verticeAtual = fila.poll();
			System.out.print(verticeAtual + " ");

			// Itera sobre os vizinhos do vértice atual
			for (int vizinho : adjacencyList.get(verticeAtual)) {
				if (!visitados[vizinho]) {
					visitados[vizinho] = true;
					fila.add(vizinho);
				}
			}
		}
		System.out.println();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numVertices; i++) {
			sb.append("Vértice: ").append(i).append(":\n");
			for (Integer neighbor : adjacencyList.get(i)) {
				sb.append(" -> ").append(neighbor).append("\n");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);

		grafo.addEdge(0, 1);
		grafo.addEdge(0, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);

		System.out.println(grafo.toString());

		grafo.buscaEmLargura(0);
		/*
			Busca em largura a partir do vértice 0:
			0 1 4 2 3
		 */

		grafo.buscaEmLargura(2);
		/*
			Busca em largura a partir do vértice 2:
			2 1 3 0 4
		 */

	}
}
