package mst;

import fila.FilaPrioridadeMinimo;
import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;
import heap.ElementoDinamico;
import heap.FilaHeapMinimo;

import menorcaminho.ArestaPesadaIterator;

@SuppressWarnings("rawtypes")
public class Prim implements MST {

	public GrafoComoListaAdjacencia calcularMST(GrafoComoListaAdjacencia grafo) {

		FilaPrioridadeMinimo fila = new FilaHeapMinimo();

		int cardV = grafo.getCardinalidadeVertice();
		PrimInfo[] vertice = new PrimInfo[cardV];
		for (int i = 0; i < cardV; i++)
			vertice[i] = new PrimInfo(grafo.getVertice(i), fila);

		fila.diminuirPrioridade(vertice[0].verticeInfo, new Double(0));

		while (!fila.vazio()) {

			PrimInfo uInfo = (PrimInfo) fila.extrairMinimo();
			uInfo.verticeInfo = null;
			Vertice u = uInfo.vertice;

			ArestaPesadaIterator iteradorAresta = grafo.arestaPesadaIterator(u);

			while (iteradorAresta.hasNext()) {
				Vertice vert = (Vertice) iteradorAresta.next(); // auxiliar
				PrimInfo vInfo = vertice[vert.getIndice()];
				double peso = iteradorAresta.getPeso();
				if (vInfo.verticeInfo != null
						&& peso < vInfo.chave.doubleValue()) {

					vInfo.pai = u;
					fila.diminuirPrioridade(vInfo.verticeInfo, new Double(peso));
				}
			}
		}

		GrafoComoListaAdjacencia mst = (GrafoComoListaAdjacencia) grafo
				.useSameVertices();

		for (int i = 0; i < cardV; i++) {
			PrimInfo vInfo = vertice[i];
			if (vInfo.pai != null)
				mst.adicionarAresta(vInfo.pai, vInfo.vertice,
						vInfo.chave.doubleValue());
		}

		return mst;
	}

	private static class PrimInfo implements ElementoDinamico {

		public Vertice vertice;

		public Double chave;

		public Vertice pai;

		public Object verticeInfo;

		public PrimInfo(Vertice v, FilaPrioridadeMinimo fila) {
			vertice = v;
			chave = new Double(Double.POSITIVE_INFINITY);
			pai = null;
			verticeInfo = fila.inserir(this);
		}

		public void setChave(Comparable key) {
			this.chave = (Double) key;
		}

		public Comparable getChave() {
			return chave;
		}

		public int compareTo(Object e) {
			return ElementoDinamico.Helper.compareTo(this, e);
		}
	}
}