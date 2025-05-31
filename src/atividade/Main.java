package atividade;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Produto[] produtos;
		try {
			produtos = LeitorProduto.carregarProdutos("src/atividade/produtos_1000.txt");
			
			/*
			System.out.println("Produtos:");
			for (Produto pro : produtos) {
	            System.out.println(prod);
	        }
	        */
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Como você deseja ordenar os produtos?");
			System.out.println("1 - Por nome (Shell Sort)");
			System.out.println("2 - Por preço (Quick Sort)");
			System.out.println("3 - Por data de validade (Heap Sort)");
			System.out.println("4 - Por nome (Insertion Sort)");
			
			int escolha = scanner.nextInt();
			
			switch (escolha) {
				case 1:
					AlgoritmosDeOrdenacao.shell_sort(produtos);
					break;
				case 2:
					AlgoritmosDeOrdenacao.quick_sort(produtos, 0, 999);
					break;
				case 3:
					//AlgoritmosDeOrdenacao.heap_sort(produtos);
					break;
				case 4:
					//AlgoritmosDeOrdenacao.insertion_sort(produtos);
					break;
				default:
					System.out.println("Erro! Insira uma opção válida!");
					break;
			}
			
			System.out.println("Produtos ordenados:");
			for (Produto prod : produtos) {
				System.out.println(prod);
			}
			
			scanner.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
