package grafo;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class ArestaIteratorLA implements Iterator {

	// a mais recentemente chamada
	protected Aresta aresta;

	protected int indiceVertice;

	AdjListInfo[] adj;

	public ArestaIteratorLA(int v, AdjListInfo[] adj) {
		this.adj = adj;
		indiceVertice = v;
		aresta = null;
	}

	/**
	 * Retorna true se o iterado de arestas tem uma próxima arestas, false caso
	 * contrário.
	 */
	public boolean hasNext() {
		if (aresta == null)
			return adj[indiceVertice].cabeca != null;
		else
			return aresta.getProximo() != null;
	}

	public Object next() {
		if (aresta == null)
			aresta = adj[indiceVertice].cabeca;
		else
			aresta = aresta.getProximo();

		return aresta.getVertice();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public double getPeso() {
		return aresta.getPeso();
	}

}
