import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<Vertice> grafo = new ArrayList<Vertice>();

	public void setVertices(List<Vertice> listaAdjacenciaVertice) {

		this.grafo.addAll(listaAdjacenciaVertice);
	}

	public void adicionarVertice(Vertice novoVertice) {

		this.grafo.add(novoVertice);
	}

	public List<Vertice> getVertices() {

		return this.grafo;
	}

	public Vertice encontrarVertice(String verticeBuscado) {

		for (int i = 0; i < this.getVertices().size(); i++) {

			if (verticeBuscado.equalsIgnoreCase(this.getVertices().get(i).getConteudo())) {

				return this.getVertices().get(i);

			}
		}

		return null;

	}

}
