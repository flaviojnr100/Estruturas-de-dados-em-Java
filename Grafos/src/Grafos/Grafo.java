package Grafos;

public class Grafo {
	private int tamanhoMax;
	private int totalVertices = 0;
	private Vertice[] listaVertice;
	private int[][] matrizadjacencia;
	
	public Grafo(int tamanho) {
		this.tamanhoMax = tamanho;
		
		this.listaVertice = new Vertice[tamanho];
		this.matrizadjacencia = new int[tamanho][tamanho];
		
	}
	public void AdicionarVertice(Object rotulo) {
		Vertice vt = new Vertice(rotulo);
		this.listaVertice[this.totalVertices] = vt;
		this.totalVertices++;
	}
	public void AdicionarAresta(int inicio,int fim) {
		this.matrizadjacencia[inicio][fim] = 1;
		this.matrizadjacencia[fim][inicio] = 1;
	}
	public void ImprimirMatriz() {
		System.out.print("  ");
		for(int i=0;i<this.totalVertices;i++) {
			System.out.print(this.listaVertice[i].getRotulo()+" ");
		}
		System.out.println();
		for(int i =0;i<this.totalVertices;i++) {
			System.out.print(this.listaVertice[i].getRotulo()+" ");
			for(int j=0;j<this.totalVertices;j++) {
				System.out.print(this.matrizadjacencia[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Grafo grafo = new Grafo(20);
		grafo.AdicionarVertice("A");
		grafo.AdicionarVertice("B");
		grafo.AdicionarVertice("C");
		
		grafo.AdicionarAresta(0, 1);
		grafo.AdicionarAresta(0, 2);
		grafo.AdicionarAresta(2, 2);
		grafo.ImprimirMatriz();
	}
	
	
}
