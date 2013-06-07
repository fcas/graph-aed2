package fila;

import excecoes.AtualizacaoChaveException;
import heap.ElementoDinamico;

/**
* Interface para uma fila de prioridade de maximo.
* Em classes que implementarem essa interface o construtor deve criar uma lista vazia.
*/

public interface FilaPrioridadeMaximo
{
	   /**
	    * Insere um DynamicSetElement na fila de prioridade.
	    *
	    * @param x Elemento a ser inserido
	    * @return Um gerenciador para o item inserido. Esse gerenciador
	    * eh como o item eh acessado numa operacao de aumentar a chave.
	    */
   public Object inserir(ElementoDinamico x);

   /**
    * Retorna o maior elemento na fila sem remove-lo.
    */
   public ElementoDinamico maximo();
   
   /**
    * Remove e retorna o maior elemento na fila de prioridade.
    */
   public ElementoDinamico extrairMaximo();
   
   /**
    * Aumenta a chave de um dado elemento.
    *
    * @param element Handle que identifica o elemento. Esse Handle eh o dado como retorno do metodo insert.
    * @param newKey A nova chave para esse elemento.
    * @throws AtualizacaoChaveException Se a nova chave eh menor que o valor atual.
    */
   public void increaseKey(Object element, Comparable newKey)
	throws AtualizacaoChaveException;

   /**
    * Retorna true se a fila de prioridade estiver vazia e false caso contrario.
    */
   public boolean vazio();
}