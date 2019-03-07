package lista_encadeada;

public class Nodo {
private Object elemento;
private Nodo proximo;
private Nodo anterior;


public Nodo(Object elemento) {
	this.elemento = elemento;
	this.proximo = null;
	this.anterior = null;
	
}
public Nodo getProximo() {
	return this.proximo;
}
public Nodo getAnterior() {
	return this.anterior;
}
public Object getElemento() {
	return this.elemento;
}
public void setProximo(Nodo proximo) {
	this.proximo = proximo;
	
}

public void setAnterior(Nodo anterior) {
	this.anterior = anterior;
	
}

public void Nodo(Object elemento) {
	this.elemento = elemento;
}


}

