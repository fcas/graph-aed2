package grafo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import menorcaminho.ArestaPesadaIterator;


public class GrafoComoListaAdjacencia implements Grafo {

	protected boolean direcionado;

	protected int ultimoVerticeAdicionado;

	protected int qtdArestas;

	@SuppressWarnings("unused")
	private List<Vertice> listaAdjacencia = new ArrayList<Vertice>();

	protected AdjListInfo[] adj;

	public GrafoComoListaAdjacencia(int cardV, boolean direcionado) {
		this.direcionado = direcionado;
		ultimoVerticeAdicionado = -1;
		adj = new AdjListInfo[cardV];
		qtdArestas = 0;
	}
	
	public Vertice adicionarVertice(String conteudo) {
		ultimoVerticeAdicionado++;
		adj[ultimoVerticeAdicionado] = new AdjListInfo(new Vertice(
				ultimoVerticeAdicionado, conteudo));
		return adj[ultimoVerticeAdicionado].esteVertice;
	}

	public Vertice adicionarVertice(String conteudo, int indice) {
		ultimoVerticeAdicionado = indice;
		adj[ultimoVerticeAdicionado] = new AdjListInfo(new Vertice(
				ultimoVerticeAdicionado, conteudo));
		return adj[ultimoVerticeAdicionado].esteVertice;
	}
	
	public Vertice adicionarVertice (Vertice v) {
		if (v.getIndice() == Vertice.INDICE_DESCONHECIDO) {
			ultimoVerticeAdicionado++;
			v.setIndice(ultimoVerticeAdicionado);
		} else
			ultimoVerticeAdicionado = v.getIndice();

		adj[ultimoVerticeAdicionado] = new AdjListInfo(v);
		return v;
	}

	public Vertice getVertice(int indice) {
		return adj[indice].esteVertice;
	}
	
	public void adicionarAresta (Vertice origem, Vertice destino) {

		int indiceOrigem = origem.getIndice();
		Aresta x = new Aresta(destino, adj[indiceOrigem].cabeca);
		adj[indiceOrigem].cabeca = x;

		if (!direcionado) {
			int indiceDestino = destino.getIndice();
			x = new Aresta(origem, adj[indiceDestino].cabeca);
			adj[indiceDestino].cabeca = x;
		}

		qtdArestas++;

	}
	
	public void adicionarAresta (Vertice origem, Vertice destino, double peso) {

		int indiceOrigem = origem.getIndice();
		Aresta x = new Aresta(destino, adj[indiceOrigem].cabeca);
		adj[indiceOrigem].cabeca = x;
		x.setPeso(peso);

		if (!direcionado) {
			int indiceDestino = destino.getIndice();
			x = new Aresta(origem, adj[indiceDestino].cabeca);
			adj[indiceDestino].cabeca = x;
			x.setPeso(peso);
		}

		qtdArestas++;

	}
	
	public void adicionarAresta(int idOrigem, int idDestino, double peso) {

		Aresta x = new Aresta(adj[idDestino].esteVertice, adj[idOrigem].cabeca);
		adj[idOrigem].cabeca = x;
		x.setPeso(peso);

		if (!direcionado) {
			x = new Aresta(adj[idOrigem].esteVertice, adj[idDestino].cabeca);
			adj[idDestino].cabeca = x;
			x.setPeso(peso);
		}

		qtdArestas++;

	}
	
	public void adicionarAresta(int idOrigem, int idDestino) {

		Aresta x = new Aresta(adj[idDestino].esteVertice, adj[idOrigem].cabeca);
		adj[idOrigem].cabeca = x;

		if (!direcionado) {
			x = new Aresta(adj[idOrigem].esteVertice, adj[idDestino].cabeca);
			adj[idDestino].cabeca = x;
		}

		qtdArestas++;

	}
	
	protected static class WeightedEdge extends Aresta
    {
		/** The weight of this edge. */
		private double pesoAresta;
	
		/**
		 * Creates a new edge.
		 *
		 * @param v The adjacent vertex.
		 * @param successor Successor edge to this one.
		 * @param peso The weight of the new edge.
		 */
		public WeightedEdge(Vertice v, Aresta successor, double peso)
			{
			    super(v, successor);
			    pesoAresta = peso;
			}
	
		/**
		 * Sets the weight of this edge.
		 *
		 * @param peso The new weight for this edge.
		 */
		public void setPesoAresta(double peso)
			{
			    pesoAresta = peso;
			}
	
		/** Returns the weight of this edge. */
		public double getWeight()
			{
			    return pesoAresta;
			}
    }

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorVertice() {
		return new VerticeIterator(adj);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(Vertice u) {
		return new ArestaIteratorLA(u.getIndice(), adj);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(int u) {
		return new ArestaIteratorLA(u, adj);
	}

	@Override
	public int getCardinalidadeVertice() {
		return adj.length;
	}

	@Override
	public int getCardinalidadeAresta() {
		return qtdArestas;
	}

	@Override
	public boolean ehDirecionado() {
		return direcionado;
	}

	//STACK OVERFLOW TAG
	public ArestaIteratorLA arestaIteratorLA(Vertice u) {
		return new ArestaIteratorLA(u.getIndice(), adj);
	}
	
	/**
	 * gera um grafo com os mesmos vertices sem arestas.
	 * @return
	 */
	public GrafoComoListaAdjacencia useSameVertices()
    {

		GrafoComoListaAdjacencia newGraph = makeEmptyGraph(adj.length, direcionado);

		for (int i = 0; i < adj.length; i++)
		    newGraph.adicionarVertice(adj[i].esteVertice);

		return newGraph;
    }
	 
	protected GrafoComoListaAdjacencia makeEmptyGraph(int cardV, boolean directed)
    {
		return new GrafoComoListaAdjacencia(cardV, directed);
    }
	
	public AdjListInfo[] getListaAdjacencia() {
		return adj;
	}

	

}