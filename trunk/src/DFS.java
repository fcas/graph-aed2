import java.awt.Color;
import java.util.Iterator;

public class DFS {

	protected int tempo;

	protected VerticeDFS[] dfsResultado; // resultado da dfs

	public void search(GrafoComoListaAdjacencia grafo) {
		dfsResultado = new VerticeDFS[grafo.getCardinalidadeVertice()];
		for (int i = 0; i < dfsResultado.length; i++)
			dfsResultado[i] = new VerticeDFS();

		tempo = 0;

		// Chama a visita enquanto não houver vértice não visitado
		@SuppressWarnings("rawtypes")
		Iterator iter = grafo.vertexIterator();

		while (iter.hasNext()) {
			Vertice u = (Vertice) iter.next();
			if (getDFSInfo(u).getColor() == Color.WHITE)
				dfsVisit(grafo, u);
		}
	}

	protected void dfsVisit(GrafoComoListaAdjacencia grafo, Vertice u) {
		VerticeDFS informacaoVertice = getDFSInfo(u);
		informacaoVertice.setCor(Color.GRAY); // white vertex u has just been
												// discovered
		tempo++;
		informacaoVertice.setTempoDescoberta(tempo);
		discover(grafo, u); // if there is something to do now

		// Explore each adjacent edge (u,v).
		@SuppressWarnings("rawtypes")
		Iterator iter = grafo.edgeIterator(u);

		while (iter.hasNext()) {
			Vertice v = (Vertice) iter.next();
			VerticeDFS vInfo = getDFSInfo(v);

			if (vInfo.getColor() == Color.WHITE) {
				vInfo.setPredecessor(u);
				dfsVisit(grafo, v);
			}
		}

		informacaoVertice.setCor(Color.BLACK); // blacken u; it is finished
		tempo++;
		informacaoVertice.setTempoTermino(tempo);
		finish(grafo, u); // if there is something to do now
	}

	/**
	 * Returns a reference to the <code>DFSInfo</code> object for a given
	 * vertex.
	 * 
	 * @param v
	 *            The vertex for which the corresponding <code>DFSInfo</code> is
	 *            returned.
	 */
	public VerticeDFS getDFSInfo(Vertice v) {
		return dfsResultado[Integer.parseInt(v.getId())];
	}

	/**
	 * Returns a reference to the <code>DFSInfo</code> object for a given
	 * vertex.
	 * 
	 * @param v
	 *            The index of the vertex for which the corresponding
	 *            <code>DFSInfo</code> is returned.
	 */
	public VerticeDFS getDFSInfo(int v) {
		return dfsResultado[v];
	}

	/**
	 * Performs an action upon discovering a vertex in a graph. This method does
	 * nothing and is designed to be overridden in subclasses.
	 * 
	 * @param grafo
	 *            The graph.
	 * @param u
	 *            The vertex just discovered.
	 */
	protected void discover(GrafoComoListaAdjacencia grafo, Vertice u) {
	}

	/**
	 * Performs an action upon finishing a vertex in a graph. This method does
	 * nothing and is designed to be overridden in subclasses.
	 * 
	 * @param grafo
	 *            The graph.
	 * @param u
	 *            The vertex just finished.
	 */
	protected void finish(GrafoComoListaAdjacencia grafo, Vertice u) {
	}

}
