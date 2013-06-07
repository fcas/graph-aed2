package menorcaminho;

import grafo.Vertice;
import heap.DynamicSetElement;

/** Inner class to maintain the <code>Vertex</code> object, key,
 * parent, and handle into the priority queue for each vertex.
 * The key (shortest-path estimate) and parent are inherited from
 * the superclass {@link ShortestPathInfo}. */
public class DijkstraInfo extends MenorCaminhoInfo implements DynamicSetElement
{
/** The vertex. */
public Vertice vertice;

/** A handle to the vertex's information in the priority
 * queue, or <code>null</code> if the vertex is not in the
 * priority queue. */
public Object handle;

/** Creates a <code>DijkstraInfo</code> object.  The instance
 * variables <code>theVertex</code> and <code>handle</code>
 * fields will have to be set by the caller. */
public DijkstraInfo()
{
    super();
}

/**
 * Sets the key.
 *
 * @param key The new key value.
 */
public void setKey(@SuppressWarnings("rawtypes") Comparable key)
{
    setEstimativa(((Double) key).doubleValue());
}

/** Returns the value of the key. */
@SuppressWarnings("rawtypes")
public Comparable getKey()
{
    return new Double(getEstimativa());
}

/**
 * Compares the key of this object's vertex to that of
 * another.
 *
 * @param e The other <code>DijkstraInfo</code> object.
 * @return A negative integer if the key of this object's
 * vertex is less; 0 if the keys are equal; a positive integer
 * if the key of this object's vertex is greater.
 */
public int compareTo(Object e)
{
    return DynamicSetElement.Helper.compareTo(this, e);
}
}

