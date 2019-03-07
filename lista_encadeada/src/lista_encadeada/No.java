package lista_encadeada;

public class No {
private No proximo;
private Object elemento;

public No(No proximo, Object elemento) {
	this.proximo = proximo;
	this.elemento = elemento;
	
	
}

public No getProximo() {
	return proximo;
	
}
public Object getElemento() {
		return elemento;
		
	}

public No(Object elemento) {
	
	this.elemento = elemento;
}
public void setProximo(No proximo) {
	this.proximo = proximo;
	
}
}
