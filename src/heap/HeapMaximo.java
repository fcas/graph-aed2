package heap;

/**
* Implementa um heap de maximo binario.
* 
* @author AnderShow
*/

public class HeapMaximo extends Heap {
   /** Cria um heap vazio.*/
   public HeapMaximo()
   {
	super();
   }

   /**
    * Recebe um vetor, passa ele para o heap e depois se certifica
    * de que o vetor obedeca as propriedades de heap.
    * 
    * @param vetor Vetor do qual o heap sera criado.
    */
   HeapMaximo(Comparable[] array) {
	super(array);
   }
   
   public Ordenador makeSorter() {
	return new Heapsort();
   }

   /**
    * Restaura as propriedades de heap de maximo.
    *
    * @param i Indice da posicao do elemento que pode nao obedecer a propriedade de heap.
    */
   public void heapifica(int i) {
	int l = filhoEsq(i);
	int r = filhoDir(i);
	int smallest = i;
	if (l < heapTam && vetor[l].compareTo(vetor[i]) > 0)
	    smallest = l;
	if (r < heapTam && vetor[r].compareTo(vetor[smallest]) > 0)
	    smallest = r;
	if (smallest != i) {
	    troca(i, smallest);
	    heapifica(smallest);
	}
   }
   
   public class Heapsort implements Ordenador {
	/**
	 * Sorts an array of <code>Comparable</code> objects.
	 *
	 * @param array The array of <code>Comparable</code> objects
	 * to be sorted.
	 */
	public void sort(Comparable[] arrayToSort) {
	    // Since this method is within a class nested within Heap,
	    // there must be an existing Heap object that we can use.
	    vetor = arrayToSort;
	    heapTam = vetor.length;

	    // Enforce the heap property.
	    constroiHeap();

	    // Do the rest of the heapsort algorithm.
	    for (int i = vetor.length-1; i >= 1; i--) {
		troca(0, i);
		heapTam--;
		heapifica(0);
	    }
	}
   }
}