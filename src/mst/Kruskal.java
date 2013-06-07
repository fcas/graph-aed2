package mst;

import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;
import heap.HeapMaximo;

import java.util.Iterator;

import menorcaminho.ArestaPesadaIterator;

import conjuntos.ConjuntoDisjuntoFloresta;
import conjuntos.ConjuntoDisjunto;

@SuppressWarnings("rawtypes")
public class Kruskal implements MST {

	public GrafoComoListaAdjacencia calcularMST(GrafoComoListaAdjacencia grafo) {

		GrafoComoListaAdjacencia grafoMST = (GrafoComoListaAdjacencia) grafo
				.useSameVertices();

		ConjuntoDisjunto floresta = new ConjuntoDisjuntoFloresta();
		Object handle[] = new Object[grafoMST.getCardinalidadeVertice()];
		Iterator iteradorVertice = grafo.iteradorVertice();

		while (iteradorVertice.hasNext()) {
			Vertice v = (Vertice) iteradorVertice.next();
			handle[v.getIndice()] = floresta.gerarConjunto(v);
		}

		ArestaPeso[] aresta = new ArestaPeso[grafo.getCardinalidadeAresta()];
		int i = 0;
		iteradorVertice = grafo.iteradorVertice();
		while (iteradorVertice.hasNext()) {
			Vertice vertice = (Vertice) iteradorVertice.next();

			ArestaPesadaIterator edgeIter = grafo.arestaPesadaIterator(vertice);
			while (edgeIter.hasNext()) {
				Vertice v = (Vertice) edgeIter.next();

				if (vertice.getIndice() < v.getIndice()) {
					double peso = edgeIter.getPeso();
					aresta[i++] = new ArestaPeso(vertice, v, peso);
				}
			}
		}

		HeapMaximo heap = new HeapMaximo();
		(heap.makeSorter()).sort(aresta);

		for (i = 0; i < aresta.length; i++) {
			Object uHandle = handle[aresta[i].v1.getIndice()];
			Object vHandle = handle[aresta[i].v2.getIndice()];
			if (floresta.findSet(uHandle) != floresta.findSet(vHandle)) {
				grafoMST.adicionarAresta(aresta[i].v1, aresta[i].v2,
						aresta[i].peso);
				floresta.uniao(uHandle, vHandle);
			}
		}

		return grafoMST;
	}

	private static class ArestaPeso implements Comparable {

		public Vertice v1;

		public Vertice v2;

		public double peso;

		public ArestaPeso(Vertice a, Vertice b, double peso) {
			this.v1 = a;
			this.v2 = b;
			this.peso = peso;
		}

		public int compareTo(Object o) {
			ArestaPeso aresta = (ArestaPeso) o;
			if (peso < aresta.peso)
				return -1;
			else if (peso == aresta.peso)
				return 0;
			else
				return 1;
		}

		public String toString() {
			return "(" + v1.getConteudo() + "," + v2.getConteudo() + "," + peso
					+ ")";
		}
	}

}