package atividade;

public class AlgoritmosDeOrdenacao {

	/* Métodos pra ordenar os produtos */
	public static Produto[] shell_sort(Produto[] produtos) {
		int h, k;
		Produto temp1, temp2;
		
		for (h = 1; h < produtos.length; h = (3 * h) + 1);
			
		while (h > 0) {
			/* Atualizando o valor de h */
			h = (h - 1) / 3;
			
			// Para h > 1 ele ordena utilizando o selection sort
			if (h > 1) {
				for (int i = 0; i < produtos.length - 1; i++) {
					int min = i;
					for (int j = i + 1; j < produtos.length; j++) {
						/* Verificando se o produtos[j] vem antes de produtos[min] na ordem alfabética */
						if (produtos[j].nome.compareToIgnoreCase(produtos[min].nome) < 0) {
							min = j;
						}
					}
					/* Realizando a troca */
					temp1 = produtos[min];
					produtos[min] = produtos[i];
					produtos[i] = temp1;
				}
			}
			
			/* Para h = 1 ele utiliza o insertion sort */
			else {
				for (int i = h; i < produtos.length; i++) {
					temp2 = produtos[i];
					k = i;
			
					/* Verificando se o produtos[j - h] vem depois de temp na ordem alfabética */
					while (produtos[k - h].nome.compareToIgnoreCase(temp2.nome) > 0) {
						produtos[k] = produtos[k - h];
						k = k - h;
						if (k < h) break;
					}
					produtos[k] = temp2;	
				}			
			}
		}
		return produtos;
	}
	
	public static void quick_sort(Produto[] produtos, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = particiona(produtos, inicio, fim);
			
			quick_sort(produtos, inicio, posicaoPivo -1);
			quick_sort(produtos, posicaoPivo + 1, fim);
		}
	}
	
	public static void heap_sort(Produto[] produtos, int n) {
		build_max_heap(produtos, n);
		for (int i = n; n > 1; n--) {
			
		}
	}
	
	public static void insertion_sort(Produto[] produtos) {
		
	}
	
	
	/* Métodos auxiliares */
	public static int particiona(Produto[] produtos, int inicio, int fim) {
		/* Escolhendo o pivô */
		Produto pivo = produtos[inicio];
		/* Cursor que percorre o vetor da esquerda pra direita (delimita os produtos com preço menor ou igual ao pivô) */
		int i = inicio;
		/* Variável que percorre o vetor e compara os itens com o pivô */
		int j = inicio + 1;
		
		/* Percorrendo o vetor */
		while (j <= fim) {
			
			/* Se o preço do produto atual for menor ou igual que o preço do produto pivô, ele é movido para a esquerda */ 
			if (produtos[j].preco <= pivo.preco) {
				/* Aumenta a "área" dos produtos com preço menor ou igual ao pivô no vetor */
				i++;
				
				/* Realizando a troca pra colocar o produto de menor preço para a posição antes da "área" */
				Produto troca = produtos[j];
				produtos[j] = produtos[i];
				produtos[i] = troca;
			}
			j++;
		}
		
		/* Colocando o pivô na posição correta. Troca com "i", que tem a posição do último produto com preço menor ou igual ao pivô */
		Produto troca = produtos[inicio];
		produtos[inicio] = produtos[i];
		produtos[i] = troca;
		
		/* Retornando a posição atual do pivô */
		return i;
	}
	
	public static void build_max_heap(Produto[] produtos, int n) {
		
	}
	
	public static void max_heapify(Produto[] produtos, int i, int n) {
		
	}
}
