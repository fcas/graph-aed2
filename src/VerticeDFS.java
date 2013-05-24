import java.awt.Color;

public class VerticeDFS {

	/** tempo no qual o vertice foi descoberto **/
	private int d;

	/** tempo de termino da visita do vertice **/
	private int f;

	private Color cor;

	private Vertice predecessor;

	public VerticeDFS() {
		d = -1;
		f = -1;
		cor = Color.WHITE;
		predecessor = null;
	}


	public void setTempoDescoberta(int tempo) {
		d = tempo;
	}

	public int getTempoDescoberta() {
		return d;
	}

	
	public void setTempoTermino(int tempo) {
		f = tempo;
	}

	public int getTempoTermino() {
		return f;
	}

	public void setCor(Color c) {
		cor = c;
	}

	public Color getCor() {
		return cor;
	}

	public void setPredecessor(Vertice v) {
		predecessor = v;
	}

	public Vertice getPredecessor() {
		return predecessor;
	}

	public String toString() {
		String nomePai;

		if (predecessor == null)
			nomePai = "(null)";
		else
			nomePai = predecessor.getConteudo();

		return "d = " + d + ", f = " + f + ", pi = " + nomePai;
	}

}
