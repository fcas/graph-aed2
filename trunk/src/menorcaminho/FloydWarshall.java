package menorcaminho;

import grafo.GrafoComoMatrizAdjacencia;

public class FloydWarshall extends TodosParesMenorCaminho {
    /** Calcula todos os pares dos caminhos mais curtos */
	public double[][] calculaCaminhosMaisCurtos(GrafoComoMatrizAdjacencia grafo) {
		int n = grafo.getCardinalidadeVertice();

	// O Array d tem três indices.  O primeiro indice é o
	// número de iteração, e dos restantes são os indices
	// do vértice i e j.
		double d[][][] = new double[n + 1][n][n];

	// d[0] peso da matriz.
		d[0] = graphToMatrix(grafo);

	// calculo.
		for (int k = 1; k <= n; k++) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					d[k][i][j] = Math.min(d[k - 1][i][j], d[k - 1][i][k - 1]
							+ d[k - 1][k - 1][j]);
		}

		return d[n];
	}

    /** Para a matriz [i][j], será true se existir caminho 
     * do vertice i ao j, false, caso contrário. 
     */
    
	public boolean[][] existeCaminho(GrafoComoMatrizAdjacencia grafo) {
		int n = grafo.getCardinalidadeVertice();

		boolean t[][][] = new boolean[n + 1][n][n];

		// inicia calculando t[0].
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				t[0][i][j] = (i == j) || grafo.existeAresta(i, j);

		// caulculo.
		for (int k = 1; k <= n; k++) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					t[k][i][j] = t[k - 1][i][j]
							|| (t[k - 1][i][k - 1] && t[k - 1][k - 1][j]);
		}

		return t[n];
	}
}

