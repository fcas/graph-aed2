package heap;

/**
* Implementa um heap de minimo binario.
*/

public class MinHeap extends Heap
{
   /** Cria um heap vazio.*/
   MinHeap()
   {
	super();
   }

   /**
    * Recebe um vetor, passa ele para o heap e depois se certifica
    * de que o vetor obedeca as propriedades de heap.
    * 
    * @param vetor Vetor do qual o heap sera criado.
    */
  MinHeap(Comparable[] array)
   {
	super(array);
   }

  /**
   * Restaura as propriedades de heap de minimo.
   *
   * @param i Indice da posicao do elemento que pode nao obedecer a propriedade de heap.
   */
   public void heapifica(int i)
   {
	int l = filhoEsq(i);
	int r = filhoDir(i);
	int smallest = i;
	if (l < heapTam && vetor[l].compareTo(vetor[i]) < 0)
	    smallest = l;
	if (r < heapTam && vetor[r].compareTo(vetor[smallest]) < 0)
	    smallest = r;
	if (smallest != i) {
	    troca(i, smallest);
	    heapifica(smallest);
	}
   }
}