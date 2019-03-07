package lista_encadeada;



public class lista_duplamente_encadeada {
	
	private Nodo Primeiro;
	private Nodo Ultimo;
	private int tamanho = 0;
	
	public void Inserir_inicio(Object elemento) {
		Nodo novo = new Nodo(elemento);
		if(this.tamanho==0) {
			this.Primeiro = novo;
			this.Ultimo = novo;
		}else {
			
			this.Primeiro.setAnterior(novo);
			novo.setProximo(this.Primeiro);
			this.Primeiro = novo;
			
		}
		this.tamanho++;
		
		
	}
	
	public Nodo pegarCelula(int posicao) {
		
		if(posicao>=this.tamanho || posicao<0) {
			throw new IllegalArgumentException("Posição errada!!");
			
		}else {
		Nodo atual = this.Primeiro;
		for(int i=0;i<posicao;i++) {
			
			atual = atual.getProximo();
		}
		return atual;
		}
	}
	
	public int pegarPosicao(Object elemento) {
		Nodo atual = this.Primeiro;
		for(int i=0;i<this.tamanho;i++) {
			if(atual.getElemento() == elemento) {
				return i;
			}
			atual = atual.getProximo();
		}
		return -1;
		
	}
	public void Inserir_fim(Object elemento) {
		Nodo novo = new Nodo(elemento);
		if (this.tamanho==0) {
			this.Primeiro = novo;
			this.Ultimo = novo;
		}else {
			
			this.Ultimo.setProximo(novo);
			novo.setAnterior(this.Ultimo);
			this.Ultimo = novo;
		}
		this.tamanho++;
		
	}
	
	public void Inserir(int posicao, Object elemento) {
		Nodo novo = new Nodo(elemento);
		if(this.tamanho==0) {
			this.Primeiro = novo;
			this.Ultimo = novo;
			this.tamanho++;
		}else if(posicao==0) {
			this.Inserir_inicio(elemento);
			
		}else if(posicao==this.tamanho) {
			this.Inserir_fim(elemento);
		}else if(posicao>0 && posicao<this.tamanho) {
			Nodo anterior = this.pegarCelula(posicao-1);
			Nodo proximo = this.pegarCelula(posicao);
			
			anterior.setProximo(novo);
			novo.setAnterior(anterior);
			novo.setProximo(proximo);
			proximo.setAnterior(novo);
			this.tamanho++;
			
		}
		
	}
	
	public void Remover_fim() {
		
		if(this.tamanho==0) {
			throw new IllegalArgumentException("Não há elementos a remover!!");
		}else {
			
			Nodo anterior = this.Ultimo.getAnterior();
			this.Ultimo.setAnterior(null);
			anterior.setProximo(null);
			this.Ultimo = anterior;
			this.tamanho--;
		}
	}
	public void Remover_inicio() {
		if(this.tamanho==0) {
			throw new IllegalArgumentException("Não há elementos a remover!!");
		}else {
			
			Nodo proximo = this.Primeiro.getProximo();
			this.Primeiro.setProximo(null);
			proximo.setAnterior(null);
			this.Primeiro = proximo;
			this.tamanho--;
		}
		
		
		
	}
	
	public void Remover(Object elemento) {
		if(this.tamanho==0) {
			throw new IllegalArgumentException("Não há elementos a remover!!");
		}else if(this.pegarPosicao(elemento)==0) {
			
			this.Remover_inicio();
		}else if(this.pegarPosicao(elemento)==this.tamanho-1) {
			this.Remover_fim();
		}else if(this.pegarPosicao(elemento)>0 && this.pegarPosicao(elemento)<this.tamanho) {
			Nodo dados = this.pegarCelula(this.pegarPosicao(elemento));
			Nodo anterior = dados.getAnterior();
			Nodo proximo = dados.getProximo();
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			dados.setAnterior(null);
			dados.setProximo(null);
			this.tamanho--;
			
		}else {
			throw new IllegalArgumentException("O elemento não existe!!");
			
		}
		
	}
	
	public String toString() {
		
		if(this.tamanho==0) {
			return "[]";
		}else {
			StringBuilder lista = new StringBuilder("[");
			Nodo atual = this.Primeiro;
			for(int i =0;i<this.tamanho-1;i++) {
				lista.append(atual.getElemento());
				lista.append(", ");
				atual = atual.getProximo();
				
			}
			lista.append(atual.getElemento());
			lista.append("]");
			return lista.toString();
		}
	}
	
	public Object Pop(int posicao) {
		if(posicao<0 || posicao>this.tamanho) {
			
			throw new IllegalArgumentException("Erro de indice");
		}else {
			Nodo elemento = this.pegarCelula(posicao);
			this.Remover(elemento.getElemento());
			return elemento.getElemento();
			
		}
		
		
	}
	public void Clear() {
		
		if(this.tamanho==0) {
			System.out.println("A lista já esta vazia!!");
		}else {

			this.Primeiro =null;
			this.Ultimo = null;
			this.tamanho = 0;
	}
	}
public static void main(String[] args) {
	lista_duplamente_encadeada lista = new lista_duplamente_encadeada();
	lista.Inserir_inicio(12);
	lista.Inserir_inicio(45);
	lista.Inserir_fim(69);
	lista.Inserir(2, 1);
	System.out.println(lista.toString());
	
	lista.Clear();
	System.out.println(lista.toString());
	
}

}
