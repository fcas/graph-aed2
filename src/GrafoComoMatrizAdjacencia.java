import java.util.Iterator;


public class GrafoComoMatrizAdjacencia implements Grafo{

	protected boolean direcionado;
	protected Vertice[] vertices;
	protected boolean[][] matriz;
    protected int ultimoAdicionado;
    protected int qtdArestas;
	
	public GrafoComoMatrizAdjacencia(int cardV, boolean direcionado) {
		this.direcionado = direcionado;
		ultimoAdicionado = -1;
		vertices = new Vertice[cardV];
		matriz = new boolean[cardV][cardV];

		for (int i = 0; i < cardV; i++)
			for (int j = 0; j < cardV; j++)
				matriz[i][j] = false;
		qtdArestas = 0;
	}
	
	public Vertice addVertice(String conteudo) {
		ultimoAdicionado++;
		vertices[ultimoAdicionado] = new Vertice(ultimoAdicionado, conteudo);
		return vertices[ultimoAdicionado];
	}
	
	@Override
	public Vertice adicionarVertice(String conteudo, int id) {
		ultimoAdicionado = id;
		vertices[ultimoAdicionado] = new Vertice(ultimoAdicionado, conteudo);
		return vertices[ultimoAdicionado];	
	}
	
	public Vertice adicionarVertice (Vertice v)
    {
		
	if (v.getId() == Vertice.INDICE_DESCONHECIDO) {
		ultimoAdicionado++;
	    v.setId(ultimoAdicionado);
	}
	
	else
		ultimoAdicionado = v.getId();

	vertices[ultimoAdicionado] = v;
	return v;
	
    }	

	@Override
	public Vertice getVertice(int id) {
		return vertices[id];
	}

	@Override
	public void adicionarAresta(Vertice origem, Vertice destino) {
		adicionarAresta(origem.getId(), destino.getId());
	}

	private void adicionarAresta(int idOrigem, int idDestino) {
		matriz[idOrigem][idDestino] = true;
		if (!direcionado)
		    matriz[idDestino][idOrigem] = true;

		qtdArestas++;
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorVertice() {
		return new VerticeIterator(vertices);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(Vertice verticeOndeIncide) {
		return new ArestaIterator(verticeOndeIncide.getId(), vertices, matriz);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iteradorAresta(int indiceVerticeOndeIncide) {
		return new ArestaIterator(indiceVerticeOndeIncide, vertices, matriz);
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
	return existeAresta(origem.getId(), destino.getId());
    }

	private boolean existeAresta(int idOrigem, int idDestino) {
		return matriz[idOrigem][idDestino];
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

}
