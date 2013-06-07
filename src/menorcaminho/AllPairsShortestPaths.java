package menorcaminho;

import grafo.GrafoComoMatrizAdjacencia;

abstract public class AllPairsShortestPaths
{
    /** Computes all-pairs shortest paths.
     *
     * @param grafo A weighted graph represented as an adjacency matrix.
     * @return A matrix of shortest-path weights.
     */
    abstract public double[][]
	computeShortestPaths(GrafoComoMatrizAdjacencia grafo);

    /** Converts a {@link WeightedAdjacencyMatrixGraph} to a matrix of
     * edge weights.
     *
     * @param grafo A weighted graph represented as an adjacency matrix.
     * @return A matrix of edge weights.  Regardless of what the
     * adjacency matrix has along the diagonal, the returned matrix
     * has all zeros along the diagonal.
     */
    protected double[][] graphToMatrix(GrafoComoMatrizAdjacencia grafo)
    {
	int n = grafo.getCardinalidadeVertice();

	double[][] w = new double[n][n];
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++) {
		if (i == j)
		    w[i][j] = 0;
		else
		    w[i][j] = grafo.getPeso(i, j);
	    }

	return w;
    }

    /**
     * Prints out a 2-dimensional array of <code>double</code>.
     *
     * @param matrix The array to print.
     */
    public static void printMatrix(double[][] matrix)
    {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++)
		System.out.print(matrix[i][j] + "  ");
	    System.out.println();
	}
    }	

    /**
     * Prints out a 2-dimensional array of <code>boolean</code> as 0s
     * and 1s.
     *
     * @param matrix The array to print.
     */
    public static void printMatrix(boolean[][] matrix)
    {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++)
		System.out.print((matrix[i][j] ? 1 : 0) + "  ");
	    System.out.println();
	}
    }	
}
