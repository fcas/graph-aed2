package menorcaminho;

import grafo.Vertice;
import heap.ElementoDinamico;

public class DijkstraInfo extends MenorCaminhoInfo implements ElementoDinamico {

	public Vertice vertice;

	/** Identificador para a informaçào do vértice. */
	public Object handle;

	public DijkstraInfo() {
		super();
	}

	public void setChave(@SuppressWarnings("rawtypes") Comparable chave) {
		setEstimativa(((Double) chave).doubleValue());
	}

	@SuppressWarnings("rawtypes")
	public Comparable getChave() // a chave é a estimativa
	{
		return new Double(getEstimativa());
	}

	public int compareTo(Object e) {
		return ElementoDinamico.Helper.compareTo(this, e);
	}
}
