package conjuntos;

public class ConjuntoDisjuntoFloresta implements ConjuntoDisjunto {

	private static class No {
		public Object objeto;

		public No pai;

		public int rank;

		public No(Object x) {
			objeto = x;
			pai = this;
			rank = 0;
		}

		public String toString() {
			return objeto.toString() + ": p = " + pai.objeto.toString()
					+ ", rank = " + rank;
		}
	}

	public Object gerarConjunto(Object x) {
		return new No(x);
	}

	public void uniao(Object x, Object y) {
		unir((No) findSet(x), (No) findSet(y));
	}

	public Object findSet(Object x) {
		No nodeX = (No) x;
		if (nodeX != nodeX.pai)
			nodeX.pai = (No) findSet(nodeX.pai);
		return nodeX.pai;
	}

	private void unir(No x, No y) {
		if (x.rank > y.rank)
			y.pai = x;
		else {
			x.pai = y;
			if (x.rank == y.rank)
				y.rank++;
		}
	}
}