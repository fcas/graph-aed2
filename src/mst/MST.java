package mst;

import grafo.GrafoComoListaAdjacencia;

/** Interface for a class that computes a minimum spanning tree. */

public interface MST
{
   /**
    * Computes the minimum spanning tree of a weighted, undirected
    * graph.
    *
    * @param g The undirected graph.
    * @return The subgraph of <code>g</code> that is a minimum
    * spanning tree.
    */
   public GrafoComoListaAdjacencia computeMST(GrafoComoListaAdjacencia g);
}