package atividade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Função que vai ler o arquivo que contém os produtos e armazenar os dados no vetor */
public class LeitorProduto {
	
	public static Produto[] carregarProdutos(String arquivo) throws IOException {
		
		/* Contando a quantidade de linhas do arquivo com o objetivo de saber a quantidade de produtos */
		BufferedReader contador = new BufferedReader(new FileReader(arquivo));
        int linhas = 0;
        while (contador.readLine() != null) {
            linhas++;
        }
        contador.close();
        
        /* Sabendo a quantidade de produtos, podemos alocar o vetor pra guardar esses produtos */
        Produto[] produtos = new Produto[linhas];
		
        /* Preenchendo o vetor com os dados do arquivo */
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        
        String linha;
        int i = 0;
        
        /* Fazemos o processo de separar os dados da linha por meio do caractere "#" até que todas as linhas do arquivo sejam lidas */
        while ((linha = leitor.readLine()) != null) {
            /* Os dados do produto são armazenados no vetor "dados" */
        	String[] dados = linha.split("#");
        	
        	/* Armazenando cada dado na posição correspondente. O preço é convertido para double além de trocar a "," por "." */
        	String nome = dados[0].trim();
        	String marca = dados[1].trim();
        	String str_preco = dados[2].trim().replace(",", ".");
        	double preco = Double.parseDouble(str_preco);
        	String validade = dados[3].trim();
        	String tipo = dados[4].trim();
        	
        	/* Armazenando o produto no vetor de produtos */
        	produtos[i] = new Produto(nome, marca, preco, validade, tipo);
        	
        	/* Incrementando para a próxima posição */
        	i++;
        }
        leitor.close();
        /* Retornando o vetor com os produtos */
        return produtos;
	}
}
