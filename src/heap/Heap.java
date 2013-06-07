package heap;

/**
 * Classe abstrata para heaps de minimo e maximo. Implementa metodos comuns a ambos.
 * Objetos da heap devem ser do tipo Comparable.
 * 
 * @author AnderShow
 **/

abstract public class Heap {
   /** Vetor que contem a heap. */
   protected static Comparable[] vetor;

   /** Numero de elementos da heap. */
   protected static int heapTam;
   
   /**
    * Garante a propriedade da heap para um dado elemento.
    *
    * @param i Indice da posicao do elemento que pode nao estar obedecendo
    * a propriedade.
    */
   abstract public void heapifica(int i);
   
   /**
    * Cria um heap vazio
    */
   public Heap()  {
	vetor = null;
	heapTam = 0;
   }

   /**
    * Recebe um vetor, passa ele para o heap e depois se certifica
    * de que o vetor obedeca as propriedades de heap.
    * 
    * @param vetor Vetor do qual o heap sera criado.
    */
   public Heap(Comparable[] vetor) {
	this.vetor = vetor;
	heapTam = vetor.length;
	constroiHeap();
   }

   /**
    * Metodo auxiliar para a troca de dois elementos de posicao.
    *
    * @param i indice do elemento a
    * @param j indice do elemento b
    */
   protected void troca(int i, int j) {
	Comparable c = vetor[i];
	vetor[i] = vetor[j];
	vetor[j] = c;
   }

   /**
    * Retorna o indice do pai de um no
    *
    * @param i O no que se quer que o pai seja retornado (i = filho)
    */
   public static final int pai(int i) {
	return (i-1) / 2;
   }

   /**
    * Retorna o indice do filho esquerdo de um no
    *
    * @param i O no que se quer que o filho esquerdo seja retornado (i = pai)
    */
   public static final int filhoEsq(int i) {
	return 2 * i + 1;
   }

   /**
    * Retorna o indice do filho direito de um no
    *
    * @param i O no que se quer que o filho direito seja retornado (i = pai)
    */
   public static final int filhoDir(int i) {
	return 2 * i + 2;
   }

   /**
    * Retorna true se o heap estiver vazio e false caso contrario.
    */
   public final boolean vazio() {
	return heapTam < 1;
   }

   /**
    * Retorna o primeiro elemento do heap sem remove-lo.
    * Se for uma heap de maximo, sera o maior elemento.
    * Numa heap de minimo sera o menor elemento.
    */
   public Comparable topo() {
	return vetor[0];
   }

   /**
    * Transforma um vetor qualquer em heap, ou seja,
    * faz com que todos os elementos obedecam a propriedade de heap.
    */
   public void constroiHeap() {
	// Heapifica de baixo para cima. 
	for (int i = vetor.length/2; i >= 0; i--)
	    heapifica(i);
   }
   

   /**
    * Classe aninhada para manuseios internos na heap. Sera usada
    * pelas subclasses MinHeapPriorityQueue e MaxHeapPriorityQueue.
    **/
   protected static class Handle implements Comparable {
	/** Indice do vetor da heap. */
	protected int indice;

	/** Informacao realmente armazenada. */
	protected ElementoDinamico info;

	/**
	 * Construtor padrao.
	 *
	 * @param indice Index into the heap's array.
	 * @param info Information stored.
	 */
	protected Handle(int indice, ElementoDinamico info) {
	    this.indice = indice;
	    this.info = info;
	}
	
	

	/**
	 * Compara o DynamicSetElement desse Handle com o de outro Handle.
	 *
	 * @param e O outro HandleThe other <code>Handle</code> object.
	 * @return Um inteiro negativo se o DynamicSetElement do Handle atual (this) for menor. 
	 * 0 se os objetos sao iguais e positivo se o DynamicSetElement atual for maior.
	 */
	public int compareTo(Object e) {
	    return info.compareTo(((Handle) e).info);
	}
   }
}