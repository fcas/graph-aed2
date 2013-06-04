package heap;

/**
* Implementa um heap de maximo binario.
*/

public class MaxHeap extends Heap
{
   /** Cria um heap vazio.*/
   MaxHeap()
   {
	super();
   }

   /**
    * Recebe um vetor, passa ele para o heap e depois se certifica
    * de que o vetor obedeca as propriedades de heap.
    * 
    * @param vetor Vetor do qual o heap sera criado.
    */
   MaxHeap(Comparable[] array)
   {
	super(array);
   }

   /**
    * Restaura as propriedades de heap de maximo.
    *
    * @param i Indice da posicao do elemento que pode nao obedecer a propriedade de heap.
    */
   public void heapifica(int i)
   {
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
}