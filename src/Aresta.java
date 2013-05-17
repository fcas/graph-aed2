
public class Aresta {
	
	//Vértice adjacente
	public Vertice vertice; 
	
	//Próxima aresta na lista de adjacência
	public Aresta proximo;

	public Aresta(Vertice vertice, Aresta sucessor){ 
		this.vertice = vertice; 
		this.proximo = sucessor; 
	}
	
	
}
