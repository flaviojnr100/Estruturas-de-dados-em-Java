package arvores;

public class Arvore_binaria {

	private int tamanho = 0;
	private No raiz = null;
	
	public void Inserir(int elemento) {
		No atual = this.raiz;
		No ant_pai = null;
		No novo = new No(elemento);
		while (atual!=null) {
			ant_pai = atual;
			if(elemento>atual.getElemento()) {
				atual = atual.getDireita();
				
			}else {
				atual = atual.getEsquerda();
			
		}
			
			
	}
		novo.setPai(ant_pai);
		if(this.raiz==null) {
			this.raiz = novo;
		}else if(elemento>ant_pai.getElemento()) {
			ant_pai.setDireita(novo);
		}else {
			ant_pai.setEsquerda(novo);
		}
		this.tamanho++;
}
	public No getRaiz() {
		return this.raiz;
	}
	
	public No maximo(int elemento) {
		No atual = this.buscaRecurssiva(this.getRaiz(), elemento);
		while (atual.getDireita()!=null) {
			atual = atual.getDireita();
		}
		return atual;
	}
	public No minimo(int elemento) {
		No atual = this.buscaRecurssiva(this.getRaiz(), elemento);
		while (atual.getEsquerda()!=null) {
			atual = atual.getEsquerda();
		}
		return atual;
	}
	
	
public No buscaRecurssiva(No comeco,int elemento) {
	if(comeco==null || comeco.getElemento()==elemento) {
		return comeco;
	}else if(elemento>comeco.getElemento()) {
		return buscaRecurssiva(comeco.getDireita(), elemento);
	}else {
		return buscaRecurssiva(comeco.getEsquerda(), elemento);
	}
	
}
public No sucessor(int elemento) {
	
	No no = this.buscaRecurssiva(this.getRaiz(), elemento);
	if (no.getDireita()!=null) {
		return this.minimo(no.getDireita().getElemento());
	}else {
		
	}
	No ancestral = null;
	ancestral = no.getPai();
	while(ancestral!=null && no==ancestral.getDireita()) {
		no = ancestral;
		ancestral = ancestral.getPai();
	}
	return ancestral;
}

public No antecessor(int elemento) {
	No no = this.buscaRecurssiva(this.getRaiz(), elemento);
	if (no.getEsquerda()!=null) {
		return this.maximo(no.getEsquerda().getElemento());
	}else {
		
	}
	No ancestral = null;
	ancestral = no.getPai();
	while(ancestral!=null && no==ancestral.getEsquerda()) {
		no = ancestral;
		ancestral = ancestral.getPai();
	}
	return ancestral;
	
}


public void Ordem(No raiz) {
	if(raiz!=null) {
		
		Ordem(raiz.getEsquerda());
		System.out.println(raiz.getElemento());
		Ordem(raiz.getDireita());
		
	}
	
}

public void PreOrdem(No raiz){
	if(raiz!=null) {
		System.out.println(raiz.getElemento());
		PreOrdem(raiz.getEsquerda());
		PreOrdem(raiz.getDireita());
		
	}
	
}

public void PosOrdem(No raiz){
	if(raiz!=null) {
		
		PreOrdem(raiz.getEsquerda());
		PreOrdem(raiz.getDireita());
		System.out.println(raiz.getElemento());
		
	}
	
}



public void Apagar(int elemento) {
	
	No sera_removido = this.buscaRecurssiva(getRaiz(), elemento);
	if(sera_removido.getEsquerda()==null) {
		this.Recortar(sera_removido, sera_removido.getDireita());
	}else if(sera_removido.getDireita()==null) {
		this.Recortar(sera_removido, sera_removido.getEsquerda());
	}else {
		
		No sucessor = this.sucessor(sera_removido.getElemento());
		if(sucessor.getPai()!=sera_removido) {
			this.Recortar(sucessor, sucessor.getDireita());
			sucessor.setDireita(sera_removido.getDireita());
			sucessor.getDireita().setPai(sucessor);
		}
		this.Recortar(sera_removido, sucessor);
		sucessor.setEsquerda(sera_removido.getEsquerda());
		sucessor.getEsquerda().setPai(sucessor);
		
	}
}
private void Recortar(No sera_removido, No sera_recortado) {
	if(sera_removido.getPai()==null) {
		this.raiz = sera_recortado;
	}else if(sera_removido==sera_removido.getPai().getEsquerda()) {
		sera_removido.getPai().setEsquerda(sera_recortado);
	}else {
		sera_removido.getPai().setDireita(sera_recortado);
	}
	if(sera_recortado!=null) {
		sera_recortado.setPai(sera_removido.getPai());
	}
	
}


public static void main(String[] args) {
	Arvore_binaria arv = new Arvore_binaria();
	arv.Inserir(8);
	arv.Inserir(3);
	arv.Inserir(10);
	arv.Inserir(14);
	arv.Inserir(6);
	arv.Inserir(4);
	arv.Inserir(13);
	arv.Inserir(7);
	arv.Inserir(1);
	
	arv.Ordem(arv.getRaiz());
	
}
}
