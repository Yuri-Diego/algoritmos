package br.com.unifacisa.binaryTrees;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		int input = 20;
		String result;
		Matrix matrix = new Matrix(101);

		while (input != 0) {
			result = showMenu();

			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
				result = showMenu();
			} else {
				input = Integer.parseInt(result);

				switch (input) {
					case 1:
						String item = JOptionPane.showInputDialog("Digite um numero para inserir na arvore!");
						matrix.insert(Integer.parseInt(item));
						break;
					case 2:
						String vl = JOptionPane.showInputDialog("Digite o valor que você deseja Remover!");
						matrix.remove(Integer.parseInt(vl));
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "A raiz da árvore será exibida no console!");
						matrix.showRoot();
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						System.out.println("Ordem simétrica:");
						matrix.inOrder(0);
						System.out.println();
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						System.out.println("Pré-ordem:");
						matrix.preOrder(0);
						System.out.println();
						break;
					case 6:
						JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
						System.out.println("Pós-ordem:");
						matrix.postOrder(0);
						System.out.println();
						break;
					case 7:
						JOptionPane.showMessageDialog(null, "Os valores Serão exibidos no console!");
						matrix.showTree();
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "Saindo...");
						break;
				}
			}
		}
	}

	public static String showMenu() {
		String result = JOptionPane.showInputDialog("" +
				"Digite:" +
				"\n 1: Para inserir " +
				"\n 2: para Remover" +
				"\n 3: Para Exibir a Raiz " +
				"\n 4: Para Exibir ordem simétrica " +
				"\n 5: Para Exibir pré-ordem " +
				"\n 6: Para Exibir pós-ordem " +
				"\n 7: Para Exibir a árvore como matriz " +
				"\n 0: Para Sair");

		if (result == null) {
			result = "";
		}

		return result;
	}
}
