package estruturas;

public class No {
	private Object elemento;
	private No proximo;
	private No anterior;
	
	public No(Object elemento) {
		this.elemento = elemento;
		this.proximo = null;
		this.anterior = null;
		
	}
	public No getProximo() {
		return this.proximo;
	}
	public No getAnterior() {
		return this.anterior;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	public Object getElemento() {
		return this.elemento;
	}

}
