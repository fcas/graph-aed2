package heap;

import excecoes.RemocaoIncorretaException;
import excecoes.AtualizacaoChaveException;
import fila.FilaPrioridadeMinimo;

/**
* * Implementa uma fila de prioridade de minimo como heap.
* 
* @author AnderShow
*/

public class FilaHeapMinimo extends HeapMinimo implements FilaPrioridadeMinimo
{
	  /** Cria uma fila de prioridade de minimo vazia. */
   public FilaHeapMinimo()
   {
	super();
   }

   /**
   * Sobrepoe o metodo 'troca' para atualizar o indice de cada Handle.
   *
   * @param i indice de a.
   * @param j indice de b.
   */
   protected void troca(int i, int j)
   {
	((Handle) vetor[i]).indice = j;
	((Handle) vetor[j]).indice = i;
	super.troca(i,j);
   }
   
   /**
    * Sobe o elemento ate que ele seja maior ou igual ao seu pai, semelhantemente ao bubbleSort.
    *
    * @param i Indice do elemento.
    */
   private void bubbleUp(int i)
   {
	while (i > 0 && vetor[pai(i)].compareTo(vetor[i]) > 0) {
	    troca(i, pai(i));
	    i = pai(i);
	}
   }

   /**
   * Insere um DynamicSetElement na fila de prioridade.
    *
    * @param x Elemento a ser inserido
    * @return Um gerenciador para o item inserido. Esse gerenciador
    * eh como o item eh acessado numa operacao de diminuir a chave.
    */
   public Object inserir(ElementoDinamico x)
   {
	// Se o vetor nao existe, cria.
	if (vetor == null) {
	    vetor = new Comparable[1];
	    heapTam = 0;
	}
	// Se nao tem espaco suficiente para o elemento, dobra o tamanho do vetor.
	else if (heapTam >= vetor.length) {
	    Comparable[] temp = new Comparable[heapTam * 2];

	    for (int i = 0; i < heapTam; i++)
		temp[i] = vetor[i];

	    vetor = temp;
	}

	// Cria um novo Handle e coloca no proximo indice disponivel.
	Handle handle = new Handle(heapTam, x);
	vetor[heapTam] = handle;
	heapTam++;

	// Chama o metodo Bubble Up para o elemento subir na heap.
	bubbleUp(heapTam-1);

	// Retorna a referencia para o handle.
	return handle;
   }

   /**
    * Retorna o menor elemento na fila sem remove-lo.
    *
    * @throws RemocaoIncorretaException se a fila estiver vazia.
    */
   public ElementoDinamico minimo() throws RemocaoIncorretaException
   {
	if (heapTam > 0)
	    return ((Handle) vetor[0]).info;
	else {
	    throw new RemocaoIncorretaException();
	}
   }
   
   /**
    * Remove e retorna o menor elemento na fila de prioridade.
    * 
    * @throws RemocaoIncorretaException Se a fila de prioridade estiver vazia.
    */
   public ElementoDinamico extrairMinimo()
   {
	if (heapTam < 1)
	    throw new RemocaoIncorretaException();

	// Recebe a referencia do menor elemento.
	ElementoDinamico min = ((Handle) vetor[0]).info;

	// Move o ultimo elemento da heap para a raiz e limpa
	// a referencia na sua posicao atual do vetor
	vetor[0] = vetor[heapTam-1];
	((Handle) vetor[0]).indice = 0;
	vetor[heapTam-1] = null;
	heapTam--;

	// Restaura as propriedades da heap
	heapifica(0);

	return min;
   }
   
   /**
    * Diminui a chave de um dado elemento.
    *
    * @param element Handle que identifica o elemento. Esse Handle eh o dado como retorno do metodo insert.
    * @param newKey A nova chave para esse elemento.
    * @throws AtualizacaoChaveException Se a nova chave eh maior que o valor atual.
    */
   public void diminuirPrioridade(Object element, Comparable newKey)
	throws AtualizacaoChaveException
   {
	Handle handle = (Handle) element;

	if (newKey.compareTo(handle.info.getChave()) > 0)
	    throw new AtualizacaoChaveException();

	handle.info.setChave(newKey); // coloca a nova chave
	bubbleUp(handle.indice);	    // restaura a propriedade de heap.
   }

   
}