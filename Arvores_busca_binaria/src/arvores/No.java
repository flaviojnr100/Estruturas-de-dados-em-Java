package arvores;

public class No {

	private int elemento;
	private No Direita;
	private No Esquerda;
	private No Pai;
	
	public No(int elemento) {
		this.elemento = elemento;
		this.Direita = null;
		this.Esquerda = null;
		this.Pai = null;
	}
	public No getDireita() {
		return this.Direita;
	}
	public No getEsquerda() {
		return this.Esquerda;
	}
	public void setDireita(No direita) {
		this.Direita = direita;
	}
	public void setEsquerda(No esquerda) {
		this.Esquerda = esquerda;
	}
	public No getPai() {
		return this.Pai;
	}
	public void setPai(No pai) {
		this.Pai = pai;
	}
	public int getElemento() {
		return this.elemento;
	}
	public void No(int elemento) {
		this.elemento = elemento;
	}
}
