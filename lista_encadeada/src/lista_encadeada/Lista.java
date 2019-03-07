package lista_encadeada;

public class Lista {

	private No Primeiro;
	private No Ultimo;
	private int tamanho = 0;


public void Inserir_inicio(Object elemento) {
	No novo = new No(this.Primeiro, elemento);
	this.Primeiro = novo;
	if (this.tamanho == 0) {
		
		this.Ultimo = this.Primeiro;
	}
	this.tamanho++;
	
}
public void Inserir_ultimo(Object elemento) {
	
	
	if (this.tamanho == 0) {
		this.Inserir_inicio(elemento);
		
	}else {
		No novo = new No(null,elemento);
		this.Ultimo.setProximo(novo);
		this.Ultimo = novo;
		this.tamanho++;
		
		
	}
	
}
public String toString() {
	if (this.tamanho == 0) {
		
		return "[]";
	}else {
		
		StringBuilder builder = new StringBuilder("[");
		No atual = this.Primeiro;
		for(int i = 0; i <this.tamanho-1;i++) {
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProximo();
			
		}
		builder.append(atual.getElemento());
		builder.append("]");
		return builder.toString();
	}
	
}

private boolean posicaoOcupada(int posicao) {
	return posicao >=0 && posicao <this.tamanho;
}

private No pegaCelula(int posicao) {
	if(!this.posicaoOcupada(posicao)) {
		throw new IllegalArgumentException("Posição errada!!");
		
	}
	No atual = this.Primeiro;
	for(int i = 0;i<posicao;i++) {
		
		atual = atual.getProximo();
	}
	return atual;
	
}

public void Adicionar(int posicao,Object elemento) {
	if (posicao ==0) {
		this.Inserir_inicio(elemento);
	}else if(posicao == this.tamanho) {
		this.Inserir_ultimo(elemento);
		
	}else {
		
		No anterior = this.pegaCelula(posicao-1);
		No novo = new No(anterior.getProximo(),elemento);
		anterior.setProximo(novo);
		this.tamanho++;
	}
	
}

public Object pega(int posicao) {
	  return this.pegaCelula(posicao).getElemento();
	}

public void removeDoComeco() {
	  if (!this.posicaoOcupada(0)) {
	    throw new IllegalArgumentException("Posição não existe");
	  }

	  No proximo = this.Primeiro.getProximo();
	  this.Primeiro.setProximo(null);
	  this.Primeiro = proximo;
	  this.tamanho--;
	  
	  if (this.tamanho == 0) {
		this.Primeiro = null;
	    this.Ultimo = null;
	  }
	}

public void removeDoFim() {

	if (!this.posicaoOcupada(0)) {
	    throw new IllegalArgumentException("Posição não existe");
	  }
	
	if(this.tamanho==1) {
		this.Primeiro = null;
		this.Ultimo = null;
	}else {
		
		
		No anterior = this.pegaCelula(this.tamanho-1);
		anterior.setProximo(null);
		this.Ultimo = anterior;
	}
	this.tamanho--;
	
}

public void remover(Object elemento) {
	if (!this.posicaoOcupada(0)) {
	    throw new IllegalArgumentException("Posição não existe");
	  }
	if(this.tamanho==1) {
		this.Primeiro = null;
		this.Ultimo = null;
	}else if(this.Ultimo.getElemento() == elemento) {
		this.removeDoFim();
	}else if(this.Primeiro.getElemento() == elemento) {
		this.removeDoComeco();
	}else {
		No atual = this.Primeiro;
		int i =0;
		while (atual != null){
			if (atual.getElemento() == elemento) {
				No anterior = this.pegaCelula(i-1);
				No proximo = this.pegaCelula(i+1);
				anterior.setProximo(proximo);
				this.tamanho--;
				return;
			}
			i++;
			atual = atual.getProximo();
			
		}
		if(atual==null) {
			
			throw new IllegalArgumentException("O elemento não existe!!");
		}
		
	}
	
}

public Object Pop(int posicao) {

	if (!this.posicaoOcupada(0)) {
	    throw new IllegalArgumentException("Posição não existe");
	  }
	if(posicao==0) {
		No elemento = this.pegaCelula(posicao);
		this.removeDoComeco();
		return elemento.getElemento();
		
	}else if(posicao==this.tamanho-1) {
		No elemento = this.pegaCelula(posicao);
		this.removeDoFim();
		return elemento.getElemento();
		
	}else if(posicao>0 && posicao<this.tamanho) {
		No atual = this.pegaCelula(posicao);
		No anterior = this.pegaCelula(posicao-1);
		No proximo = this.pegaCelula(posicao+1);
		anterior.setProximo(proximo);
		this.tamanho--;
		return atual.getElemento();
	}
	return null;
	
}



public static void main(String[] args) {
	Lista  lista = new Lista();
	lista.Inserir_inicio("D");
	lista.Inserir_inicio("C");
	lista.Inserir_inicio("A");
	lista.Adicionar(3, "B");
	
	
	System.out.println(lista.toString());
	lista.remover("D");
	System.out.println(lista.toString());
	
}




	
	
	
	
}




