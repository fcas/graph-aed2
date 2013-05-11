import java.util.Iterator;

public interface Grafo {

	public void adicionarVertice(String conteudo, String id);

	public Vertice adicionarVertice(Vertice v);

	public Vertice getVertice(String id);

	public void adicionarAresta(Vertice origem, Vertice destino);

	@SuppressWarnings("rawtypes")
	public Iterator iteradorVertice();

	@SuppressWarnings("rawtypes")
	// através de arestas incidentes em um vértice
	public Iterator iteradorAresta(Vertice u);

	@SuppressWarnings("rawtypes")
	// u é o índice do vértice no qual as arestas incidem
	public Iterator iteradorAresta(int u);

	public int getCardinalidadeVertice();

	public int getCardinalidadeAresta();

	public boolean ehDirecionado();

}
