package conjuntos;

public class DisjointSetForest implements DisjointSetUnion
{

   private static class Node
   {
	/** Reference to the object. */
	public Object theObject;

	/** Reference to this node's parent. */
	public Node p;

	/** This node's rank. */
	public int rank;

	/**
	 * Makes a node for a given object.
	 *
	 * @param x The object in this node.
	 */
	public Node(Object x)
	{
	    theObject = x;
	    p = this;
	    rank = 0;
	}

	/** Returns the <code>String</code> representation of this
	 * node. */
	public String toString()
	{
	    return theObject.toString() + ": p = " + p.theObject.toString() +
		", rank = " + rank;
	}
   }

   
   /**
    * Makes a singleton set containing an object.
    *
    * @param x The object in the singleton set.
    * @return A handle that serves to identify the set in future
    * operations.
    */
   public Object makeSet(Object x)
   {
	return new Node(x);
   }

   /**
    * Unites two sets, identified by handles to objects in the sets.
    * The original sets are destroyed.
    *
    * @param x Handle to an object in one set.
    * @param y Handle to an object in the other set.
    * @throws ClassCastException if either <code>x</code> or
    * <code>y</code> does not reference a <code>Node</code> object.
    */
   public void union(Object x, Object y)
   {
	link((Node) findSet(x), (Node) findSet(y));
   }

   /**
    * Returns the object that serves as the representative of the set
    * containing an object.
    *
    * @param x Handle to the object.
    * @return A handle to the representative of the set containing x.
    * @throws ClassCastException if <code>x</code> is not a reference
    * to a <code>Node</code> object.
    */
   public Object findSet(Object x)
   {
	Node nodeX = (Node) x;	// force x to be interpreted as a Node
	if (nodeX != nodeX.p)
	    nodeX.p = (Node) findSet(nodeX.p);
	return nodeX.p;
   }

   /**
    * Links together two sets, given their root nodes.  The root with
    * the larger rank becomes the parent of the root with the smaller
    * rank.  In case of a tie, we arbitrarily choose one root as the
    * parent of the other.
    *
    * @param x The root node of one set.
    * @param y The root node of the other set.
    */
   private void link(Node x, Node y)
   {
	if (x.rank > y.rank)
	    y.p = x;
	else {
	    x.p = y;
	    if (x.rank == y.rank)
		y.rank++;
	}
   }
}