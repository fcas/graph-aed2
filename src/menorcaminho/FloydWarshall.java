package menorcaminho;

import grafo.GrafoComoMatrizAdjacencia;

public class FloydWarshall extends AllPairsShortestPaths
{
    /** Computes all-pairs shortest paths.
     *
     * @param g A weighted graph represented as an adjacency matrix.
     * @return A matrix of shortest-path weights.
     */
    public double[][] computeShortestPaths(GrafoComoMatrizAdjacencia g)
    {
	int n = g.getCardinalidadeVertice();

	// Array d is triply indexed.  The first index is the
	// iteration number, and the last two indices are the vertex
	// indices i and j.  Think of d as indexed by d[k][i][j].

	// Warning: Since i and j index vertices, they run from 0 to
	// n-1.  Since k indexes an iteration, it runs from 0 to n.
	// But when we use k to index a vertex, we need to subtract 1.
	double d[][][] = new double[n+1][n][n];

	// d[0] is the weight matrix.
	d[0] = graphToMatrix(g);

	// Run the main loop.
	for (int k = 1; k <= n; k++) {
	    for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		    d[k][i][j] = Math.min(d[k-1][i][j],
					  d[k-1][i][k-1] + d[k-1][k-1][j]);
	}

	return d[n];
    }

    /** Computes the transitive closure of a directed graph.
     *
     * @param grafo A graph represented as an adjacency matrix.
     * @return A transitive-closure matrix in which the [i][j] entry
     * is <code>true</code> if there is a path from vertex
     * <code>i</code> to vertex <code>j</code>, <code>false</code>
     * otherwise.
     */
    public boolean[][] computeTransitiveClosure(GrafoComoMatrizAdjacencia grafo)
    {
	int n = grafo.getCardinalidadeVertice();

	// Array t is triply indexed.  The first index is the
	// iteration number, and the last two indices are the vertex
	// indices i and j.  Think of t as indexed by t[k][i][j].

	// Warning: Since i and j index vertices, they run from 0 to
	// n-1.  Since k indexes an iteration, it runs from 0 to n.
	// But when we use k to index a vertex, we need to subtract 1.
	boolean t[][][] = new boolean[n+1][n][n];

	// Start by computing t[0].
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		t[0][i][j] = (i == j) || grafo.existeAresta(i, j);

	// Run the main loop.
	for (int k = 1; k <= n; k++) {
	    for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		    t[k][i][j] = t[k-1][i][j] ||
			(t[k-1][i][k-1] && t[k-1][k-1][j]);
	}

	return t[n];
    }
}

