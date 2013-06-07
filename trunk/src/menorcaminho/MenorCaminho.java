package menorcaminho;

import grafo.GrafoComoListaAdjacencia;
import grafo.Vertice;

/** Classe para calcular o caminho mais curto, partindo de uma única fonte */

abstract public class MenorCaminho {
	
    public GrafoComoListaAdjacencia grafo;

    protected boolean naoExisteCicloNegativo;

	/**
	 * Cada posição do array, corresponde a um vértice do grafo, contendo a seu
	 * menor caminho
	 */
    
    private MenorCaminhoInfo[] menorCaminhoInfo;

	protected MenorCaminho(GrafoComoListaAdjacencia grafo) {
		this.grafo = grafo;
		naoExisteCicloNegativo = true; //ainda não foi encontrado
		menorCaminhoInfo = new MenorCaminhoInfo[grafo.getCardinalidadeVertice()];
	}

    /**Calcula o menor caminho a partir de um vértice fonte*/  
    abstract public void calculaMenorCaminho(Vertice fonte);

	public void inicializaUnicaFonte(Vertice fonte) {
		for (int i = 0; i < menorCaminhoInfo.length; i++) {
			menorCaminhoInfo[i] = menorCaminhoInfo();
		}

		getMenorCaminho(fonte).setEstimativa(0);
	}

	protected MenorCaminhoInfo menorCaminhoInfo() {
		return new MenorCaminhoInfo();
	}

    public boolean naoExisteCicloNegativo() {
		return naoExisteCicloNegativo;
	}

	public MenorCaminhoInfo getMenorCaminho(Vertice vertice) {
		return getMenorCaminhoInfo(vertice.getIndice());
	}

	public MenorCaminhoInfo getMenorCaminhoInfo(int indiceVertice) {
		return menorCaminhoInfo[indiceVertice];
	}
	
}