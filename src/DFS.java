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
		Iterator iter = grafo.iteradorVertice();

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
		descoberto(grafo, u); // if there is something to do now

		// Explore each adjacent edge (u,v).
		@SuppressWarnings("rawtypes")
		Iterator iter = grafo.iteradorAresta(u);

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
		finalizado(grafo, u); // if there is something to do now
	}

	public VerticeDFS getDFSInfo(Vertice v) {
		return dfsResultado[v.getIndice()];
	}


	public VerticeDFS getDFSInfo(int v) {
		return dfsResultado[v];
	}

	protected void descoberto(GrafoComoListaAdjacencia grafo, Vertice u) {
	}


	protected void finalizado(GrafoComoListaAdjacencia grafo, Vertice u) {
	}

}
