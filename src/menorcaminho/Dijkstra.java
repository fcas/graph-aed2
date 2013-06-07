package menorcaminho;

import fila.MinPriorityQueue;
import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;
import heap.MinHeapPriorityQueue;

public class Dijkstra extends MenorCaminho {

	public Dijkstra(GrafoComoListaAdjacencia grafo) {
		super(grafo);
	}

	/**
	 * Calcula o menor caminho a partir de uma única fonte, vertice dado,
	 * alocando os pesos e predecessores no array MenorCaminhoInfo.
	 */
	public void calculaMenorCaminho(Vertice fonte) {
		inicializaUnicaFonte(fonte);

		// Cria uma fila de prioridade mínima.
		MinPriorityQueue filaMenorPrioridade = new MinHeapPriorityQueue();

		// Insere cada DijkstraInfo numa
		// fila de prioridade minima.
		int cardV = grafo.getCardinalidadeVertice();
		for (int indice = 0; indice < cardV; indice++) {
			DijkstraInfo info = (DijkstraInfo) getMenorCaminhoInfo(indice);
			info.vertice = grafo.getVertice(indice);
			info.handle = filaMenorPrioridade.insert(info);
		}

		filaMenorPrioridade.decreaseKey(
				((DijkstraInfo) getMenorCaminhoInfo(fonte.getIndice())).handle,
				new Double(0));

		while (!filaMenorPrioridade.vazio()) {
			// Encontra o vértice na fila com a menor chave.
			DijkstraInfo uInfo = (DijkstraInfo) filaMenorPrioridade
					.extractMin();
			uInfo.handle = null; // não está mais na fila
			Vertice u = uInfo.vertice;
			double du = getMenorCaminhoInfo(u.getIndice()).getEstimativa();

			// Checa cada aresta incidente.
			ArestaPesadaIterator edgeIter = grafo.arestaPesadaIterator(u);

			while (edgeIter.hasNext()) {
				Vertice vertice = (Vertice) edgeIter.next();
				DijkstraInfo vInfo = (DijkstraInfo) getMenorCaminhoInfo(vertice
						.getIndice());
				double peso = edgeIter.getPeso();
				if (vInfo.relaxar(u, du, peso)) {
					// a estimativa de caminho mais curto para o vértice mudou,
					// então, atualiza a fila de menor prioridade.
					filaMenorPrioridade.decreaseKey(vInfo.handle, new Double(
							vInfo.getEstimativa()));
				}
			}
		}
	}

	protected MenorCaminhoInfo novoMenorCaminhoInfo() {
		return new DijkstraInfo();
	}

}