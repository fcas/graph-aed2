package menorcaminho;

import grafo.Vertice;
import heap.DynamicSetElement;

public class DijkstraInfo extends MenorCaminhoInfo implements DynamicSetElement {

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
		return DynamicSetElement.Helper.compareTo(this, e);
	}
}
