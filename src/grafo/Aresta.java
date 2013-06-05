package grafo;

public class Aresta {
	
	//Vértice adjacente
	private Vertice vertice; 
	
	//Próxima aresta na lista de adjacência
	private Aresta proximo;
	
	private int peso;

	public Aresta(Vertice vertice, Aresta sucessor){ 
		this.vertice = vertice; 
		this.proximo = sucessor; 
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
	
}
