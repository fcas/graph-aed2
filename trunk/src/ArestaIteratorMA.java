import java.util.Iterator;


@SuppressWarnings("rawtypes")
public class ArestaIteratorMA implements Iterator {

	/** The index of the vertex returned by the most recent call
	 * to <code>next</code>.  Initially, it is -1. */
	protected int current;
	Vertice[] vertices;
	protected boolean[][] matriz;

	/** The index of the vertex whose edges this iterator iterates
	 * through. */
	int u;

	/**
	 * Starts an iteration through the edges incident on a given
	 * vertex.
	 *
	 * @param u The index of the vertex.
	 * @param vertices 
	 * @param matriz 
	 */
	public ArestaIteratorMA(int u, Vertice[] vertices, boolean[][] matriz)
	{
		this.matriz = matriz;
		this.vertices = vertices;
	    this.u = u;
	    current = -1;
	}

	/** Returns <code>true</code> if this edge iterator has more
	 * edges, <code>false</code> otherwise. */
	public boolean hasNext()
	{
	    int v = current + 1; // next vertex to visit

	    // Keep going until we find a 'true' entry or run out of
	    // columns.
	    while (v < matriz[u].length && !matriz[u][v])
		v++;

	    return v < matriz[u].length;
	}

	/** Returns the next edge in the iteration. */
	public Object next()
	{
	    current++;		// start with next vertex

	    // Keep going until we find a 'true' entry.
	    while (!matriz[u][current])
		current++;

	    return vertices[current];
	}

	/**
	 * Unsupported.
	 *
	 * @throws UnsupportedOperationException always.
	 */
	public void remove()
	{
	    throw new UnsupportedOperationException();
	}


}
