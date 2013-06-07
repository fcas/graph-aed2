package menorcaminho;

import grafo.GrafoComoMatrizAdjacencia;

abstract public class TodosParesMenorCaminho {
    /** Calcula todos os pares de caminho mais curto.*/

	abstract public double[][] calculaCaminhosMaisCurtos(
			GrafoComoMatrizAdjacencia grafo);

    /** Converte um graf para uma matriz de arestas pesadas.*/
	protected double[][] graphToMatrix(GrafoComoMatrizAdjacencia grafo) {
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

    /**Imprime uma matriz */
	
	public static void imprimeMatriz(double[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++)
				System.out.print(matriz[i][j] + "  ");
			System.out.println();
		}
	}	

    /**Imprime uma matriz de boolenos*/
	
	public static void imprimeMatriz(boolean[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++)
				System.out.print((matriz[i][j] ? 1 : 0) + "  ");
			System.out.println();
		}
	}	
}
