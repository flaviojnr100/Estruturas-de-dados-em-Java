package estruturas;



public class Pilha {

	private No Primeiro;
	private No Ultimo;
	private int tamanho = 0;
	
	public void Push(Object elemento) {
		No novo = new No(elemento);
		if(this.tamanho==0) {
			this.Primeiro = novo;
			this.Ultimo = novo;
		}else {
			this.Ultimo.setProximo(novo);
			novo.setAnterior(this.Ultimo);
			this.Ultimo = novo;
		}
		this.tamanho++;
	}
	
	public void Pop() {
		
		if(this.tamanho==0) {
			throw new IllegalArgumentException("Não há elementos na pilha");
		}else if(this.tamanho==1) {
			this.Primeiro = null;
			this.Ultimo = null;
			this.tamanho--;
		}else {
			No anterior = this.Ultimo.getAnterior();
			this.Ultimo.setAnterior(null);
			anterior.setProximo(null);
			this.Ultimo = anterior;
			this.tamanho--;
		}
	}
	
	public String toString() {
		if(this.tamanho==0) {
			return "[]";
		}else {
		StringBuilder lista = new StringBuilder("[");
		No atual = this.Primeiro;
		for(int i = 0;i<this.tamanho-1;i++) {
			lista.append(atual.getElemento());
			lista.append(", ");
			atual = atual.getProximo();
		}
		lista.append(atual.getElemento());
		lista.append("]");
		return lista.toString();
		}
		
		
	}
	public int lenght() {
		return this.tamanho;
	}
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		pilha.Push(1);
		pilha.Push(35);
		pilha.Push(56);
		System.out.println(pilha.toString());
		

		System.out.println(pilha.lenght());
	}
}
