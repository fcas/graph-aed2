package grafo;

public class Aresta {
	
	//Vértice adjacente
	private Vertice vertice; 
	
	//Próxima aresta na lista de adjacência
	private Aresta proximo;
	
	private double peso;

	public Aresta(Vertice vertice, Aresta sucessor){ 
		this.vertice = vertice; 
		this.proximo = sucessor; 
	}
	
	public Aresta(Vertice vertice, Aresta sucessor, double peso) {
		this.vertice = vertice; 
		this.proximo = sucessor;
		this.peso = peso;
	}

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public Aresta getProximo() {
		return proximo;
	}

	public void setProximo(Aresta proximo) {
		this.proximo = proximo;
	}

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
