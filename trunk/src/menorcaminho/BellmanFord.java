package menorcaminho;

import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;

import java.util.Iterator;


public class BellmanFord extends MenorCaminho {
	/**
	 * Sets up the instance variables, including allocation of the
	 * <code>spInfo</code> array but <em>not</em> allocation of the
	 * <code>ShortestPathInfo</code> objects referenced by the array. (That's
	 * {@link #initializeSingleSource}'s job.)
	 * 
	 * @param grafo
	 *            The graph for which we are computing single-source shortest
	 *            paths.
	 */
	public BellmanFord(GrafoComoListaAdjacencia grafo) {
		super(grafo);
	}

	/**
	 * Computes single-source shortest paths from a given source vertex, filling
	 * in weights and predecessors in the <code>spInfo</code> array. Also sets
	 * the instance variable <code>noNegWeightCycle</code> appropriately.
	 * 
	 * @param fonte
	 *            The source vertex.
	 */
	public void computeShortestPaths(Vertice fonte) {
		inicializaUnicaFonte(fonte);

		int cardV = grafo.getCardinalidadeVertice();

		// Run through all edges |V|-1 times.
		for (int i = 1; i <= cardV - 1; i++) {
			@SuppressWarnings("rawtypes")
			Iterator vertexIter = grafo.iteradorVertice();

			while (vertexIter.hasNext()) {
				Vertice u = (Vertice) vertexIter.next();
				double du = getMenorCaminhoInfo(u.getIndice()).getEstimativa();
				ArestaPesadaIterator edgeIter = grafo.arestaPesadaIterator(u);

				while (edgeIter.hasNext()) {
					Vertice v = (Vertice) edgeIter.next();
					double w = edgeIter.getPeso();
					getMenorCaminhoInfo(v.getIndice()).relaxar(u, du, w);
				}
			}
		}

		// One more pass to see if a relaxation would have changed an
		// edge.
		@SuppressWarnings("rawtypes")
		Iterator vertexIter = grafo.iteradorVertice();

		while (vertexIter.hasNext()) {
			Vertice u = (Vertice) vertexIter.next();
			double du = getMenorCaminhoInfo(u.getIndice()).getEstimativa();
			ArestaPesadaIterator edgeIter = grafo.arestaPesadaIterator(u);

			while (edgeIter.hasNext()) {
				Vertice v = (Vertice) edgeIter.next();
				double w = edgeIter.getPeso();
				if (getMenorCaminhoInfo(v.getIndice()).getEstimativa() > du + w) {
					naoExisteCicloNegativo = false;
					return;
				}
			}
		}
	}
}
