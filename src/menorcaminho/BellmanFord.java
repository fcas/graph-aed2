package menorcaminho;

import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;

import java.util.Iterator;

public class BellmanFord extends MenorCaminho {

	public BellmanFord(GrafoComoListaAdjacencia grafo) {
		super(grafo);
	}

	public void calculaMenorCaminho(Vertice fonte) {
		inicializaUnicaFonte(fonte);

		int cardV = grafo.getCardinalidadeVertice();

		// Executa |V|-1 vezes.
		for (int i = 1; i <= cardV - 1; i++) {
			@SuppressWarnings("rawtypes")
			Iterator verticeIterator = grafo.iteradorVertice();

			while (verticeIterator.hasNext()) {
				Vertice u = (Vertice) verticeIterator.next();
				double estimativa = getMenorCaminhoInfo(u.getIndice()).getEstimativa();
				ArestaPesadaIterator arestaIterator = grafo
						.arestaPesadaIterator(u);

				while (arestaIterator.hasNext()) {
					Vertice vertice = (Vertice) arestaIterator.next();
					double peso = arestaIterator.getPeso();
					getMenorCaminhoInfo(vertice.getIndice()).relaxar(u, estimativa,
							peso);
				}
			}
		}

		// Verifica se o relaxamento mudou para uma aresta.
		@SuppressWarnings("rawtypes")
		Iterator verticeIterator = grafo.iteradorVertice();

		while (verticeIterator.hasNext()) {
			Vertice u = (Vertice) verticeIterator.next();
			double estimativa = getMenorCaminhoInfo(u.getIndice())
					.getEstimativa();
			ArestaPesadaIterator arestaIterator = grafo.arestaPesadaIterator(u);

			while (arestaIterator.hasNext()) {
				Vertice vertice = (Vertice) arestaIterator.next();
				double peso = arestaIterator.getPeso();
				if (getMenorCaminhoInfo(vertice.getIndice()).getEstimativa() > estimativa
						+ peso) {
					naoExisteCicloNegativo = false;
					return;
				}
			}
		}
	}
}
