package fila;

import excecoes.AtualizacaoChaveException;
import heap.ElementoDinamico;

/**
* Interface para uma fila de prioridade de minimo.
* Em classes que implementarem essa interface o construtor deve criar uma lista vazia.
*/

public interface FilaPrioridadeMinimo
{
	/**
	    * Insere um DynamicSetElement na fila de prioridade.
	    *
	    * @param x Elemento a ser inserido
	    * @return Um gerenciador para o item inserido. Esse gerenciador
	    * eh como o item eh acessado numa operacao de diminuir a chave.
    */
   public Object inserir(ElementoDinamico x);

   /**
    * Retorna o menor elemento na fila sem remove-lo.
    */
   public ElementoDinamico minimo();

   /**
    * Remove e retorna o maior elemento na fila de prioridade.
    */
   public ElementoDinamico extrairMinimo();
   
   /**
    * Diminui a chave de um dado elemento.
    *
    * @param element Handle que identifica o elemento. Esse Handle eh o dado como retorno do metodo insert.
    * @param newKey A nova chave para esse elemento.
    * @throws AtualizacaoChaveException Se a nova chave eh maior que o valor atual.
    */
   public void diminuirPrioridade(Object element, Comparable newKey)
	throws AtualizacaoChaveException;

   /**
    * Retorna true se a fila de prioridade estiver vazia e false caso contrario.
    */
   public boolean vazio();
}