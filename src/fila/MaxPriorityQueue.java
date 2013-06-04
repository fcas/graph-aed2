package fila;

import excecoes.KeyUpdateException;
import heap.DynamicSetElement;

/**
* Interface para uma fila de prioridade de maximo.
* Em classes que implementarem essa interface o construtor deve criar uma lista vazia.
*/

public interface MaxPriorityQueue
{
	   /**
	    * Insere um DynamicSetElement na fila de prioridade.
	    *
	    * @param x Elemento a ser inserido
	    * @return Um gerenciador para o item inserido. Esse gerenciador
	    * eh como o item eh acessado numa operacao de aumentar a chave.
	    */
   public Object insert(DynamicSetElement x);

   /**
    * Retorna o maior elemento na fila sem remove-lo.
    */
   public DynamicSetElement maximum();
   
   /**
    * Remove e retorna o maior elemento na fila de prioridade.
    */
   public DynamicSetElement extractMax();
   
   /**
    * Aumenta a chave de um dado elemento.
    *
    * @param element Handle que identifica o elemento. Esse Handle eh o dado como retorno do metodo insert.
    * @param newKey A nova chave para esse elemento.
    * @throws KeyUpdateException Se a nova chave eh menor que o valor atual.
    */
   public void increaseKey(Object element, Comparable newKey)
	throws KeyUpdateException;

   /**
    * Retorna true se a fila de prioridade estiver vazia e false caso contrario.
    */
   public boolean vazio();
}