package grafo;
import java.awt.Color;

public class VerticeBFS {

	//Distancia desse vertice a origem
	private int distancia;

	//Cor do vertice
	private Color cor;

	//Pai do vertice, no grafo de predecessores*/
	private Vertice pai;

	//A distancia inicialmente é maxima, a cor é
	//branca, e o pai é nulo</code>.
	
	public VerticeBFS() {
		distancia = Integer.MAX_VALUE;
		cor = Color.WHITE;
		pai = null;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setCor(Color c) {
		cor = c;
	}

	public Color getCor() {
		return cor;
	}

	public void setPredecessor(Vertice v) {
		pai = v;
	}

	public Vertice getPredecessor() {
		return pai;
	}

	public String toString() {
		String parentName;

		if (pai == null)
			parentName = "(null)";
		else
			parentName = pai.getConteudo();

		return "distancia = " + distancia + ", pai = " + parentName;
	}
}
