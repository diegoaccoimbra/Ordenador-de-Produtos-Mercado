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
			
					/* Verificando se o produtos[j - h] vem depois de temp na ordem alfabética. Se sim, a troca é feita */
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
		for (int i = n - 1; i >= 1; i--) {
			Produto temp = produtos[0];
			produtos[0] = produtos[i];
			produtos[i] = temp;
			max_heapify(produtos, 0, i);
		}
	}
	
	public static SLList insertion_sort(Produto[] produtos, SLList lista) {
		int i, j;
		Produto chave;
		
		for (j = 1; j < produtos.length; j++) {
			chave = produtos[j];
			
			i = j - 1;
			/* Aqui o algoritmo vai funcionar ao contrário: colocando em ordem decrescente */
			while (i >= 0 && produtos[i].nome.compareToIgnoreCase(chave.nome) < 0) {
				produtos[i + 1] = produtos[i];
				i--;
			}
			produtos[i + 1] = chave;
		}
		
		/* Inserindo os produtos na lista. Ficando na ordem crescente */
		for (int k = 0; k < produtos.length; k++) {
			lista.insertFirst(produtos[k]);
		}
		
		/* Retorna a lista encadeada com os produtos ordenados */
		return lista;
	}
	
	/* Métodos auxiliares */
	/* "particiona" para o quick sort */
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
	
	/* "build_max_heap" para o heap sort */
	public static void build_max_heap(Produto[] produtos, int n) {
		for (int i = n/2 - 1; i >= 0; i--) {
			max_heapify(produtos, i, n);
		}
	}
	
	/* "max_heapify" para o heap sort */
	public static void max_heapify(Produto[] produtos, int i, int n) {
		/* Loop que é executado até chegar nos nós folhas  */
		while (true) {
			int left = 2 * i  + 1;
			int right = 2 * i + 2;
			int largest = i;
			
			/* Verifica se a data de validade do filho esquerdo é "maior" que o maior */
			if (left < n && produtos[left].data_validade.compareToIgnoreCase(produtos[largest].data_validade) > 0) {
				largest = left;
			}
			else {
				largest = i;
			}
			/* Verifica se a data de validade do filho direito é "maior" que o maior */
			if (right < n && produtos[right].data_validade.compareToIgnoreCase(produtos[largest].data_validade) > 0) {
				largest = right;
			}
			
			/* Caso o maior não seja o pai, a troca é feita e o loop continua*/
			if (largest != i) {
				Produto temp = produtos[i];
				produtos[i] = produtos[largest];
				produtos[largest] = temp;
				
				
				i = largest;
			}
			/* Caso contrário, siginifica que o nó pai já é maior que seus filhos e não precisa mais descer no heap. O loop é encerrado */
			else {
				break;
			}
		}
		
	}
}
