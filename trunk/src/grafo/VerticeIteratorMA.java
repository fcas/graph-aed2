package grafo;

import java.util.Iterator;

public class VerticeIteratorMA implements Iterator {

	protected int ultimoVisitado;
	protected Vertice vertices[];

	public VerticeIteratorMA(Vertice vertices[]) {
		this.vertices = vertices;
		ultimoVisitado = -1;
	}

	public boolean hasNext() {
		return ultimoVisitado < vertices.length - 1;
	}

	public Object next() {
		return vertices[++ultimoVisitado];
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}