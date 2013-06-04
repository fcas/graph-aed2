package grafo;
import java.util.Iterator;


@SuppressWarnings("rawtypes")
public class VerticeIterator implements Iterator {

	protected int ultimoVisitado;
	Vertice[] vertices; 
	
	public VerticeIterator(Vertice[] vertices)
	{
		this.vertices = vertices;
	    ultimoVisitado = -1;
	}

	public boolean hasNext()
	{
	    return ultimoVisitado < vertices.length-1;
	}

	
	public Object next()
	{
	    return vertices[++ultimoVisitado];
	}

	public void remove()
	{
	    throw new UnsupportedOperationException();
	}

}
