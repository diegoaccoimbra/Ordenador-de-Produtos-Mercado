package atividade;

/* Lista encadeada */
public class SLList {
	SLNode first;
	
	public SLList() {
		this.first = null;
	}
	
	/* Método para inserir como o primeiro */
	public void insertFirst(Produto data) {
		SLNode newNode = new SLNode(data);
		newNode.next = this.first;
		this.first = newNode;
	}
	
	/* Método para imprimir todos os nós da lista */
	public void printList() {
		SLNode cur = this.first;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
}
