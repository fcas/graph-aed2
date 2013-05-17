import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GrafoComoListaAdjacencia implements Grafo {

	protected boolean direcionado;

	protected String ultimoVerticeAdicionado;

	protected int quantidadeArestas;

	private List<Vertice> listaAdjacencia = new ArrayList<Vertice>();

	public GrafoComoListaAdjacencia(boolean direcionado) {
		this.direcionado = direcionado;
	}

	public void setVertices(List<Vertice> listaAdjacenciaVertice) {
		this.listaAdjacencia.addAll(listaAdjacenciaVertice);
	}

	public Vertice adicionarVertice(Vertice novoVertice) {
		this.listaAdjacencia.add(novoVertice);
		return novoVertice;
	}

	public List<Vertice> getVertices() {
		return this.listaAdjacencia;
	}

	public Vertice encontrarVertice(String verticeBuscado) {

		for (int i = 0; i < this.getVertices().size(); i++) {

			if (verticeBuscado.equalsIgnoreCase(this.getVertices().get(i)
					.getConteudo())) {

				return this.getVertices().get(i);

			}
		}

		return null;

	}

	public void adicionarVertice(String conteudo, int id) {
		this.listaAdjacencia.add(new Vertice(conteudo, id));
	}

	@Override
	public Vertice getVertice(int id) {

		for (int i = 0; i < listaAdjacencia.size(); i++) {
			if (listaAdjacencia.get(i).equals(id)) {
				return listaAdjacencia.get(i);
			} else
				i = listaAdjacencia.size() + i;
		}

		return null;
	}

	@Override
	public void adicionarAresta(Vertice origem, Vertice destino) {

		if (!direcionado) {
			origem.getVizinhos().add(destino);
			destino.getVizinhos().add(origem);
		} else { 
			origem.getVizinhos().add(destino);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorVertice() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(Vertice u) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(int u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCardinalidadeVertice() {
		return listaAdjacencia.size();
	}

	@Override
	public int getCardinalidadeAresta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean ehDirecionado() {
		return direcionado;
	}

	@SuppressWarnings("rawtypes")
	public Iterator vertexIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Iterator edgeIterator(Vertice u) {
		// TODO Auto-generated method stub
		return null;
	}
}
