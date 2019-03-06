package Grafos;

public class Vertice {

	private Object rotulo;
	private boolean visitado = false;
	
	public Object getRotulo() {
		return rotulo;
	}
	public boolean Igual(Object r) {
		return this.rotulo == r?true:false;
	}
	public void mudarVisitado() {
		this.visitado = true;
	}
	public void limpar() {
		this.visitado = false;
	}
	public Vertice(Object rotulo) {
		this.rotulo = rotulo;
	}
	
	
}
