import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
		
	private VerticeBFS[] verticeInfo;

	public void search(GrafoComoListaAdjacencia grafo, Vertice vertice) {

		verticeInfo = new VerticeBFS[grafo.getCardinalidadeVertice()];
		for (int i = 0; i < verticeInfo.length; i++)
			verticeInfo[i] = new VerticeBFS();

		VerticeBFS sInfo = getBFSInfo(vertice);
		sInfo.setCor(Color.GRAY);
		sInfo.setDistancia(0);

		Queue<Integer> fila = new LinkedList<Integer>();
		fila.add(vertice.getIndice());

		while (!fila.isEmpty()) {
			Vertice u = grafo.getVertice(fila.poll());
			VerticeBFS uInfo = getBFSInfo(u);
			int uDistance = uInfo.getDistancia();

			// Enqueue each undiscovered vertex adjacent to u.
			@SuppressWarnings("rawtypes")
			Iterator iter = grafo.iteradorAresta(u);

			while (iter.hasNext()) {
				Vertice aux = (Vertice) iter.next();
				VerticeBFS vInfo = getBFSInfo(aux);

				if (vInfo.getCor() == Color.WHITE) {
					vInfo.setCor(Color.GRAY);
					vInfo.setDistancia(uDistance + 1);
					vInfo.setPredecessor(u);
					fila.add(aux.getIndice());
				}
			}

			uInfo.setCor(Color.BLACK);
		}
	}

	public VerticeBFS getBFSInfo(Vertice v) {
		return getBFSInfo(v.getIndice());
	}

	public VerticeBFS getBFSInfo(int v) {
		return verticeInfo[v];
	}
}

