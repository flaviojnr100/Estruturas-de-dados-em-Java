package estruturas;

public class Fila {

	private No Primeiro;
	private No Ultimo;
	private int tamanho = 0;
	
	public void Enfileirar(Object elemento) {
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
	public int lenght() {
		return this.tamanho;
	}
	
	public void Desinfileirar() {
		if(this.tamanho==0) {
			throw new IllegalArgumentException("Não há nada a ser removido!!");
		}else if(this.tamanho==1) {
		this.Primeiro = null;
		this.Ultimo = null;
			
		}else {
			No proximo = this.Primeiro.getProximo();
			proximo.setAnterior(null);
			this.Primeiro.setProximo(null);
			this.Primeiro = proximo;
			
		}
		this.tamanho--;

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
		return  lista.toString();
	}
	}
	
	public static void main(String[] args) {
		Fila fila = new Fila();
		fila.Enfileirar(2);
		fila.Enfileirar(4);
		fila.Enfileirar(5);
		fila.Enfileirar(7);
		System.out.println(fila.toString());
		
	}
}
