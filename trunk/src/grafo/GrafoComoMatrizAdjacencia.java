package grafo;
import java.util.Iterator;



public class GrafoComoMatrizAdjacencia implements Grafo{

	public static final double absent = Double.MAX_VALUE;
	protected boolean direcionado;
	protected Vertice[] vertices;
	protected double[][] matriz;
    protected int ultimoAdicionado;
    protected int qtdArestas;
	
	public GrafoComoMatrizAdjacencia(int cardV, boolean direcionado) {
		this.direcionado = direcionado;
		ultimoAdicionado = -1;
		vertices = new Vertice[cardV];
		matriz = new double[cardV][cardV];

		for (int i = 0; i < cardV; i++)
			for (int j = 0; j < cardV; j++)
				matriz[i][j] = absent;
		qtdArestas = 0;
	}
	
	public Vertice addVertice(String conteudo) {
		ultimoAdicionado++;
		vertices[ultimoAdicionado] = new Vertice(ultimoAdicionado, conteudo);
		return vertices[ultimoAdicionado];
	}
	
	@Override
	public Vertice adicionarVertice(String conteudo, int indice) {
		ultimoAdicionado = indice;
		vertices[ultimoAdicionado] = new Vertice(ultimoAdicionado, conteudo);
		return vertices[ultimoAdicionado];	
	}
	
	public Vertice adicionarVertice (Vertice v)
    {
		
	if (v.getIndice() == Vertice.INDICE_DESCONHECIDO) {
		ultimoAdicionado++;
	    v.setIndice(ultimoAdicionado);
	}
	
	else
		ultimoAdicionado = v.getIndice();

	vertices[ultimoAdicionado] = v;
	return v;
	
    }	

	@Override
	public Vertice getVertice(int id) {
		return vertices[id];
	}

	@Override
	public void adicionarAresta(Vertice origem, Vertice destino) {
		throw new UnsupportedOperationException();
//		adicionarAresta(origem.getIndice(), destino.getIndice());
	}

	private void adicionarAresta(int idOrigem, int idDestino) {
		throw new UnsupportedOperationException();
				
//		matriz[idOrigem][idDestino] = true;
//		if (!direcionado)
//		    matriz[idDestino][idOrigem] = true;
//
//		qtdArestas++;
		
	}
	
	public void addEdge(Vertice u, Vertice v, double weight)
    {
		int uIndex = u.getIndice();
		int vIndex = v.getIndice();
	
		matriz[uIndex][vIndex] = weight;
		if (!direcionado)
		    matriz[vIndex][uIndex] = weight;
    }

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorVertice() {
		return new VerticeIterator(vertices);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(Vertice verticeOndeIncide) {
		return new ArestaIteratorMA(verticeOndeIncide.getIndice(), vertices, matriz);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(int indiceVerticeOndeIncide) {
		return new ArestaIteratorMA(indiceVerticeOndeIncide, vertices, matriz);
	}

	@Override
	public int getCardinalidadeVertice() {
		return vertices.length;
	}

	@Override
	public int getCardinalidadeAresta() {
		return qtdArestas;
	}

	@Override
	public boolean ehDirecionado() {
		return direcionado;
	}
	
	public boolean existeAresta(Vertice origem, Vertice destino)
    {
	return existeAresta(origem.getIndice(), destino.getIndice());
    }

	public boolean existeAresta(int idOrigem, int idDestino) {
		return matriz[idOrigem][idDestino]!=absent;
	}
	
	@SuppressWarnings("rawtypes")
	public String toString()
    {
		String result = "";

		Iterator verticeIter = iteradorVertice();
	while (verticeIter.hasNext()) {
	    Vertice u = (Vertice) verticeIter.next();
	    result += u + ":\n";

	    Iterator edgeIter = iteradorAresta(u);
	    while (edgeIter.hasNext()) {
		Vertice v = (Vertice) edgeIter.next();
		result += "    " + v + "\n";
	    }
	}

	return result;
	
    }

	 public double getWeight(Vertice u, Vertice v)
	    {
		return getPeso(u.getIndice(), v.getIndice());
	    }
	
	public double getPeso(int i, int j) {
		return matriz[i][j];
	}

}
