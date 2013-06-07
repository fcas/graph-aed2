package grafo;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class VerticeIterator implements Iterator {

	protected int ultimoVisitado;
	AdjListInfo[] adj;

	public VerticeIterator() {
		ultimoVisitado = -1;
	}

	public VerticeIterator(AdjListInfo[] adj) {
		this.adj = adj;
		ultimoVisitado = -1;
	}

	public boolean hasNext() {
		return ultimoVisitado < adj.length - 1;
	}

	public Object next() {
		return adj[++ultimoVisitado].esteVertice;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
