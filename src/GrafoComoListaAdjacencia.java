import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public void adicionarAresta(int idOrigem, int idDestino) {

		Aresta x = new Aresta(adj[idDestino].esteVertice, adj[idOrigem].cabeca);
		adj[idOrigem].cabeca = x;

		if (!direcionado) {
			x = new Aresta(adj[idOrigem].esteVertice, adj[idDestino].cabeca);
			adj[idDestino].cabeca = x;
		}

		qtdArestas++;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorVertice() {
		return iteradorVertice();
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

}