package menorcaminho;

import grafo.Vertice;

public class MenorCaminhoInfo
{
    private double menorCaminho;

    /** Vértice predecessor (pai) para esse vértice */
    private Vertice pai;

    /** Inicializa a estimativa do menor caminho como infinita 
     * e o predecessor como nulo */
	
    public MenorCaminhoInfo() {
		menorCaminho = Double.POSITIVE_INFINITY;
		pai = null;
	}

	public void setEstimativa(double novaEstimativa) {
		menorCaminho = novaEstimativa;
	}

	public double getEstimativa() {
		return menorCaminho;
	}

    public void setPredecessor(Vertice vertice){
    	pai = vertice;
    }

	public Vertice getPredecessor() {
		return pai;
	}


   /* Retorna true se a estimativa para o vértice mudar, false, caso contrário.*/
	
	public boolean relaxar(Vertice origem, double estimativa, double peso) {
		double novoPeso = estimativa + peso;
		if (novoPeso < menorCaminho) {
			menorCaminho = novoPeso;
			pai = origem;
			return true;
		} else
			return false;
	}	

    public String toString() {
		String parentName;

		if (pai == null)
			parentName = "(null)";
		else
			parentName = pai.getConteudo();

		return "d = " + menorCaminho + ", pi = " + parentName;
	}
}