import java.util.Iterator;


@SuppressWarnings("rawtypes")
public class ArestaIteratorLA implements Iterator {

	/** The edge returned by the most recent call to
	 * <code>next</code>.  Initially, it is <code>null</code>. */
	protected Aresta current;

	/** The index of the vertex whose edges this iterator iterates
	 * through. */
	protected int index;

	/**
	 * Starts an iteration through the edges incident on a given
	 * vertex.
	 *
	 * @param v The index of the vertex.
	 * @param adj 
	 */
	
	AdjListInfo[] adj;
	
	public ArestaIteratorLA(int v, AdjListInfo[] adj)
	{
		this.adj = adj; 
	    index = v;
	    current = null;
	}

	/** Returns <code>true</code> if this edge iterator has more
	 * edges, <code>false</code> otherwise. */
	public boolean hasNext()
	{
	    if (current == null)
		return adj[index].cabeca != null;
	    else
		return current.proximo != null;
	}

	/** Returns the next edge in the iteration. */
	public Object next()
	{
	    if (current == null)
		current = adj[index].cabeca;
	    else
		current = current.proximo;

	    return current.vertice;
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
