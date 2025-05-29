package atividade;
import java.util.Locale;

/* Classe para o produto */
public class Produto {
	String nome;
	String fabricante;
	double preco;
	String data_validade;
	String tipo;
	
	
	/* Método construtor que recebe os dados do produto */
	public Produto(String nome, String fabricante, double preco, String data_validade, String tipo) {
		this.nome = nome;
		this.fabricante = fabricante;
		this.preco = preco;
		this.data_validade = data_validade;
		this.tipo = tipo;
	}
	
	/* Método que formata a saída */
	public String toString() {
		return String.format(Locale.US, "%s # %s # %.2f # %s # %s #", nome, fabricante, preco, data_validade, tipo);
	}
}
