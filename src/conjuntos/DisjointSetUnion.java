package conjuntos;

/** Interface for a disjoint-set-union data structure from Chapter 21
* of <i>Introduction to Algorithms</i>, Second edition. */

public interface DisjointSetUnion
{
   /**
    * Makes a singleton set containing an object.
    *
    * @param x The object in the singleton set.
    * @return A handle that serves to identify the set in future
    * operations.
    */
   public Object makeSet(Object x);

   /**
    * Unites two sets, identified by handles to objects in the sets.
    * The original sets are destroyed.
    *
    * @param x Handle to an object in one set.
    * @param y Handle to an object in the other set.
    */
    public void union(Object x, Object y);

   /**
    * Returns the object that serves as the representative of the set
    * containing an object.
    *
    * @param x Handle to the object.
    * @return A handle to the representative of the set containing x.
    */
   public Object findSet(Object x);
}