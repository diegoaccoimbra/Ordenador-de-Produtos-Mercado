package atividade;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* Vetor para os produtos */
		Produto[] produtos;
		/* Lista encadeada para o caso 4 */
		SLList lista = new SLList();
		try {
			produtos = LeitorProduto.carregarProdutos("src/atividade/produtos_1000.txt");
			
			/*
			System.out.println("Produtos:");
			for (Produto pro : produtos) {
	            System.out.println(prod);
	        }
	        */
			
			Scanner scanner = new Scanner(System.in);
			
			/* Menu que permite o usuário escolher o método de ordenação */
			System.out.println("Como você deseja ordenar os produtos?");
			System.out.println("1 - Por nome (Shell Sort)");
			System.out.println("2 - Por preço (Quick Sort)");
			System.out.println("3 - Por data de validade (Heap Sort)");
			System.out.println("4 - Por nome (Insertion Sort)");
			
			int escolha = scanner.nextInt();
			
			/* A depender da escolha, um certo algoritmo é chamado */
			switch (escolha) {
				case 1:
					AlgoritmosDeOrdenacao.shell_sort(produtos);
					break;
				case 2:
					AlgoritmosDeOrdenacao.quick_sort(produtos, 0, produtos.length - 1);
					break;
				case 3:
					AlgoritmosDeOrdenacao.heap_sort(produtos, produtos.length);
					break;
				case 4:
					AlgoritmosDeOrdenacao.insertion_sort(produtos, lista);
					break;
				default:
					System.out.println("Erro! Insira uma opção válida!");
					break;
			}
			
			/* Exibindo os items */
			System.out.println("Produtos ordenados:");
			if (escolha == 4) {
				lista.printList();
			}
			else {
				for (Produto prod : produtos) {
					System.out.println(prod);
				}
			}
			
			
			scanner.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
